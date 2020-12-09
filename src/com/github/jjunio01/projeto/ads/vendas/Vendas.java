package com.github.jjunio01.projeto.ads.vendas;

import com.github.jjunio01.projeto.ads.pagamento.Pagamento;

/**
 * @author JJunio
 *
 */
public class Vendas {

	// private Pessoa cliente;
	private Carrinho carrinho;
	private Pagamento pagamento;
	private EnumVenda status;

	public void processarVenda(Carrinho carrinho) {
		if (carrinho.getStatus().equals(EnumVenda.PROCESSAMENTO)) {
			
		}
	}

	public void cancelarVenda() {

	}

	public void efetivarVenda() {

	}

	public void estornarVenda() {

	}

	public void gerarCupom() {
		CupomVenda.mostrarCupom();
	}
}
