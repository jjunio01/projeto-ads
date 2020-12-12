package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public interface UsuarioDAO extends DAO<Usuario> {
	
	public Usuario consultar(String login) throws IOException;
}
