package model;

import model.Lugar;

import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public  class Onibus {
    private static String linha = "POA-SM";
    private static String diaViagem= "09/05/2019";
    private static ArrayList<Lugar> lugares = new ArrayList<>();
    private static final int LUGARES = 52;
    private static int vagas =52;

    public Onibus() {

        for (int i = 0; i<LUGARES; i++){lugares.add(new Lugar(i+1));}

    }

    public static void main(String[] args) {
        lugares.forEach(System.out::println);
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



    public static int getVagas() {
        return vagas;
    }

    public static ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public static String getLinha() {
        return linha;
    }



    public static String getDiaViagem() {
        return diaViagem;
    }


}