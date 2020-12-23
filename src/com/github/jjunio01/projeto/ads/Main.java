package com.github.jjunio01.projeto.ads;

import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.database.ClienteDAOImplTxt;
import com.github.jjunio01.projeto.ads.database.DAO;
import com.github.jjunio01.projeto.ads.database.EstoqueDAOImplTxt;
import com.github.jjunio01.projeto.ads.database.UsuarioDAO;
import com.github.jjunio01.projeto.ads.database.UsuarioDAOImplTxt;
import com.github.jjunio01.projeto.ads.entidades.Endereco;
import com.github.jjunio01.projeto.ads.entidades.Pessoa;
import com.github.jjunio01.projeto.ads.entidades.Usuario;
import com.github.jjunio01.projeto.ads.estoque.EnunUnidadeMedida;
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
					"#1 - Realizar Cadastro\n" + "#2 - Comprar\n" + "#3 - Consultar compras realizadas\n"
							+ "#4 - Gerenciar Estoque\n" + "#5 - Sair",
					"Sistema CompreAqui", JOptionPane.QUESTION_MESSAGE);
			if (menu == null) {
				break;
			} else {
				switch (menu) {

				case "1":
					cadastrarPessoa();
					break;
				case "2":
					cadastrarEstoque();
					break;
				case "3":
					cadastrarUsuario();

					break;
				case "4":
					String login = JOptionPane.showInputDialog("Digite o seu login:");

					Usuario usuario = recuperarUsuario(login);

					if (usuario != null) {
						String senha = JOptionPane.showInputDialog("Digite o sua senha");
						if (senha.equals(usuario.getSenha())) {

							cadastrarProduto();
							cadastrarEstoque();

						} else {
							JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);

						}

					} else {
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

					break;

				case "5":
					executando = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Escolha umas das opções validas do Menu",
							"Sistema CompreAqui", JOptionPane.ERROR_MESSAGE);
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
		String numero = JOptionPane.showInputDialog("NÃºmero da ResidÃªncia;");
		Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado);
		EnumBandeira bandeira = (EnumBandeira) JOptionPane.showInputDialog(null, "Escolha a bandeira do cartÃ£o",
				"OpÃ§ao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
		String numeroCartao = JOptionPane.showInputDialog("Digite o nÃºmero do seu cartÃ£o:");
		double limite = Double.parseDouble(JOptionPane.showInputDialog("Limite:"));
		String cvv = JOptionPane.showInputDialog("CVV (CÃ³digo por trÃ¡s do cartÃ£o):");
		String nomeCartao = JOptionPane.showInputDialog("Digite o nome presente cartÃ£o:");
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
		daoUsuario.adicionar(usuario);
		return usuario;
	}

	public static void cadastrarProduto() {

		Object[] medidas = { EnunUnidadeMedida.CAIXA, EnunUnidadeMedida.LITRO, EnunUnidadeMedida.KGRAMA,
				EnunUnidadeMedida.ML, EnunUnidadeMedida.KILO, EnunUnidadeMedida.UNIDADE };

		String nome = JOptionPane.showInputDialog("Digite o Nome do produto:");
		String descricao = JOptionPane.showInputDialog("Digite a descriÃ§Ã£o do produto:");
		String ean = JOptionPane.showInputDialog("Digite o cÃ³digo ean do produto:");
		EnunUnidadeMedida unidadeMedida = (EnunUnidadeMedida) JOptionPane.showInputDialog(null,
				"Informe a Unidade de Medida do Produto", "OpÃ§ao", JOptionPane.INFORMATION_MESSAGE, null, medidas,
				medidas[5]);

		while (true) {
			try {
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preÃ§o do produto:"));
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto:"));

				break;
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Forneï¿½a uma informaï¿½ï¿½o vï¿½lida!",
						"Valores numï¿½ricos Ex. 47.02", JOptionPane.ERROR_MESSAGE);

			}
		}

	}

	public static void cadastrarEstoque() {

		double preco;
		double quantidadeProduto;
		int codigo;
		int id;

		Object[] medidas = { EnunUnidadeMedida.CAIXA, EnunUnidadeMedida.LITRO, EnunUnidadeMedida.KGRAMA,
				EnunUnidadeMedida.ML, EnunUnidadeMedida.KILO, EnunUnidadeMedida.UNIDADE };
		EstoqueDAOImplTxt daoEstoque = new EstoqueDAOImplTxt();
		String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
		String descricao = JOptionPane.showInputDialog("Digite a descriÃ§Ã£o do produto:");
		String ean = JOptionPane.showInputDialog("Digite o ean do produto:");
		EnunUnidadeMedida unidadeMedida = (EnunUnidadeMedida) JOptionPane.showInputDialog(null,
				"Escolha a unidade médida", "Opções", JOptionPane.INFORMATION_MESSAGE, null, medidas, medidas[0]);

		while (true) {
			try {
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID de produto: "));
				preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preÃ§o do produto: "));
				quantidadeProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de produto: "));
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produto: "));
				break;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite apenas números no padrão: EX = 4.67 ", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		Produto produto = new Produto(nome, descricao, ean, unidadeMedida, preco, id);
		Estoque estoque = new Estoque(quantidadeProduto, produto, codigo);
		daoEstoque.adicionar(estoque);

	}

	public static Pessoa recuperarPessoa() {

		String nome = JOptionPane.showInputDialog("Digite o Nome do cliente:");

		ClienteDAOImplTxt daoCliente = new ClienteDAOImplTxt();
		Pessoa clienteCadastrado = daoCliente.consultar(nome);
		return clienteCadastrado;

	}

	public static Usuario recuperarUsuario(String login) {

		UsuarioDAOImplTxt daoUsuario = new UsuarioDAOImplTxt();
		Usuario usuarioCadastrado = daoUsuario.consultar(login);
		return usuarioCadastrado;
	}

	public static Produto recuperarProdutoNome(String nome) {
		return null;
	}

	public static Produto recuperarProdutoId(int id) {
		return null;
	}

	public static Estoque recuperarEstoque() {
		
		String estoque = JOptionPane.showInputDialog("Digite o Nome do Produto:");
		
		EstoqueDAOImplTxt daoEstoque = new EstoqueDAOImplTxt();
		Estoque estoqueRecuperado = daoEstoque.consultar(estoque);
		return estoqueRecuperado;
	
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