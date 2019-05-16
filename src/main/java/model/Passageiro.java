package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Passageiro {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM");
    private              String            nome;
    private              LocalDateTime     dataPassagem;
    private              String            requisicao;

    public Passageiro(String nome) {
        this.nome         = nome;
        this.dataPassagem = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataPassgem() {
        return dataPassagem.format(formatter);
    }

    public String getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(String requisicao) {
        this.requisicao = requisicao;
    }
}