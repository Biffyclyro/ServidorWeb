
import logger.LogService;
import model.Onibus;
import model.ThreadConexao;
import view.Index;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    static final int PORTA = 8888;


    public static void main(String[] args) throws IOException {
        LogService logSrvc = LogService.logServiceBuilder();
        ServerSocket ss = new ServerSocket(PORTA);
        LogService.log("Ouvindo na porta "+ PORTA);
        //Onibus on = new Onibus("SM-POA", "08/04/2019");
        while (true) {
            Socket s = ss.accept();
            new Thread(new ThreadConexao(s)).start();

        }
    }




}
