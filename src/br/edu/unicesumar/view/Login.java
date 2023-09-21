package br.edu.unicesumar.view;

import br.edu.unicesumar.core.dao.UsuarioDAO;
import br.edu.unicesumar.core.entity.Usuario;
import br.edu.unicesumar.view.Cadastro.CadastroView;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonEntrar;
    private JButton buttonCadastro;
    private JTextField loginField;
    private JTextField senhaField;
    
    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonEntrar);

        buttonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEntrar();
            }
        });

        buttonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroView cadastroView = new CadastroView();
                onCadastro(cadastroView);
            }
        });
    }

    private void onEntrar() {

        Usuario usuarioBusca = new Usuario();

        usuarioBusca.setLogin(loginField.getText());
        usuarioBusca.setSenha(senhaField.getText());

        UsuarioDAO dao = new UsuarioDAO();

        int res = dao.buscaUsuario(usuarioBusca);
        String mensagem = (res == 1) ? "Acesso Autorizado!" : "Acesso Negado!";
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private void onCadastro(CadastroView view) {
        view.open();
    }

    public void open(Login login){
        login.pack();
        login.setTitle("Tela de Login");
        login.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
