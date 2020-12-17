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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public CartaoCredito getCartaocredito() {
		return cartaocredito;
	}

	public void setCartaocredito(CartaoCredito cartaocredito) {
		this.cartaocredito = cartaocredito;
	}

}