package conexao;

import logger.LogService;
import model.Onibus;
import model.Passageiro;
import view.Formulario;
import view.Index;
import view.NotFound;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ConectionHandler implements Runnable {

    public static Onibus onibus = new Onibus();
    private final Socket s;
    private final String REMOTEADDR;

    public ConectionHandler(Socket s) {
        this.s          = s;
        this.REMOTEADDR = s.getInetAddress().getHostAddress();
    }

    public static void handle(Socket s) {
        new Thread(new ConectionHandler(s)).start();
    }

    @Override
    public void run() {
        try {
            byte[]     buffer     = new byte[1024];
            int        tam        = s.getInputStream().read(buffer);
            Requisicao requisicao = new Requisicao(new String(buffer, 0, tam));

            LogService.log(REMOTEADDR + '\n' + requisicao);

            String pagina = null;

            switch ( requisicao.getPaginaReq() ) {
                case "/":
                    pagina = new Index().render();
                    break;

                case "/formulario":
                    pagina = new Formulario(requisicao).render();
                    break;

                case "/compra":
                    if ( onibus.venderLugar(Integer.parseInt(requisicao.getParams()
                            .get("lugar")), new Passageiro(requisicao.getParams().get("nome"))) ) {
                        pagina = new Index("alert('reservado com sucesso')").render();
                    } else {
                        pagina = new Index("alert('Lugar não pôde ser reservado')").render();
                    }

                    break;

                default:
                    pagina = new NotFound().render();
            }

            s.getOutputStream().write((pagina).getBytes(StandardCharsets.UTF_8));

            s.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}