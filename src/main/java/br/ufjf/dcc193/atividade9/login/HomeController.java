package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(@ModelAttribute PlayMoney playMoney, Model model){
        return "login/home";
    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            return getHome(playMoney, model);
        } else {
            return "login/home";
        }
    }

    @PostMapping("/operacoes")
    public String postOperacoes(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        return "redirect:/formularioOperacoes";
    }

    @PostMapping("/operacoesContas")
    public String postOperacoesConta(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        return "login/operacoesContas";
    }

    @PostMapping("/operacoesOrdem")
    public String postOperacoesOrdem(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        return "login/operacoesOrdem";
    }
}
