package model;


import model.Passageiro;

public class CompraPassagem implements Runnable {
    private Passageiro passageiro;
    private Object monitor;
    private Onibus onibus;
    private int lugar;

    public CompraPassagem(Passageiro passageiro, Object monitor, Onibus onibus, int lugar) {
        this.passageiro = passageiro;
        this.monitor = monitor;
        this.onibus = onibus;
        this.lugar = lugar;
    }

    @Override
    public void run() {
        while (true){
            synchronized (monitor){
                onibus.venderLugar(lugar, passageiro);
            }
        }
    }
}