
import conexao.ConectionHandler;
import logger.LogService;

import java.io.IOException;
import java.net.ServerSocket;

public class WebServer {

    private static final int PORTA = 8888;

    public static void main(String[] args) throws IOException {

        LogService logSrvc = LogService.logServiceBuilder();

        ServerSocket ss = new ServerSocket(PORTA);
        LogService.log("Ouvindo na porta "+ PORTA);

        while ( true ) {
            ConectionHandler.handle(ss.accept());
        }
    }
}
