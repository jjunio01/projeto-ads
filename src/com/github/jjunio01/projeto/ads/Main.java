package com.github.jjunio01.projeto.ads;

import java.util.ArrayList;
import java.util.List;

import com.github.jjunio01.projeto.ads.database.ClienteDAOImplTxt;
import com.github.jjunio01.projeto.ads.entidades.Endereco;
import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.entidades.Usuario;
import com.github.jjunio01.projeto.ads.pagamento.CartaoCredito;
import com.github.jjunio01.projeto.ads.pagamento.EnumBandeira;

/**
 * @author JJunio
 *
 */
public class Main {

	public static void main(String[] args) {

		Pessoa c = new Pessoa("Zé", new Usuario("super", "0800"), "0200",
				new Endereco("Rua aqui", 100, 555, "aquele", "city", "pe"),
				new CartaoCredito(EnumBandeira.ELO, "4001", 1000.00, 200, "Ze ze", 20));
		
		ClienteDAOImplTxt daoCli = new ClienteDAOImplTxt();
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(c);
		daoCli.adicionarLista(pessoas);

	}

}