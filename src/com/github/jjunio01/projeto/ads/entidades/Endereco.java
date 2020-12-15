package com.github.jjunio01.projeto.ads.entidades;

import java.io.Serializable;

/**
 * @author Édrey Lucas
 *
 */
public class Endereco implements Serializable {
	private String rua;
	private int numero;
	private long cep;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco(String rua, int numero, long cep, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getrua() {
		return rua;
	}

	public void setrua(String rua) {
		this.rua = rua;
	}

	public int getnumero() {
		return numero;
	}

	public void setnumero(int numero) {
		this.numero = numero;
	}

	public long getcep() {
		return cep;
	}

	public void setcep(long cep) {
		this.cep = cep;
	}

	public String getbairro() {
		return bairro;
	}

	public void setbairro(String bairro) {
		this.bairro = bairro;
	}

	public String getcidade() {
		return cidade;
	}

	public void setcidade(String cidade) {
		this.cidade = cidade;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

}
