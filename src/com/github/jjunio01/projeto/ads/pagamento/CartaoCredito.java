package com.github.jjunio01.projeto.ads.pagamento;

import java.io.Serializable;

/**
 * @author Mikael C. Barros
 *
 */
public class CartaoCredito implements Serializable  {
	
	private EnumBandeira bandeira;
	private String numero;
	private double limite;
	private int cvv;
	private String nome;
	private int validade;
	
	
	public CartaoCredito(EnumBandeira bandeira, String numero, double limite, int cvv, String nome, int validade) {
		this.bandeira = bandeira;
		this.numero = numero;
		this.limite = limite;
		this.cvv = cvv;
		this.nome = nome;
		this.validade = validade;
	}


	public EnumBandeira getBandeira() {
		return bandeira;
	}


	public void setBandeira(EnumBandeira bandeira) {
		this.bandeira = bandeira;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getValidade() {
		return validade;
	}


	public void setValidade(int validade) {
		this.validade = validade;
	}


}
