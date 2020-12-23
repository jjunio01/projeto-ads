package com.github.jjunio01.projeto.ads.vendas;

import java.text.NumberFormat;
import java.util.ArrayList;

import com.github.jjunio01.projeto.ads.estoque.Produto;

/**
 * @author JJunio
 *
 */
public class Carrinho {

	private ArrayList<Produto> listaProdutos;
	private double precoTotal;
	private int quantidade;

	public void pegarCarrinho() {
		listaProdutos = new ArrayList<>();
		precoTotal = 0.0;
		this.quantidade = 0;
	}

	public void deletarCarrinho() {
		this.listaProdutos = null;
		this.precoTotal = 0;
		this.quantidade = 0;
	}

	public void adicinarProdutoCarrinho(Produto produto) {
		this.listaProdutos.add(produto);
	}

	public void calcularPrecoTotal() {

		for (int i = 0; i < this.listaProdutos.size(); i++) {
			this.precoTotal += this.listaProdutos.get(i).getPreco() * quantidade;
		}

	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	@Override
	public String toString() {
		NumberFormat numeroFormatado = NumberFormat.getCurrencyInstance();
		
		String carrinho = "";

		for (int i = 0; i < this.listaProdutos.size(); i++) {
			carrinho += "Nome: " + this.listaProdutos.get(i).getNome() + "\nValor unitário R$: "
					+ numeroFormatado.format(this.listaProdutos.get(i).getPreco()) + "\nQuantidade :" + this.quantidade + "\n";
		}

		return carrinho;
	}

}
