/**
 * 
 */
package com.github.jjunio01.projeto.ads.estoque;

import java.io.Serializable;

/**
 * @author Petterson
 *
 */
public class Estoque implements Serializable {

	private double quantidadeProduto;
	private Produto produto;
	private int codigo;

	public Estoque(double quantidadeProduto, Produto produto, int codigo) {

		this.quantidadeProduto = quantidadeProduto;
		this.produto = produto;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	public void retirarProduto(Produto produto, double quatidade) {

	}

	@Override
	public String toString() {
		return "Nome :" + this.getProduto().getNome() + "\n" + "Descrição :" + this.getProduto().getDescricao() + "\n"
				+ "Ean :" + this.getProduto().getEan() + "\n" + "Unidade de Medida :"
				+ this.getProduto().getUnidadeMedida() + "\n" + "Preço :" + this.getProduto().getPreco() + "\n" + "ID :"
				+ this.getProduto().getId() + "\n";

	}
}
