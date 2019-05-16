package model;

import java.time.LocalDateTime;

public class Lugar {
    private int           numero;
    private Passageiro    passageiro;
    private boolean       reservado = false;
    private LocalDateTime dataTempo;

    public Lugar(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public LocalDateTime getDataTempo() {
        return dataTempo;
    }

    public void setDataTempo(LocalDateTime dataTempo) {
        this.dataTempo = dataTempo;
    }

}