package model;

import java.util.ArrayList;

public class ConsultaLugar implements Runnable {
    private Onibus onibus;
    private Lugar lugar;
    private Object monitor;
    private int vagas;
    private ArrayList<Lugar> lugares;


    @Override
    public void run() {
        while (true){
            synchronized (monitor){
                this.vagas = onibus.getVagas();
                this.lugares = onibus.getLugares();
            }
        }
    }
}