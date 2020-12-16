package com.github.jjunio01.projeto.ads.pagamento;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;

/**
 * @author Mikael C. Barros
 *
 */
public interface Pagamento {
	
	public boolean realizarPagamento(double valorTotal, Pessoa cliente, EnumPag tipoPagamento, double valorPago);
	public boolean realizarEstorno(double valorTotal, Pessoa cliente, EnumPag tipoPagamento, double valorPago);
}
