package model;


import view.Formulario;
import view.Index;
import view.Pagina;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ThreadConexao implements Runnable {

    private Socket s;
    public  Map<String, Class<? extends Pagina>> rotas = new HashMap<>();
    public static Onibus onibus = new Onibus();
    public ThreadConexao(Socket s) {
        this.s = s;
        rotas.put("/", Index.class);
        rotas.put("/formulario", Formulario.class);
    }

    @Override
    public void run() {
        while(true){
            try {

                byte[] buffer = new byte[1024];

                int tam = s.getInputStream().read(buffer);

                String req = new String(buffer, 0, tam);

                Requisicao requisicao = new Requisicao(req);

                String page;
                if(requisicao.getPaginaReq().equals("/")){
                    page = new Index().render();

                }  else {
                    page = new Formulario().render();


                }
                s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n\n").getBytes("UTF-8"));
                s.getOutputStream().write((page).getBytes("UTF-8"));

                //System.out.println(req);
                //System.out.println("\n----------------------\n\n");

                // s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/Html charset=UTF-8\n\n" + "<Html><body><h3>Olá</h3></body></Html>").getBytes());


                s.close();
                break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

   // public static void setPage(String p) {
    //    page = p;
    //}
}