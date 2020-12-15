package com.github.jjunio01.projeto.ads.entidades;

import java.io.Serializable;

import com.github.jjunio01.projeto.ads.pagamento.CartaoCredito;

/**
 * @author Édrey Lucas
 *
 */
public class Pessoa implements Serializable {
	private String nome;
	private Usuario usuario;
	private String telefone;
	private Endereco endereco;
	private CartaoCredito cartaocredito;

	public Pessoa(String nome, Usuario usuario, String telefone, Endereco endereco, CartaoCredito cartaocredito) {
		this.nome = nome;
		this.usuario = usuario;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cartaocredito = cartaocredito;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public Usuario getusuario() {
		return usuario;
	}

	public void setusuario(Usuario usuario) {
		this.usuario = usuario;

	}

	public String gettelefone() {
		return telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;

	}

	public Endereco getendereco() {
		return endereco;
	}

	public void setendereco(Endereco endereco) {
		this.endereco = endereco;

	}

	public CartaoCredito getcartaocredito() {
		return cartaocredito;
	}

	public void setcartaocredito(CartaoCredito cartaocredito) {
		this.cartaocredito = cartaocredito;

	}
}