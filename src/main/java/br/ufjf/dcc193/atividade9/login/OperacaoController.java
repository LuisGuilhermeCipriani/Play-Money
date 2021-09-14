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
public class OperacaoController {
    @Autowired
    private UsuarioService usuarioService;
    String partidaAtual;
    String contaAtual;

    @GetMapping("/formularioOperacoes")
    public String getOperacao(@ModelAttribute PlayMoney playMoney, Model model) {
        partidaAtual = LoginController.partidaAtual;
        contaAtual = LoginController.contaAtual;
        System.out.println("PARTIDA " + partidaAtual + ", CONTA: " + contaAtual);
        return "login/operacoes";
    }

    @PostMapping("/formularioOperacoes")
    public String postOperacao(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return getOperacao(playMoney, model);
        } else {
            return "redirect:/home";
        }
    }

    /*
     * @GetMapping("/operacao") public String getOperaco(@RequestParam("descricao")
     * String descricao) { //Map<String, String> destino = new LinkedHashMap<>();
     * //destino.put("Banco", "true"); //destino.put("Conta", "false");
     * //model.addAttribute("destino", destino); System.out.println("descrição: " +
     * descricao); return ""; }
     */

    /*
     * @RequestMapping(value = "/{partida}/{conta}", method = RequestMethod.GET)
     * public String post(@PathVariable("partida") String
     * partida, @PathVariable("conta") String conta) {
     * System.out.println("Partida: " + partida + ", Conta: " + conta); return ""; }
     */

    @PostMapping("/pagar")
    public String postPagar(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        List<Usuario> listaUsuarios = usuarioService.selectAll();

        if (playMoney.getDestino().equals("bancoRadio")) {

            for (Usuario usuario : listaUsuarios) {
                if (usuario.getConta().equals(contaAtual)) {
                    usuario.setMontante((usuario.getMontante() - playMoney.getMontante()));
                    usuarioService.updateMontante(usuario);
                }
            }

        } else if (playMoney.getDestino().equals("contaRadio")) {

            for (Usuario usuario : listaUsuarios) {
                if (usuario.getConta().equals(contaAtual)) {
                    for (Usuario usuario2 : listaUsuarios) {
                        if (usuario2.getConta().equals(playMoney.getConta())) {
                            usuario.setMontante((usuario.getMontante() - playMoney.getMontante()));
                            usuario2.setMontante((usuario2.getMontante() + playMoney.getMontante()));
                            usuarioService.updateMontante(usuario);
                            usuarioService.updateMontante(usuario2);
                        }
                    }
                }
            }
        }
        return "login/operacoes";
    }

    @PostMapping("/receber")
    public String postReceber(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

                List<Usuario> listaUsuarios = usuarioService.selectAll();

                if (playMoney.getDestino().equals("bancoRadio")) {
        
                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getConta().equals(contaAtual)) {
                            usuario.setMontante((usuario.getMontante() + playMoney.getMontante()));
                            usuarioService.updateMontante(usuario);
                        }
                    }
        
                } else if (playMoney.getDestino().equals("contaRadio")) {
        
                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getConta().equals(contaAtual)) {
                            for (Usuario usuario2 : listaUsuarios) {
                                if (usuario2.getConta().equals(playMoney.getConta())) {
                                    usuario.setMontante((usuario.getMontante() + playMoney.getMontante()));
                                    usuario2.setMontante((usuario2.getMontante() - playMoney.getMontante()));
                                    usuarioService.updateMontante(usuario);
                                    usuarioService.updateMontante(usuario2);
                                }
                            }
                        }
                    }
                }
                return "login/operacoes";
    }
}
