package com.github.jjunio01.projeto.ads.pagamento;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;

public class pagamentoCartao {

	public boolean realizarPagamento(double valorTotal, Pessoa cliente, EnumPag tipoPagamento) {
		if (cliente.getCartaocredito().getLimite() >= valorTotal) {
			double pagamento = cliente.getCartaocredito().getLimite() - valorTotal;
			cliente.getCartaocredito().setLimite(pagamento);
			JOptionPane.showMessageDialog(null, "Compra realizado com sucesso", "Status de Pagamento",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}

		else {
			return false;
		}

	}

	public boolean realizarEstorno(double valorTotal, Pessoa cliente, EnumPag tipoPagamento) {
		double estorno = cliente.getCartaocredito().getLimite() + valorTotal;
		cliente.getCartaocredito().setLimite(estorno);
		JOptionPane.showMessageDialog(null, "Estorno realizado com sucesso", "Status do estorno",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

}
