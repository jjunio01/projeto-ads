package com.github.jjunio01.projeto.ads.database;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public interface UsuarioDAO extends DAO<Usuario> {

	public void remover(String login);

	public Usuario consultar(String login);
}
