package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public class UsuarioDAOImplTxt implements UsuarioDAO {

	private final String caminho = "databaseUsuarios.txt";

	@Override
	public void adicionar(Usuario usuario) {

		ArrayList<Usuario> listaUsuarios = listarTodos();

		if (listaUsuarios != null) {
			listaUsuarios.add(usuario);
			try {
				FileUtil.gravarInformacoes(listaUsuarios, caminho);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ArrayList<Usuario> listaUsuarioNovo = new ArrayList();
			listaUsuarioNovo.add(usuario);
			try {
				FileUtil.gravarInformacoes(listaUsuarioNovo, caminho);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void atualizar(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		try {
			return (ArrayList<Usuario>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public void adicionarLista(ArrayList<Usuario> t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String login) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario consultar(String login) {

		ArrayList<Usuario> usuarioCadastrado = listarTodos();

		if (usuarioCadastrado == null) {

			JOptionPane.showMessageDialog(null, "Não existe usuário cadastrado", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {

			for (int i = 0; i < usuarioCadastrado.size(); i++) {
				if (usuarioCadastrado.get(i).getLogin().equals(login)) {
					return usuarioCadastrado.get(i);
				}
			}

		}
		return null;
	}

}
