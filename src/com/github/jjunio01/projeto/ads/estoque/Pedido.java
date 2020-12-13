/**
 * 
 */
package com.github.jjunio01.projeto.ads.estoque;

import java.io.Serializable;

import com.github.jjunio01.projeto.ads.vendas.Carrinho;
import com.github.jjunio01.projeto.ads.vendas.Vendas;

/**
 * @author Petterson
 *
 */
public class Pedido implements Serializable{

	private Carrinho carrinho;
	/* private Pessoa cliente; */
	private Vendas venda;

	public Pedido(Carrinho carrinho, Vendas venda) {
		
		this.carrinho = carrinho;
		this.venda = venda;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Vendas getVenda() {
		return venda;
	}

	public void setVenda(Vendas venda) {
		this.venda = venda;
	}

	public void consultarCarrinho() {

	}

	public void finalizarPedido() {

	}

	public void alterarCarrinho() {

	}
}
