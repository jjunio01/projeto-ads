package com.github.jjunio01.projeto.ads.vendas;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.database.EstoqueDAOImplTxt;
import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.pagamento.EnumPag;
import com.github.jjunio01.projeto.ads.pagamento.PagamentoDinheiro;
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
			EstoqueDAOImplTxt daoEstoque = new EstoqueDAOImplTxt();
			PagamentoCartao pagamentoRealizado = new PagamentoCartao();
			if (pagamentoRealizado.realizarPagamento(carrinho.getPrecoTotal(), cliente, tipoPagamento)) {
				this.status = EnumVenda.EFETIVADA;
				for (int i = 0; i < this.carrinho.getListaProdutos().size(); i++) {
					daoEstoque.atualizarQuantidade(this.carrinho.getListaProdutos().get(i), this.carrinho.getListaProdutos().get(i).getQuantidadeProduto());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Limite insuficiente no cart�o", "Status de Pagamento",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (tipoPagamento == EnumPag.DINHEIRO) {
			EstoqueDAOImplTxt daoEstoque = new EstoqueDAOImplTxt();
			PagamentoDinheiro pagamentoRealizado = new PagamentoDinheiro();
			if (pagamentoRealizado.realizarPagamento(carrinho.getPrecoTotal(), cliente, tipoPagamento, valorPago)) {
				this.status = EnumVenda.EFETIVADA;
				for (int i = 0; i < this.carrinho.getListaProdutos().size(); i++) {
					daoEstoque.atualizarQuantidade(this.carrinho.getListaProdutos().get(i), this.carrinho.getListaProdutos().get(i).getQuantidadeProduto());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Valor pago menor que o valor da compra"
						+ ""
						+ "1", "Status de Pagamento",
						JOptionPane.INFORMATION_MESSAGE);
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

	public String toString() {
		return "Cliente :" + this.getCliente() + "\n" + "Carrinho :" + this.getCarrinho() + "\n" + "Status da venda :"
				+ this.getStatus();
	}

}
