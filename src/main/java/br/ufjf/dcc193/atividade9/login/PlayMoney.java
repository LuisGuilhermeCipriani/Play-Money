package br.ufjf.dcc193.atividade9.login;

import lombok.Data;

@Data
public class PlayMoney {

    private String partida;

    //@NotEmpty
    private String conta;

    private String dataHora;

    private Double montante;

    private String destino;
}
