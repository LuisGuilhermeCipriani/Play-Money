package br.ufjf.dcc193.atividade9.login.model;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
    
    private String partida;
    private String conta;
    private Date data;
    private Date hora;
    private Double montante;
    private String role;
}
