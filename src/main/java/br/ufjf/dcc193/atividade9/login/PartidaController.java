package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PartidaController {
    
    @GetMapping("/partida")
    public String getPartida(){
        return "login/partida";
    }

    @PostMapping("/partida")
    public String postPartida(){
        return "login/partida";
    }
}
