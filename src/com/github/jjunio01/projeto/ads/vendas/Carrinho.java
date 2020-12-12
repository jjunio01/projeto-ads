package com.github.jjunio01.projeto.ads.vendas;

import java.util.ArrayList;

/**
 * @author JJunio
 *
 */
public class Carrinho {

	// private ArrayList<Produto> listaProdutos;
	private double precoTotal;

	public void pegarCarrinho() {
		/* listaProdutos = new ArrayList<>(); */
		precoTotal = 0.0;
	}

	public void deletarCarrinho() {
		/* this.listaProdutos = null; */
	}

	/*
	 * public void adicinarProdutoCarrinho(Produto produto) {
	 * this.listaProdutos.add(produto); }
	 */

	public void calcularPrecoTotal() {
		/**
		for (int i = 0; i < this.ListaProdutos.size(); i++) {
			this.precoTotal += ListaProdutos.get(i).getValor() * ListaProdutos.get(i).getQuantidade();
		}
		*/
	}

	public double getPrecoTotal() {
		return precoTotal;
	}
	
	@Override
	public String toString() {
		String carrinho = "";
		/**
		for (int i = 0; i < this.ListaProdutos.size(); i++) {
			carrinho += "Nome: " + ListaProdutos.get(i).getNome() +
					"\nValor unitário R$: " + ListaProdutos.get(i).getValor()+
					"\nQuantidade :" + ListaProdutos.get(i).getQuantidade() + "\n";
		}
		*/
		return carrinho;
	}

}
