package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home.html")
    public String getHome(Model model){
        model.addAttribute("conteudo", "login/home::conteudo");
        return "login/defaultLayout";
    }

    @GetMapping("/operacoes.html")
    public String getOperacoes(Model model){
        model.addAttribute("conteudo", "login/operacoes::conteudo");
        return "login/defaultLayout";
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
    }
}
