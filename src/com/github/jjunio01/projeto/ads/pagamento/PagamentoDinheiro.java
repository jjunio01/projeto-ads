package com.github.jjunio01.projeto.ads.pagamento;

import javax.swing.JOptionPane;

/**
 * @author Mikael C. Barros
 *
 */
public class PagamentoDinheiro implements Pagamento {

	@Override
	public boolean realizarPagamento(double valorTotal, Pessoa cliente, EnumPag tipoPagamento, double valorPago) {
		if (valorPago >= valorTotal) {
			double troco = valorPago - valorTotal;
			JOptionPane.showMessageDialog(null, "Seu troco é de R$" + troco, "Troco", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}

		else {
			return false;
		}
	}

	@Override
	public boolean realizarEstorno(double valorTotal, Pessoa cliente, EnumPag tipoPagamento, double valorPago) {
		double estorno = valorTotal;
		JOptionPane.showMessageDialog(null, "O valor estornado foi de R$" + estorno, "Estorno", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

}
