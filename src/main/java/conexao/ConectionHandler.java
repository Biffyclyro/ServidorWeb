package conexao;


import model.Onibus;
import view.Formulario;
import view.Index;
import view.NotFound;

import java.io.IOException;
import java.net.Socket;

public class ConectionHandler implements Runnable {

    private Socket s;
    public static Onibus onibus = new Onibus();

    public ConectionHandler(Socket s) {
        this.s = s;
    }

    public static void handle(Socket s) {
        new Thread(new ConectionHandler(s)).start();
    }

    @Override
    public void run() {
        try {

            byte[] buffer = new byte[1024];

            int tam = s.getInputStream().read(buffer);

            String req = new String(buffer, 0, tam);

            Requisicao requisicao = new Requisicao(req);

            String pagina  = null;

            switch ( requisicao.getPaginaReq() ) {
                case "/":
                    pagina = new Index().render();
                    break;

                case "/formulario":
                    pagina = new Formulario(requisicao).render();
                    break;

                default:
                    pagina = new NotFound().render();
            }

            s.getOutputStream().write((pagina).getBytes("UTF-8"));

            s.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}