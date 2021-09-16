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
public class UsuarioDAOImpl implements UsuarioDAO{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int count() throws DataAccessException {
        Integer n = (Integer) jdbc.queryForObject("SELECT COUNT(*) FROM usuario", Integer.class);
        return n;
    }

    @Override
    public int insertOne(Usuario usuario) throws DataAccessException {
        int n = jdbc.update("INSERT INTO usuario(conta, partida, dataHora, montante, role) VALUES(?,?,?,?,?);",
        usuario.getConta(),
        usuario.getPartida(),
        usuario.getDataHora(),
        usuario.getMontante(),
        usuario.getRole()
        );
        return n;
    }

    @Override
    public Usuario selectOne(String conta) throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updatePartida(Usuario usuario) throws DataAccessException {
        int n = jdbc.update("UPDATE usuario set partida = ? where conta = ?", 
                usuario.getPartida(), usuario.getConta());
        return n;
    }

    @Override
    public int updateMontante(Usuario usuario) throws DataAccessException {
        int n = jdbc.update("UPDATE usuario set montante = ? where conta = ?", 
                usuario.getMontante(), usuario.getConta());
        return n;
    }

    @Override
    public int deleteOne(Usuario usuario) throws DataAccessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Usuario> selectAll() throws DataAccessException {
        List<Usuario> usuarios = new ArrayList<>();

        List<Map<String, Object>> resultados = jdbc.queryForList("SELECT * FROM usuario");
        for(Map<String, Object> resultado: resultados){
            Usuario usuario = new Usuario();
            usuario.setPartida((String)resultado.get("partida"));
            usuario.setConta((String)resultado.get("conta"));
            usuario.setPartida((String)resultado.get("partida"));
            usuario.setDataHora((Date)resultado.get("dataHora"));
            usuario.setMontante((Double)resultado.get("montante"));
            usuario.setRole((String)resultado.get("role"));
            usuarios.add(usuario);
        }

        return usuarios;
    }
    
}
