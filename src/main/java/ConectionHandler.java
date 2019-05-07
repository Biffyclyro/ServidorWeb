import model.Html;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConectionHandler {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket s = ss.accept();
            new ConectionHandler().executaThread(s);

        }
    }

    public void executaThread(Socket s){
        new Thread(new ThreadConexao(s)).start();
    }

    public class ThreadConexao implements Runnable{

        private Socket s;

        public ThreadConexao(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            while(true){
                try {

                    byte[] buffer = new byte[1024];

                    int tam = s.getInputStream().read(buffer);

                    String req = new String(buffer, 0, tam);
                    String[] linhas = req.split("\n");
                    String[] primeira = linhas[0].split(" ");

                    System.out.println("COMANDO = " + primeira[0]);
                    System.out.println("DOCUMENTO = " + primeira[1]);
                    System.out.println(req);
                    System.out.println("\n----------------------\n\n");
                    s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n\n").getBytes("UTF-8"));
                    s.getOutputStream().write((Html.getHeader() + "<h1>Olá</h1>" + Html.getFooter()).getBytes("UTF-8"));
                    // s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/Html charset=UTF-8\n\n" + "<Html><body><h3>Olá</h3></body></Html>").getBytes());


                    s.close();
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }



}