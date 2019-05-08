package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Logger implements Runnable {
    private final int TAM_MAX_BUFFER =10;
    private final Queue<String> buffer = new LinkedList<>();
    private Object cheio = new Object();
    private Object vazio = new Object();


    public void writeBuffer(){


        while (true){
            if (buffer.size()==TAM_MAX_BUFFER){
                synchronized (cheio){
                    try{
                        cheio.wait();
                    }catch (InterruptedException e){e.printStackTrace();}
                }

                synchronized (buffer){
                    buffer.add("olá");
                }

                synchronized (vazio){
                    if(buffer.size()==1){
                        vazio.notify();
                    }
                }
            }
        }
    }

    @Override
    public void run() {

        while (true){
            synchronized (vazio){
                if (buffer.size()==0){

                    try {
                        vazio.wait();
                    }catch (InterruptedException e){e.printStackTrace();}
                }

                synchronized (buffer){
                    buffer.remove();
                }


                synchronized (cheio){

                    cheio.notify();

                }
            }

        }

    }

}
