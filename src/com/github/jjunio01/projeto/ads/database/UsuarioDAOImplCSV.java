package com.github.jjunio01.projeto.ads.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public class UsuarioDAOImplCSV implements UsuarioDAO {

	@Override
	public void adicionar(Usuario t) {
		File file = new File(
				"C:\\Users\\JJunio\\eclipse-workspace\\ProjetoLogicaOrientadaObjetos\\docs\\usuarioDataBase.csv");
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {

			br.write(t.getLogin() + "," + t.getSenha());
			br.newLine();
		} catch (IOException e) {
			System.out.println();

		}
	}

	@Override
	public Usuario consultar(String login) throws IOException {

		Usuario usuarioCadastrado = null;

		String path = "C:\\Users\\JJunio\\eclipse-workspace\\ProjetoLogicaOrientadaObjetos\\docs\\usuarioDataBase.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				if (vect[0].equals(login)) {
					usuarioCadastrado = new Usuario(login, vect[1]);
					break;
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return usuarioCadastrado;
	}

	@Override
	public void remover(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Usuario t) {
		
		
	}

	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		String path = "C:\\Users\\JJunio\\eclipse-workspace\\ProjetoLogicaOrientadaObjetos\\docs\\usuarioDataBase.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				listaUsuarios.add(new Usuario(vect[0], vect[1]));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return listaUsuarios;
	}
}
