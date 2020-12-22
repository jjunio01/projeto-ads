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
		if (estoqueDisponivel != null) {
			estoqueDisponivel.add(t);
			try {
				FileUtil.gravarInformacoes(estoqueDisponivel, caminho);
				JOptionPane.showMessageDialog(null, "Produto adicionado ao estoque com sucesso.", "CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			try {
				FileUtil.gravarInformacoes(estoqueDisponivel, caminho);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Produto adicionado ao estoque com sucesso.", "CompreAqui",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		

	}

	@Override
	public Estoque consultar(int codigo) {
		List<Estoque> estoqueAtual = listarTodos();

		if (estoqueAtual.isEmpty()) {
			JOptionPane.showMessageDialog(null, "N�o esxistem produtos cadastrados no estoque.", "CompreAqui",
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		} else {
			for (Estoque atual : estoqueAtual) {
				if (atual.getCodigo() == codigo) {
					return atual;
				}
			}
		}

		return null;
	}

	@Override
	public void remover(Estoque estoque) {

		List<Estoque> estoqueDisponivel = listarTodos();
		if (estoqueDisponivel.isEmpty()) {
			JOptionPane.showMessageDialog(null, "N�o esxistem produtos cadastrados no estoque para remover",
					"Sistema CompreAqui", JOptionPane.INFORMATION_MESSAGE);
		} else {
			for (Estoque cadastrado : estoqueDisponivel) {
				if (cadastrado.getCodigo() == estoque.getCodigo()) {
					estoqueDisponivel.remove(cadastrado);
					adicionarLista(estoqueDisponivel);
					JOptionPane.showMessageDialog(null, "Estoque do produto removido com sucesso.",
							"Sistema CompreAqui", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
	}

	@Override
	public void atualizar(Estoque t) {

		List<Estoque> estoqueDisponivel = listarTodos();
		if (estoqueDisponivel.isEmpty()) {
			JOptionPane.showMessageDialog(null, "N�o esxistem produtos cadastrados no estoque para atualizar",
					"Sistema CompreAqui", JOptionPane.INFORMATION_MESSAGE);
		} else {

			for (Estoque atual : estoqueDisponivel) {
				if (atual.getCodigo() == t.getCodigo()) {
					estoqueDisponivel.remove(atual);
					adicionarLista(estoqueDisponivel);
					estoqueDisponivel.add(t);
					adicionarLista(estoqueDisponivel);
				}
			}
		}
	}

	@Override
	public List<Estoque> listarTodos() {
		try {
			return (ArrayList<Estoque>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

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
