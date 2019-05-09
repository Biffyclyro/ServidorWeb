package model;


import controller.ControllerIndex;
import view.Index;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadConexao implements Runnable {

    private Socket s;
    private Onibus onibus;
    private static String page = new Index().getBody();

    public ThreadConexao(Socket s, Onibus on) {
        this.s = s;
        this.onibus = on;


    }

    @Override
    public void run() {
        while(true){
            try {

                byte[] buffer = new byte[1024];

                int tam = s.getInputStream().read(buffer);

                String req = new String(buffer, 0, tam);

                Requisicao requisicao = new Requisicao(req);
                new ControllerIndex(requisicao, onibus);




                //System.out.println(req);
                System.out.println("\n----------------------\n\n");
                s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n\n").getBytes("UTF-8"));
                s.getOutputStream().write((page).getBytes("UTF-8"));
                // s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/Html charset=UTF-8\n\n" + "<Html><body><h3>Olá</h3></body></Html>").getBytes());


                s.close();
                break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void setPage(String p) {
        page = p;
    }
}