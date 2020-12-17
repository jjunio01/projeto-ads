package com.github.jjunio01.projeto.ads.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/**
 * @author JJunio
 *
 */
public class FileUtil {

	public static boolean gravarInformacoes(Object objeto, String caminho) throws IOException {
		File database = new File(caminho);

		if (!database.exists()) {
			database.createNewFile();
		}

		FileOutputStream fileOutputStream = new FileOutputStream(database);
		ObjectOutputStream objectOutPut = new ObjectOutputStream(fileOutputStream);

		objectOutPut.writeObject(objeto);

		objectOutPut.flush();
		fileOutputStream.flush();

		objectOutPut.close();
		fileOutputStream.close();

		return true;
	}

	public static Object recuperarInformacoes(String caminho)
			throws IOException, ClassNotFoundException {

		File database = new File(caminho);

		if (database.exists()) {

			FileInputStream fileInput = new FileInputStream(database);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);

			Object objetoRetorno = objectInput.readObject();

			objectInput.close();
			fileInput.close();

			return objetoRetorno;
		} else {
			JOptionPane.showMessageDialog(null, "Base de dados não existente para recuperar informações.",
					"Sistema CompreAqui", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
