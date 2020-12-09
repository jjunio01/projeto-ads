package com.github.jjunio01.projeto.ads.vendas;

import java.util.ArrayList;

/**
 * @author JJunio
 *
 */
public class Carrinho {

	// private ArrayList<Produto> listaProdutos;
	private double precoTotal;
	private EnumVenda status;

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

	public String calcularPrecoTotal() {

		setPrecoTotal(0);
		return "";
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public EnumVenda getStatus() {
		return status;
	}

	public void setStatus(EnumVenda status) {
		this.status = status;
	}

}
