package com.github.jjunio01.projeto.ads.database;

import java.util.ArrayList;

/**
 * @author JJunio
 *
 */
public interface DAO<T> {

	public void adicionar(T t);

	public void atualizar(T t);

	public ArrayList<T> listarTodos();

	void adicionarLista(ArrayList<T> t);
}
