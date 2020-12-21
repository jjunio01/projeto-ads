package com.github.jjunio01.projeto.ads.vendas;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.pagamento.EnumPag;
import com.github.jjunio01.projeto.ads.pagamento.PagamentoDinheiro;
import com.github.jjunio01.projeto.ads.pagamento.pagamentoCartao;
import com.github.jjunio01.projeto.ads.pagamento.PagamentoCartao;

/**
 * @author JJunio
 *
 */
public class Vendas {

	private Pessoa cliente;
	private Carrinho carrinho;
	private EnumVenda status;

	public Vendas(Carrinho carrinho) {
		this.carrinho = carrinho;
		this.status = EnumVenda.PROCESSAMENTO;
	}

	public Vendas() {
		this.status = EnumVenda.PROCESSAMENTO;
	}

	public void cancelarVenda() {
		this.status = EnumVenda.CANCELADA;
	}

	public void efetivarVenda(EnumPag tipoPagamento, double valorPago) {

		if (tipoPagamento == EnumPag.CARTAO) {
			PagamentoCartao pagamentoRealizado = new PagamentoCartao();
			if (pagamentoRealizado.realizarPagamento(carrinho.getPrecoTotal(), cliente, tipoPagamento)) {
				this.status = EnumVenda.EFETIVADA;
			}
		} else if (tipoPagamento == EnumPag.DINHEIRO) {
			PagamentoDinheiro pagamentoRealizado = new PagamentoDinheiro();
			if (pagamentoRealizado.realizarPagamento(carrinho.getPrecoTotal(), cliente, tipoPagamento, valorPago)) {
				this.status = EnumVenda.EFETIVADA;
			}
		}
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public void setStatus(EnumVenda status) {
		this.status = status;
	}

	public void estornarVenda(EnumPag tipoPagamento, double valorPago) {

		if (tipoPagamento == EnumPag.CARTAO) {
			PagamentoCartao pagamentoRealizado = new PagamentoCartao();
			if (pagamentoRealizado.realizarEstorno(carrinho.getPrecoTotal(), cliente, tipoPagamento)) {
				this.status = EnumVenda.ESTORNADA;
			}
		} else if (tipoPagamento == EnumPag.DINHEIRO) {
			PagamentoDinheiro pagamentoRealizado = new PagamentoDinheiro();
			if (pagamentoRealizado.realizarEstorno(carrinho.getPrecoTotal(), cliente, tipoPagamento, valorPago)) {
				this.status = EnumVenda.ESTORNADA;
			}
		}
	}

	public void gerarCupom() {
		CupomVenda.mostrarCupom(this);
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public EnumVenda getStatus() {
		return status;
	}

}
