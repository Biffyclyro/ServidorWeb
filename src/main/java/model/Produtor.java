package model;



public class Produtor implements Runnable{

    @Override
    public void run() {
        while (true){
            if (Logger.getBuffer().size()==Logger.getTAM_MAX_BUFFER()){
                synchronized (Logger.getCheio()){
                    try{
                        Logger.getCheio().wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                synchronized (Logger.getBuffer()){
                    Logger.adicionaBuffer("olá");
                }

                synchronized (Logger.getVazio()){
                    if(Logger.getBuffer().size()==1){
                        Logger.getVazio().notify();
                    }
                }


            }
        }
    }
}
