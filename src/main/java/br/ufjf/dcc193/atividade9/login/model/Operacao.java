package br.ufjf.dcc193.atividade9.login.model;

import java.util.Date;

import lombok.Data;

@Data
public class Operacao {
    
    private Integer idOperacao;
    private String partida;
    private String conta;
    private Date dataHora;
    private Double montante;
    private String operacao = "";
    private String destino = "";
}
