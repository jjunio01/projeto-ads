package com.github.jjunio01.projeto.ads.database;

import java.util.List;

import com.github.jjunio01.projeto.ads.entidades.Pessoa;

/**
 * @author JJunio
 *
 */
public interface ClienteDAO {

	
	public void adicionarCliente(Pessoa cliente);

	public Pessoa getCliente(int codigo);

	public void removerCliente(int codigo);

	public void atualizarCliente(Pessoa cliente);

	public List<Pessoa> listarTodosClientes();
	
}
