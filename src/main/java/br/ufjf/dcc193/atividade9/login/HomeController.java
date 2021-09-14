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
    public String getPartida(@ModelAttribute PlayMoney playMoney, Model model){
        return "login/home";
    }

    @PostMapping("/home")
    public String postPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            return getPartida(playMoney, model);
        } else {
            return "login/home";
        }
    }
    /*@GetMapping("/home.html")
    public String getHome(Model model){
        model.addAttribute("conteudo", "login/home::conteudo");
        return "login/defaultLayout";
    }
    

    /*@GetMapping("/operacoes.html")
    public String getOperacoes(Model model){
        model.addAttribute("conteudo", "login/operacoes::conteudo");
        return "login/defaultLayout";
    }

    @PostMapping("/home")
    public String postLogin(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        return "login/home";
    }

    @GetMapping("/operacoesContas.html")
    public String getOperacoesContas(Model model){
        model.addAttribute("conteudo", "login/operacoesContas::conteudo");
        return "login/defaultLayout";
    }

    @GetMapping("/operacoesOrdem.html")
    public String getOperacoesOrdem(Model model){
        model.addAttribute("conteudo", "login/operacoesOrdem::conteudo");
        return "login/defaultLayout";
    }*/

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
