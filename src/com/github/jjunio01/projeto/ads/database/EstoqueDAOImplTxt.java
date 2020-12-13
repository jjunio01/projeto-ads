package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.estoque.Estoque;

/**
 * @author JJunio
 *
 */
public class EstoqueDAOImplTxt implements EstoqueDAO {

	private final String caminho = "databaseEstoque.txt";

	@Override
	public void adicionar(Estoque t) {
		List<Estoque> estoqueDisponivel = listarTodos();
		estoqueDisponivel.add(t);
		adicionarLista(estoqueDisponivel);

	}

	public Estoque consultar(int codigo) {
		List<Estoque> estoqueAtual = listarTodos();

		for (Estoque atual : estoqueAtual) {
			if (atual.getCodigo() == codigo) {
				return atual;
			}
		}

		return null;
	}

	public void remover(Estoque estoque) {

		List<Estoque> estoqueDisponivel = listarTodos();
		for (Estoque cadastrado : estoqueDisponivel) {
			if (cadastrado.getCodigo() == estoque.getCodigo()) {
				estoqueDisponivel.remove(cadastrado);
				adicionarLista(estoqueDisponivel);
				JOptionPane.showMessageDialog(null, "Estoque do produto removido com sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}

	}

	@Override
	public void atualizar(Estoque t) {

		List<Estoque> estoqueDisponivel = listarTodos();

		for (Estoque atual : estoqueDisponivel) {
			if (atual.getCodigo() == t.getCodigo()) {
				estoqueDisponivel.remove(atual);
				adicionarLista(estoqueDisponivel);
				estoqueDisponivel.add(t);
				adicionarLista(estoqueDisponivel);
			}
		}

	}

	@Override
	public List<Estoque> listarTodos() {
		try {
			return (ArrayList<Estoque>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public void adicionarLista(List<Estoque> t) {
		try {
			FileUtil.gravarInformacoes(t, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
