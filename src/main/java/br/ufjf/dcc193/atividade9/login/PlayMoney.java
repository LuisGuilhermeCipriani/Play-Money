package br.ufjf.dcc193.atividade9.login;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PlayMoney {

    @Pattern(regexp = "^[a-fA-F0-9]+$")
    @Min(6)
    @Max(6)
    private String partida;

    private String conta;
}
