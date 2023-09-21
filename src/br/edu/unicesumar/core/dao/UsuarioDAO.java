package br.edu.unicesumar.core.dao;

import br.edu.unicesumar.connection.Connector;
import br.edu.unicesumar.core.entity.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void insereUsuario (Usuario usuario) {

        String insertStatement = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
        PreparedStatement ps;

        try {
            ps = Connector.getConn().prepareStatement(insertStatement);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int buscaUsuario (Usuario usuario){
        String searchStatement = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        PreparedStatement ps;
        ResultSet result;

        try {
            ps = Connector.getConn().prepareStatement(searchStatement);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            result = ps.executeQuery();

            if(result.next()){
                return 1;
            }
            else {
                return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
