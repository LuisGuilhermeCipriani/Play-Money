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
public class PlayMoneyController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/partida")
    public String getPartida(@ModelAttribute PlayMoney playMoney, Model model) {
        return "login/home";
    }

    @PostMapping("/partida")
    public String postPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return getPartida(playMoney, model);
        } else {
            /*
             * Usuario usuario = new Usuario(); Date dataHora = new Date();
             * usuario.setConta(playMoney.getConta());
             * usuario.setPartida(playMoney.getPartida()); usuario.setData(dataHora);
             * usuario.setHora(dataHora); usuario.setMontante(playMoney.getMontante());
             * usuario.setRole("COMUM"); if (usuarioService.insert(usuario)) { return
             * "redirect:/home"; } else { return "redirect:/login"; }
             */

            System.out.println("Valor da conta1: " + playMoney.getConta());
            List<Usuario> lista = usuarioService.selectAll();
            for (Usuario usuario : lista) {
                if (usuario.getConta().equals(playMoney.getConta())) {
                    if (usuario.getPartida().equals(playMoney.getPartida())) {
                        return "login/home";
                    } else {
                        return "login/partida";
                    }
                }
            }
            return "login/partida";
        }
    }

    @GetMapping("/novaPartida")
    public String getNovaPartida(@ModelAttribute PlayMoney playMoney, Model model) {
        return "login/home";
    }

    @PostMapping("/novaPartida")
    public String postNovaPartida(@ModelAttribute @Validated PlayMoney playMoney, BindingResult bindingResult,
            Model model) {
        Random r = new Random(6);
        System.out.println("Numero aleatorio: " + r);
        System.out.println("Valor da conta 2: " + playMoney.getConta());
        List<Usuario> lista = usuarioService.selectAll();
        for (Usuario usuario : lista) {
            if (usuario.getConta().equals("123")) {
                System.out
                        .println("Igual: Usuario: " + usuario.getConta() + " , " + "Digitado: " + playMoney.getConta());
                usuario.setPartida(geraIdentificadorAleatorio(6));
                usuarioService.updateOne(usuario);
                return "login/home";
            } else {
                System.out.println(
                        "Diferente: Usuario: " + usuario.getConta() + " , " + "Digitado: " + playMoney.getConta());
            }
        }
        return "login/partida";
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
