package model;

import model.Lugar;

import java.util.ArrayList;
import java.util.Date;

public class Onibus {
    private String linha;
    private String diaViagem;
    private ArrayList<Lugar> lugares = new ArrayList<>();
    private int LUGARES = 42;
    private int vagas =42;

    public Onibus(String linha, String diaViagem) {
        this.linha = linha;
        this.diaViagem = diaViagem;
        for (int i = 0; i<42; i++){lugares.add(new Lugar(i+1));}

    }



    public boolean venderLugar(int numeroLugar, Passageiro passageiro){
        if (lugares.get(numeroLugar).isReservado()==false){
            lugares.get(numeroLugar).setReservado(true);
            lugares.get(numeroLugar).setPassageiro(passageiro);

            this.vagas --;
            return true;
        }else{
            return false;
        }
    }

    public int getVagas() {
        return vagas;
    }

    public ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getDiaViagem() {
        return diaViagem;
    }

    public void setDiaViagem(String diaViagem) {
        this.diaViagem = diaViagem;
    }
}