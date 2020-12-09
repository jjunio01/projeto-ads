package com.github.jjunio01.projeto.ads.database;

import java.util.List;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public interface UsuarioDAO {

	public void adicionarUsuario(Usuario usuario);

	public Usuario getUsuario(int codigo);

	public void removerUsuario(int codigo);

	public void atualizarUsuario(Usuario usuario);

	public List<Usuario> listarTodosUsuario();
}
