package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Usuario;
import com.github.jjunio01.projeto.ads.estoque.Estoque;

/**
 * @author JJunio
 *
 */
public class EstoqueDAOImplTxt implements EstoqueDAO {

	private final String caminho = "databaseEstoque.txt";

	@Override
	public void adicionar(Estoque estoque) {

		ArrayList<Estoque> estoqueDisponivel = listarTodos();

		if (estoqueDisponivel != null) {
			estoqueDisponivel.add(estoque);
			try {
				FileUtil.gravarInformacoes(estoqueDisponivel, caminho);
				JOptionPane.showMessageDialog(null, "Produto adicionado ao estoque com sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ArrayList<Estoque> novoEstoque = new ArrayList();
			novoEstoque.add(estoque);
			try {
				FileUtil.gravarInformacoes(novoEstoque, caminho);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	@Override
	public ArrayList<Estoque> listarTodos() {
		try {
			return (ArrayList<Estoque>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}



	public Estoque consultar(String nomeProduto) {

		ArrayList<Estoque> estoqueDisponivel = listarTodos();

		if (estoqueDisponivel == null) {

			JOptionPane.showMessageDialog(null, "Não existe produtos no estoque", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
		} else {

			for (int i = 0; i < estoqueDisponivel.size(); i++) {
				if (estoqueDisponivel.get(i).getProduto().getNome().equals(nomeProduto)) {
					return estoqueDisponivel.get(i);
				}
			}

		}
		return null;
	}


	@Override
	public void atualizar(Estoque t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void adicionarLista(ArrayList<Estoque> t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Estoque consultar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void remover(Estoque estoque) {
		// TODO Auto-generated method stub
		
	}


}
