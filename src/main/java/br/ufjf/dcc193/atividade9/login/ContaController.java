package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContaController {
    
    @GetMapping("/conta")
    public String getPartida(){
        return "login/conta";
    }

    @PostMapping("/conta")
    public String postPartida(){
        return "redirect:/conta";
    }
}
