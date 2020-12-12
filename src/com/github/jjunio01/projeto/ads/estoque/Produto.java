/**
 * 
 */
package com.github.jjunio01.projeto.ads.estoque;

/**
 * @author Petterson
 *
 */
public class Produto {

	private String nome;
	private String descricao;
	private String ean;
	private EnunUnidadeMedida unidadeMedida;
	private double preco;
	private int id;

	public Produto(String nome, String descricao, String ean, EnunUnidadeMedida unidadeMedida, double preco, int id) {

		this.nome = nome;
		this.descricao = descricao;
		this.ean = ean;
		this.unidadeMedida = unidadeMedida;
		this.preco = preco;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public EnunUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(EnunUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
