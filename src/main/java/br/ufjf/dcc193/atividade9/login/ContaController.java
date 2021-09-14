package br.ufjf.dcc193.atividade9.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ufjf.dcc193.atividade9.login.model.Usuario;
import br.ufjf.dcc193.atividade9.login.model.UsuarioService;

@Controller
public class ContaController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/conta")
    public String getConta(@ModelAttribute PlayMoney playMoney, Model model){
        return "login/conta";
    }

    @PostMapping("/conta")
    public String postConta(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
    Model model){
        
        List<Usuario> listaUsuarios = usuarioService.selectAll();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getConta().equals(playMoney.getConta())){
                return "login/home";
            }
        }
        return "login/conta";
    }
}
