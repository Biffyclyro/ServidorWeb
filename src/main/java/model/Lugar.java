package model;

public class Lugar {
    private int numero;
    private Passageiro passageiro;
    private boolean reservado=false;

    public Lugar(int numero) {
        this.numero = numero;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getNumero() {return numero;}

    public boolean isReservado() {
        return reservado;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}