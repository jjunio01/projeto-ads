package com.github.jjunio01.projeto.ads;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.database.UsuarioDAOImplTxt;
import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public class Main {

	public static void main(String[] args) {

		boolean executando = true;
		String opcao;

		while (executando) {

			opcao = JOptionPane.showInputDialog(null, "Bem vindo ao sistema", "Sistema CompreAqui",
					JOptionPane.YES_OPTION);
			if (opcao.equals("1")) {
				cadastrarUsuario();

			} else if (opcao.equals("2")) {
				consultarUsuarios();

			} else {
				executando = false;
			}
		}

	}

	public static boolean cadastrarUsuario() {

		String login, senha;
		UsuarioDAOImplTxt daoUsuario = new UsuarioDAOImplTxt();
		login = JOptionPane.showInputDialog(null, "Digite o seu Login", "Cadastro CompreAqui",
				JOptionPane.QUESTION_MESSAGE);
		senha = JOptionPane.showInputDialog(null, "Digite o sua senha", "Cadastro CompreAqui",
				JOptionPane.QUESTION_MESSAGE);

		daoUsuario.adicionar(new Usuario(login, senha));
		return true;
	}

	public static void consultarUsuarios() {
		UsuarioDAOImplTxt daoUsuario = new UsuarioDAOImplTxt();
		List<Usuario> usuariosCadastrados = daoUsuario.listarTodos();
		String mensagem = "";
		for (Usuario cadastrado : usuariosCadastrados) {
			
			mensagem += "Login: " + cadastrado.getLogin() + " -> Senha: " + cadastrado.getSenha() + "\n";
		}
		JOptionPane.showMessageDialog(null,
				mensagem, "Sistema CompreAqui",
				JOptionPane.INFORMATION_MESSAGE);
	}

}