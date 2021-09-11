package br.ufjf.dcc193.atividade9.login;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
public class OperacaoController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/operacao")
    public String getOperaco(@ModelAttribute PlayMoney playMoney, Model model) {
        Map<String, String> destino = new LinkedHashMap<>();
        destino.put("Banco", "true");
        destino.put("Conta", "false");
        model.addAttribute("destino", destino);
        return "login/operacoes";
    }



    @PostMapping("/pagar")
    public String postPagar(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        List<Usuario> listaUsuarios = usuarioService.selectAll();

        if(playMoney.getDestino().equals("bancoRadio")){
            
            /*for (Usuario usuario : listaUsuarios) {
                if(usuario.getConta().equals(playMoney.getConta())){
                    usuario.setMontante((usuario.getMontante() - playMoney.getMontante()));
                    usuarioService.updateMontante(usuario);
                }
            }*/

        }else if(playMoney.getDestino().equals("contaRadio")){
            
            for (Usuario usuario : listaUsuarios) {
                if(usuario.getConta().equals(playMoney.getConta())){
                    usuario.setMontante((usuario.getMontante() + playMoney.getMontante()));
                    usuarioService.updateMontante(usuario);
                }
            }
        }
        return "login/operacoes";
    }

    @PostMapping("/receber")
    public String postReceber(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        System.out.println("Chegou no receber");
        return "login/operacoes";
    }
}
