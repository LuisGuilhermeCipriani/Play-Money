package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PartidaController {
    
   /* @GetMapping("/partida")
    public String getPartida(@ModelAttribute PlayMoney playMoney, Model model){
        return "login/partida";
    }

    @PostMapping("/partida")
    public String postPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            return getPartida(playMoney, model);
        } else {
            return "redirect:/partida";
        }
    }*/
}
