package com.github.jjunio01.projeto.ads.database;

import java.util.List;

/**
 * @author JJunio
 *
 */
public interface DAO<T> {

	public void adicionar(T t);

	public void remover(int codigo);

	public void atualizar(T t);

	public List<T> listarTodos();
}
