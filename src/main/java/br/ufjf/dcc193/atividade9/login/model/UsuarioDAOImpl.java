package br.ufjf.dcc193.atividade9.login.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int count() throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertOne(Usuario usuario) throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Usuario selectOne(String conta) throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateOne(Usuario usuario) throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteOne(Usuario usuario) throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Usuario> selectAll() throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
