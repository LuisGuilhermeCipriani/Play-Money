package br.ufjf.dcc193.atividade9.login;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlayMoney {

    @Pattern(regexp = "^[a-fA-F0-9]+$")
    @Min(6)
    @Max(6)
    private String partida;

    private String conta;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data = new Date();

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date hora = new Date();

    private Float montante;
}
