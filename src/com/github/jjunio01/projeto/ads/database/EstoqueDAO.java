package com.github.jjunio01.projeto.ads.database;


import com.github.jjunio01.projeto.ads.estoque.Estoque;

/**
 * @author JJunio
 *
 */

public interface EstoqueDAO extends DAO<Estoque> {

	public Estoque consultar(int codigo);
	public void remover(Estoque estoque);
}
