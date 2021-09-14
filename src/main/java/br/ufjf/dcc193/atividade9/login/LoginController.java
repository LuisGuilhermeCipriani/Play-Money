package br.ufjf.dcc193.atividade9.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    public static String partidaAtual = "";
    public static String contaAtual = "";

    /*@GetMapping("/a")
    public String getLogin(@ModelAttribute PlayMoney playMoney, Model model) {
        return "login/login";
    }

    @PostMapping("/b")
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
    }*/

    @RequestMapping("/login")
    public String getUrl(@RequestParam("partida") String partida, @RequestParam("conta") String conta) {
        LoginController.partidaAtual = partida;
        LoginController.contaAtual = conta;
        
        if(partida.trim().isEmpty()){
            return "redirect:/partida";
        }else if(conta.trim().isEmpty()){
            return "redirect:/conta";
        }
        return "redirect:/home";
    }
}
