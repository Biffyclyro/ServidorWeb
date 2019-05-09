package controller;

import model.Onibus;
import model.Requisicao;
import model.ThreadConexao;
import view.Formulario;

public class ControllerIndex {
    private int lugar;
    private Onibus onibus;

    public ControllerIndex(Requisicao requisicao, Onibus on) {

        this.lugar = Integer.parseInt(requisicao.getParams().get("lugar"));
        this.onibus=on;

        if(onibus.getLugares().get(lugar).isReservado()==true || onibus.getVagas()==0){
            ThreadConexao.setPage(new Formulario().getBody());
        }else {

        }
    }






}
