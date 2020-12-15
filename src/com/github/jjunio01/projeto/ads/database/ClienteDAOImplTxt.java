package com.github.jjunio01.projeto.ads.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public class ClienteDAOImplTxt implements ClienteDAO {

	private final String caminho = "databaseClientes.txt";

	@Override
	public void adicionar(Pessoa t) {

		List<Pessoa> clientesCadastrados = listarTodos();
		clientesCadastrados.add(t);
		try {
			FileUtil.gravarInformacoes(clientesCadastrados, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public Pessoa consultar(String nome) {

		List<Pessoa> clientesCadastrados = listarTodos();
		if (clientesCadastrados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {

			for (Pessoa pessoaCadastrada : clientesCadastrados) {
				if (pessoaCadastrada.getnome().equals(nome)) {
					clientesCadastrados.remove(pessoaCadastrada);
					adicionarLista(clientesCadastrados);
					return pessoaCadastrada;
				}
			}
		}
		return null;
	}

	@Override
	public void remover(String nome) {

		List<Pessoa> clientesCadastrados = listarTodos();
		if (clientesCadastrados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado para remoção", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {
			for (Pessoa pessoaCadastrada : clientesCadastrados) {
				if (pessoaCadastrada.getnome().equals(nome)) {
					clientesCadastrados.remove(pessoaCadastrada);
					adicionarLista(clientesCadastrados);
					JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.", "Sistema CompreAqui",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
	}

	@Override
	public void atualizar(Pessoa t) {

		List<Pessoa> clientesCadastrados = listarTodos();
		if (clientesCadastrados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado para atualização", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {
			for (Pessoa pessoaCadastrada : clientesCadastrados) {
				if (pessoaCadastrada.getnome().equals(t.getnome())) {
					clientesCadastrados.remove(pessoaCadastrada);
					clientesCadastrados.add(t);
					adicionarLista(clientesCadastrados);
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.", "Sistema CompreAqui",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
	}

	@Override
	public List<Pessoa> listarTodos() {
		try {
			return (ArrayList<Pessoa>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public void adicionarLista(List<Pessoa> p) {
		try {
			FileUtil.gravarInformacoes(p, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}