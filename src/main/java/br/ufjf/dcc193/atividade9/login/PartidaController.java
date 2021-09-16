package br.ufjf.dcc193.atividade9.login;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

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
public class PartidaController {
    @Autowired
    private UsuarioService usuarioService;

    String partidaAtual;
    String contaAtual;

    @GetMapping("/partida")
    public String getPartida(@ModelAttribute PlayMoney playMoney, Model model) {
        partidaAtual = LoginController.partidaAtual;
        contaAtual = LoginController.contaAtual;
        return "login/partida";
    }

    @PostMapping("/partida")
    public String postPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

        List<Usuario> listaUsuarios = usuarioService.selectAll();

        if (bindingResult.hasErrors()) {
            return getPartida(playMoney, model);
        } else {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getConta().equals(contaAtual)) {
                    if (usuario.getPartida().equals(playMoney.getPartida())) {
                        return "login/operacao";
                    }
                }
            }
            return "login/partida";
        }
    }

    @PostMapping("/novaPartida")
    public String postNovaPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

        List<Usuario> listaUsuarios = usuarioService.selectAll();

        if (bindingResult.hasErrors()) {
            return getPartida(playMoney, model);
        } else {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getConta().equals(contaAtual)) {
                    usuario.setPartida(geraIdentificadorAleatorio(6));
                    usuarioService.updatePartida(usuario);
                    playMoney.setPartida(usuario.getPartida());
                }
            }
            return "login/partida";
        }
    }

    static String geraIdentificadorAleatorio(int quantidade) {
        byte[] tamanho;
        tamanho = new byte[256];
        String minhaString;
        StringBuffer buffer;
        String hexadecimais;

        new Random().nextBytes(tamanho);

        minhaString = new String(tamanho, Charset.forName("UTF-8"));

        buffer = new StringBuffer();

        hexadecimais = minhaString.replaceAll("^[a-fA-F0-9]+$", "");

        for (int m = 0; m < hexadecimais.length(); m++) {

            if (Character.isLetter(hexadecimais.charAt(m)) && (quantidade > 0)
                    || Character.isDigit(hexadecimais.charAt(m)) && (quantidade > 0)) {

                buffer.append(hexadecimais.charAt(m));
                quantidade--;
            }
        }
        return buffer.toString();
    }
}