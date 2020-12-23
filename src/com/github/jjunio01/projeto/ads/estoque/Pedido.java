/**
 * 
 */
package com.github.jjunio01.projeto.ads.estoque;

import java.io.Serializable;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.vendas.Carrinho;
import com.github.jjunio01.projeto.ads.vendas.Vendas;

/**
 * @author Petterson
 *
 */
public class Pedido implements Serializable {

	private Carrinho carrinho;
	private Pessoa cliente; 
	private Vendas venda;

	public Pedido(Carrinho carrinho, Pessoa cliente, Vendas venda) {
		super();
		this.carrinho = carrinho;
		this.cliente = cliente;
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

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public void finalizarPedido() {

	}

	public void alterarCarrinho() {

	}

	public String toString() {
		return "Carrinho :"+ this.getCarrinho().toString()+"\n"
				+ "Cliente :"+this.getCliente().toString()+"\n"
				+"Vendas :"+this.getVenda().toString();
	}
}
