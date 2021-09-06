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
}
