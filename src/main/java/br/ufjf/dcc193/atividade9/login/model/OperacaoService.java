package br.ufjf.dcc193.atividade9.login.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoDAO dao;

    public boolean insert(Operacao operacao){
        int n = dao.insertOne(operacao);
        return (n>0);  
    }

    public List<Operacao> selectAll() {
        return dao.selectAll();
    }

    public void updatePartida(Operacao operacao) {
        dao.updatePartida(operacao);
    }

    public void updateMontante(Operacao operacao) {
        dao.updateMontante(operacao);
    }
}
