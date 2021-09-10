package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(@ModelAttribute PlayMoney playMoney, Model model) {
        return "login/login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "login/login";
        } else {
            if (playMoney.getPartida().isEmpty()) {
                return "login/partida";
            }
            if (playMoney.getConta().isEmpty()) {
                return "login/conta";
            }
        }
        return "login/home";
    }
}
