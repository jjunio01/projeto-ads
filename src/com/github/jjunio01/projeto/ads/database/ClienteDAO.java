package com.github.jjunio01.projeto.ads.database;

import java.util.List;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;


/**
 * @author JJunio
 *
 */
public interface ClienteDAO extends DAO<Pessoa> {

	public Pessoa consultar(String nome);
	public void remover(String nome);
}
