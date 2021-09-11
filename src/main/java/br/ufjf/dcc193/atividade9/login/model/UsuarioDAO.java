package br.ufjf.dcc193.atividade9.login.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface UsuarioDAO {
    public int count() throws DataAccessException;
    public int insertOne(Usuario usuario) throws DataAccessException;
    public Usuario selectOne(String conta) throws DataAccessException;
    public int updatePartida(Usuario usuario) throws DataAccessException;
    public int updateMontante(Usuario usuario) throws DataAccessException;
    public int deleteOne(Usuario usuario) throws DataAccessException;
    public List<Usuario> selectAll() throws DataAccessException;
}
