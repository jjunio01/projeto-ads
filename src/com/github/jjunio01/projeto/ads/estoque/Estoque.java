/**
 * 
 */
package com.github.jjunio01.projeto.ads.estoque;

/**
 * @author Petterson
 *
 */
public class Estoque {

	private double quantidadeProduto;
	private Produto produto;

	public void adicionarProduto(Produto produto, double quantidade) {

	}

	public double getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Estoque(double quantidadeProduto, Produto produto) {
		super();
		this.quantidadeProduto = quantidadeProduto;
		this.produto = produto;
	}

	public void retirarProduto(Produto produto, double quatidade) {

	}
}
