package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Onibus {

    private static final int              LUGARES = 53;
    private static       ArrayList<Lugar> lugares = new ArrayList<Lugar>(LUGARES);

    public Onibus() {

        for ( int i = 0; i < LUGARES; i++ ) {
            lugares.add(new Lugar(i + 1));
        }
    }

    public static ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public boolean venderLugar(int numeroLugar, Passageiro passageiro) {
        Lugar lugar = lugares.get(numeroLugar);

        synchronized ( lugares ) {
            if ( !lugar.isReservado() ) {
                lugar.setReservado(true);
            } else {
                return false;
            }
        }
        lugar.setPassageiro(passageiro);
        lugar.setDataTempo(LocalDateTime.now());

        return true;
    }
}