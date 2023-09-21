package br.edu.unicesumar.view.Cadastro;

import br.edu.unicesumar.core.dao.UsuarioDAO;
import br.edu.unicesumar.core.entity.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroView extends JFrame{
    private JTextField nome;
    private JTextField login;
    private JPasswordField senha;
    private JTextField email;
    private JButton salvarButton;
    private JPanel panelMain;

    public CadastroView(){
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                onSalvar(usuario);
            }
        });
    }

    public void open(){
        CadastroView view = new CadastroView();
        view.setContentPane(view.panelMain);
        view.setTitle("Cadastro");
        view.setSize(300, 400);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void onSalvar(Usuario usuario){

        UsuarioDAO dao = new UsuarioDAO();

        usuario.setNome(nome.getText());
        usuario.setSenha(senha.getText());
        usuario.setLogin(login.getText());
        usuario.setEmail(email.getText());

        dao.insereUsuario(usuario);

    }
}
