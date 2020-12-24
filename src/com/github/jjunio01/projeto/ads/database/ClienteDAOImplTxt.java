package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.estoque.Estoque;

/**
 * @author JJunio
 *
 */
public class ClienteDAOImplTxt implements ClienteDAO {

	private final String caminho = "databaseClientes.txt";

	@Override
	public void adicionar(Pessoa cliente) {

		ArrayList<Pessoa> databaseClientes = listarTodos();

		if (databaseClientes != null) {
			databaseClientes.add(cliente);
			try {
				FileUtil.gravarInformacoes(databaseClientes, caminho);
				JOptionPane.showMessageDialog(null, "Cadastro realizado.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ArrayList<Pessoa> novoDataBaseClientes = new ArrayList();
			novoDataBaseClientes.add(cliente);
			try {
				FileUtil.gravarInformacoes(novoDataBaseClientes, caminho);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	@Override
	public ArrayList<Pessoa> listarTodos() {
		try {
			return (ArrayList<Pessoa>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}



	public Pessoa consultar(String nome) {

		ArrayList<Pessoa> pessoasCadastradas = listarTodos();

		if (pessoasCadastradas == null) {

			JOptionPane.showMessageDialog(null, "Não existe produtos no estoque", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {

			for (int i = 0; i < pessoasCadastradas.size(); i++) {
				if (pessoasCadastradas.get(i).getNome().equals(nome)) {
					return pessoasCadastradas.get(i);
				}
			}

		}
		return null;
	}


	@Override
	public void atualizar(Pessoa t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void adicionarLista(ArrayList<Pessoa> t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remover(String nome) {
		// TODO Auto-generated method stub
		
	}

}