package com.github.jjunio01.projeto.ads.vendas;

import java.text.NumberFormat;
import java.util.ArrayList;

import com.github.jjunio01.projeto.ads.estoque.Estoque;
import com.github.jjunio01.projeto.ads.estoque.Produto;

/**
 * @author JJunio
 *
 */
public class Carrinho {

	private ArrayList<Estoque> listaProdutos;
	private double precoTotal;

	public Carrinho(ArrayList<Estoque> listaProdutos) {
		this.listaProdutos = listaProdutos;
		calcularPrecoTotal();
	}

	public void deletarCarrinho() {
		this.listaProdutos = null;
		this.precoTotal = 0;
	}

	public void adicinarProdutoCarrinho(Estoque produto) {
		this.listaProdutos.add(produto);
	}

	public void calcularPrecoTotal() {

		for (int i = 0; i < this.listaProdutos.size(); i++) {
			this.precoTotal += this.listaProdutos.get(i).getProduto().getPreco()
					* this.listaProdutos.get(i).getQuantidadeProduto();
		}

	}

	public double getPrecoTotal() {
		calcularPrecoTotal();
		return precoTotal;
	}

	@Override
	public String toString() {
		NumberFormat numeroFormatado = NumberFormat.getCurrencyInstance();

		String carrinho = "";

		for (int i = 0; i < this.listaProdutos.size(); i++) {
			carrinho += "Nome: " + this.listaProdutos.get(i).getProduto().getNome() + "\nValor unitário R$: "
					+ numeroFormatado.format(this.listaProdutos.get(i).getProduto().getPreco()) + "\nQuantidade :"
					+ this.listaProdutos.get(i).getQuantidadeProduto() + "\n";
		}

		return carrinho;
	}

	public ArrayList<Estoque> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Estoque> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
