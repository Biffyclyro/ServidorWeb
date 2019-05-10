package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Onibus {

    private static ArrayList<Lugar> lugares = new ArrayList<>();
    private static final int LUGARES = 53;
    private static int vagasRestantes = 53;

    public Onibus() {

        for ( int i = 0; i < LUGARES; i++ ) {
            lugares.add(new Lugar(i+1));
        }
    }

    public boolean venderLugar(int numeroLugar, Passageiro passageiro) {
        synchronized ( lugares ) {
            Lugar lugar = lugares.get(numeroLugar);

            if ( !lugar.isReservado() ) {
                lugar.setReservado(true);
                lugar.setPassageiro(passageiro);
                lugar.setDataTempo(LocalDateTime.now());

                vagasRestantes--;
                return true;
            }
        }
        return false;
    }

    public static int getVagasRestantes() {
        return vagasRestantes;
    }

    public static ArrayList<Lugar> getLugares() {
        return lugares;
    }
}