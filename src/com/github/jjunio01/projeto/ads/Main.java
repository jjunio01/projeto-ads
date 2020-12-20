package com.github.jjunio01.projeto.ads;

import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.database.ClienteDAOImplTxt;
import com.github.jjunio01.projeto.ads.database.DAO;
import com.github.jjunio01.projeto.ads.database.UsuarioDAOImplTxt;
import com.github.jjunio01.projeto.ads.entidades.Endereco;
import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.entidades.Usuario;
import com.github.jjunio01.projeto.ads.estoque.Estoque;
import com.github.jjunio01.projeto.ads.estoque.Produto;
import com.github.jjunio01.projeto.ads.pagamento.CartaoCredito;
import com.github.jjunio01.projeto.ads.pagamento.EnumBandeira;

/**
 * @author JJunio
 *
 */
public class Main {

	public static void main(String[] args) {

		boolean executando = true;

		while (executando) {
			String menu = JOptionPane.showInputDialog(null,
					"#1 - Realizar Cadastro\n" + 
					"#2 - Comprar\n" + 
					"#3 - Consultar compras realizadas\n" +
					"#4 - Gerenciar Estoque\n" + 
					"#5 - Sair",
					"Sistema CompreAqui", JOptionPane.QUESTION_MESSAGE);
			if (menu == null) {
				break;
			} else {
				switch (menu) {

				case "1":
					cadastrarPessoa();
					break;
				case "2":

					break;
				case "3":

					break;
				case "4":

					break;

				case "5":
					executando = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Escolha umas das opções validas do Menu", "Sistema CompreAqui",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	public static void cadastrarPessoa() {
		
		ClienteDAOImplTxt daoPessoa = new ClienteDAOImplTxt();
		
		Object[] itens = { EnumBandeira.ELO, EnumBandeira.HIPERCARD, EnumBandeira.MASTERCARD, EnumBandeira.VISA };
		String nome = JOptionPane.showInputDialog("Digite o seu Nome:");
		String telefone = JOptionPane.showInputDialog("Digite o número do seu telefone:");
		String cep = JOptionPane.showInputDialog("Digite o CEP:");
		String estado = JOptionPane.showInputDialog("Estado:");
		String cidade = JOptionPane.showInputDialog("Cidade:");
		String bairro = JOptionPane.showInputDialog("Bairro");
		String rua = JOptionPane.showInputDialog("Rua");
		String numero = JOptionPane.showInputDialog("Número da Residência;");
		Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado);
		EnumBandeira bandeira = (EnumBandeira) JOptionPane.showInputDialog(null, "Escolha a bandeira do cartão",
				"Opçao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
		String numeroCartao = JOptionPane.showInputDialog("Digite o número do seu cartão:");
		double limite = Double.parseDouble(JOptionPane.showInputDialog("Limite:"));
		String cvv = JOptionPane.showInputDialog("CVV (Código por trás do cartão):");
		String nomeCartao = JOptionPane.showInputDialog("Digite o nome presente cartão:");
		String validade = JOptionPane.showInputDialog("Validade:");
		CartaoCredito cartaoCredito = new CartaoCredito(bandeira, numeroCartao, limite, cvv, nomeCartao, validade);
		Usuario usuario = cadastrarUsuario();
		Pessoa pessoa = new Pessoa(nome, usuario, telefone, endereco, cartaoCredito);
		
		daoPessoa.adicionar(pessoa);

	}

	public static Usuario cadastrarUsuario() {

		UsuarioDAOImplTxt daoUsuario = new UsuarioDAOImplTxt();
		String login = JOptionPane.showInputDialog("Digite o seu login:");
		String senha = JOptionPane.showInputDialog("Digite o sua senha");
		Usuario usuario = new Usuario(login, senha);
		return usuario;
	}

	public static Produto cadastrarProduto() {
		return null;
	}

	public static Estoque cadastrarEstoque() {
		return null;
	}

	public static Pessoa recuperarPessoa(String nome) {
		return null;
	}

	public static Usuario recuperarUsuario(String login) {

		UsuarioDAOImplTxt daoUsuario = new UsuarioDAOImplTxt();
		Usuario usuarioCadastrado = daoUsuario.consultar(login);
		return usuarioCadastrado;
	}

	public static Produto recuperarProduto(String nome) {
		return null;
	}

	public static Produto recuperarProduto(int id) {
		return null;
	}

	public static Estoque recuperarEstoque(Produto produto) {
		return null;
	}

	public static List<Pessoa> recuperarTodasPessoas() {
		return null;
	}

	public static List<Usuario> recuperarTodosUsuarios() {
		return null;
	}

	public static List<Produto> recuperarTodosProdutos() {
		return null;
	}

	public static List<Estoque> recuperarTodoEstoque() {
		return null;
	}

}