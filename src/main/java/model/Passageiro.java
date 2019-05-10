package model;

import java.util.Date;

public class Passageiro {
    private String nome;
    private Date dataPassagem;
    private String requisicao;

    public Passageiro(String nome){
        this.nome = nome;
        //this.dataPassagem = dataAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAtual() {
        return dataPassagem;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataPassagem = dataAtual;
    }

    public String getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(String requisicao) {
        this.requisicao = requisicao;
    }
}