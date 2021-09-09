package br.ufjf.dcc193.atividade9.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufjf.dcc193.atividade9.login.model.Usuario;
import br.ufjf.dcc193.atividade9.login.model.UsuarioService;

@Controller
public class PlayMoneyController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/partida")
    public String getPartida(@ModelAttribute PlayMoney playMoney, Model model) {
        return "login/home";
    }

    @PostMapping("/partida")
    public String postPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return getPartida(playMoney, model);
        } else {
            Usuario usuario = new Usuario();
            Date dataHora = new Date();
            usuario.setConta(playMoney.getConta());
            usuario.setPartida(playMoney.getPartida());
            usuario.setData(dataHora);
            usuario.setHora(dataHora);
            usuario.setMontante(playMoney.getMontante());
            usuario.setRole("COMUM");
            if (usuarioService.insert(usuario)) {
                return "redirect:/home";
            } else {
                return "redirect:/login";
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "novaPartida")
    public String postNovaPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {
        return "login/home";
    }
}
