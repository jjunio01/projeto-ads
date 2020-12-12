package com.github.jjunio01.projeto.ads.vendas;

import javax.swing.JOptionPane;


/**
 * @author JJunio
 *
 */
public class Vendas {

	// private Pessoa cliente;
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

	public void efetivarVenda() {
		/*
		if (this.status == EnumVenda.PROCESSAMENTO) {
			if (Pagamento.realizarPagamento(double valorTotal, Pessoa cliente, EumPag tipoPagamento))) {
				this.status = EnumVenda.EFETIVADA;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Status da venda não permite a sua efetivação.");
		}*/
	}

	public void estornarVenda() {
		//this.pagamento = Pagamento.realizarEstorno();
		this.status = EnumVenda.ESTORNADA;
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
