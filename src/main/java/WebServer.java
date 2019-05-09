
import model.Onibus;
import model.ThreadConexao;
import view.Index;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static String page = new Index().getBody();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8888);
        Onibus on = new Onibus("SM-POA", "08/04/2019");
        while (true) {
            Socket s = ss.accept();
            new Thread(new ThreadConexao(s,on)).start();

        }
    }

    public static void setPage(String page) {
        WebServer.page = page;
    }


}
