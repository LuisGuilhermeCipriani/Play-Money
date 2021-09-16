package br.ufjf.dcc193.atividade9.login;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ufjf.dcc193.atividade9.login.model.Operacao;
import br.ufjf.dcc193.atividade9.login.model.OperacaoService;
import br.ufjf.dcc193.atividade9.login.model.Usuario;
import br.ufjf.dcc193.atividade9.login.model.UsuarioService;

@Controller
public class OperacaoController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OperacaoService operacaoService;
    String partidaAtual;
    String contaAtual;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping("/operacao")
    public String getUsuarios(@ModelAttribute PlayMoney playMoney, Model model) {
        partidaAtual = LoginController.partidaAtual;
        contaAtual = LoginController.contaAtual;
        List<Operacao> operacoes = operacaoService.selectAll();
        model.addAttribute("operacao", operacoes);
        return "login/operacao";
    }

    @PostMapping("/operacao")
    public String postUsuarios(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return getUsuarios(playMoney, model);
        } else {
            return "login/operacao";
        }
    }

    @PostMapping("/pagar")
    public String postPagar(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult, Model model) {

        List<Usuario> listaUsuarios = usuarioService.selectAll();

        if (playMoney.getDestino().equals("bancoRadio")) {

            for (Usuario usuario : listaUsuarios) {
                if (usuario.getConta().equals(contaAtual)) {
                    usuario.setMontante((usuario.getMontante() - playMoney.getMontante()));
                    usuarioService.updateMontante(usuario);

                    Operacao operacao = new Operacao();
                    operacao.setPartida(usuario.getPartida());
                    operacao.setConta(contaAtual);
                    operacao.setDataHora(new Date());
                    operacao.setMontante(playMoney.getMontante());
                    operacao.setOperacao("Pagar");
                    operacao.setDestino("Banco");
                    operacaoService.insert(operacao);
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

                            Operacao operacao = new Operacao();
                            operacao.setPartida(usuario.getPartida());
                            operacao.setConta(contaAtual);
                            operacao.setDataHora(new Date());
                            operacao.setMontante(playMoney.getMontante());
                            operacao.setOperacao("Pagar");
                            operacao.setDestino(usuario2.getConta());
                            operacaoService.insert(operacao);
                        }
                    }
                }
            }
        }
        this.getUsuarios(playMoney, model);
        return "login/operacao";
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

                    Operacao operacao = new Operacao();
                    operacao.setPartida(usuario.getPartida());
                    operacao.setConta(contaAtual);
                    operacao.setDataHora(new Date());
                    operacao.setMontante(playMoney.getMontante());
                    operacao.setOperacao("Receber");
                    operacao.setDestino("Banco");
                    operacaoService.insert(operacao);
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

                            Operacao operacao = new Operacao();
                            operacao.setPartida(usuario.getPartida());
                            operacao.setConta(contaAtual);
                            operacao.setDataHora(new Date());
                            operacao.setMontante(playMoney.getMontante());
                            operacao.setOperacao("Receber");
                            operacao.setDestino(usuario2.getConta());
                            operacaoService.insert(operacao);
                        }
                    }
                }
            }
        }
        this.getUsuarios(playMoney, model);
        return "login/operacao";
    }
}
