package br.ufjf.dcc193.atividade9.login.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OperacaoDAOImpl implements OperacaoDAO{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int count() throws DataAccessException {
        /*int quantidadeOperacoes = 0;
        for (Operacao operacao : selectAll()) {
            quantidadeOperacoes += 1;
        }
        return quantidadeOperacoes;*/
        Integer n = (Integer) jdbc.queryForObject("SELECT COUNT(*) FROM operacao", Integer.class);
        return n;
    }

    @Override
    public int insertOne(Operacao operacao) throws DataAccessException {
        int n = jdbc.update("INSERT INTO operacao(idOperacao, conta, partida, dataHora, montante, operacao, destino) VALUES(?,?,?,?,?,?,?);",
        operacao.getIdOperacao(),
        operacao.getConta(),
        operacao.getPartida(),
        operacao.getDataHora(),
        operacao.getMontante(),
        operacao.getOperacao(),
        operacao.getDestino()
        );
        return n;
    }

    @Override
    public Operacao selectOne(String conta) throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updatePartida(Operacao operacao) throws DataAccessException {
        int n = jdbc.update("UPDATE operacao set partida = ? where conta = ?", 
                operacao.getPartida(), operacao.getConta());
        return n;
    }

    @Override
    public int updateMontante(Operacao operacao) throws DataAccessException {
        int n = jdbc.update("UPDATE operacao set montante = ? where conta = ?", 
                operacao.getMontante(), operacao.getConta());
        return n;
    }

    @Override
    public int deleteOne(Operacao operacao) throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Operacao> selectAll() throws DataAccessException {
        List<Operacao> operacoes = new ArrayList<>();

        List<Map<String, Object>> resultados = jdbc.queryForList("SELECT * FROM operacao");
        for(Map<String, Object> resultado: resultados){
            Operacao operacao = new Operacao();
            operacao.setIdOperacao((Integer) resultado.get("idOperacao"));
            operacao.setPartida((String)resultado.get("partida"));
            operacao.setConta((String)resultado.get("conta"));
            operacao.setDataHora((Date)resultado.get("dataHora"));
            operacao.setMontante((Double)resultado.get("montante"));
            operacao.setOperacao((String)resultado.get("operacao"));
            operacao.setDestino((String)resultado.get("destino"));
            operacoes.add(operacao);
        }
        return operacoes;
    }
}
