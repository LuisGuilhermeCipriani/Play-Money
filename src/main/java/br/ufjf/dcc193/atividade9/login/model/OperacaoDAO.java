package br.ufjf.dcc193.atividade9.login.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OperacaoDAO {
    public int count() throws DataAccessException;
    public int insertOne(Operacao operacao) throws DataAccessException;
    public Operacao selectOne(String conta) throws DataAccessException;
    public int updatePartida(Operacao operacao) throws DataAccessException;
    public int updateMontante(Operacao operacao) throws DataAccessException;
    public int deleteOne(Operacao operacao) throws DataAccessException;
    public List<Operacao> selectAll() throws DataAccessException;
}
