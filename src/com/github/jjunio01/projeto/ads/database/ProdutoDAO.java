package com.github.jjunio01.projeto.ads.database;

import java.util.List;

/**
 * @author JJunio
 *
 */
public interface ProdutoDAO {

	public void adicionarProduto(Produto produto);

	public Produto getProduto(int codigo);

	public void removerProduto(int codigo);

	public void atualizarProduto(Produto produto);

	public List<Produto> listarTodosProdutos();
}
