package com.github.jjunio01.projeto.ads.pagamento;

import java.io.Serializable;

/**
 * @author Mikael C. Barros
 *
 */
public class CartaoCredito implements Serializable {

	private EnumBandeira bandeira;
	private String numero;
	private double limite;
	private String cvv;
	private String nome;
	private String validade;

	public CartaoCredito(EnumBandeira bandeira, String numero, double limite, String cvv, String nome,
			String validade) {

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

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	
	
	
	
}
