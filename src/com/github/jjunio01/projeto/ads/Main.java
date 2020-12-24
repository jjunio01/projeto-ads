package com.github.jjunio01.projeto.ads;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.database.ClienteDAOImplTxt;
import com.github.jjunio01.projeto.ads.database.DAO;
import com.github.jjunio01.projeto.ads.database.EstoqueDAO;
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
import com.github.jjunio01.projeto.ads.vendas.Carrinho;

/**
 * @author JJunio
 * @author Édrey Lucas
 * @author Mikael C. Barros
 * @author Petterson
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
					int quantidade = 0;
					ArrayList<Estoque> listaProdutos = new ArrayList<>();
					Carrinho carrinho = new Carrinho(listaProdutos);
					boolean preenchendoCarrinho = true;

					do {

						Estoque estoqueRecuperado = recuperarEstoque();
						if (estoqueRecuperado != null) {
							JOptionPane.showMessageDialog(null, estoqueRecuperado.estoqueCliente(), "Estoque",
									JOptionPane.ERROR_MESSAGE);
							try {
								quantidade = Integer
										.parseInt(JOptionPane.showInputDialog("Digite a quantidade desejada: "));
								carrinho.adicinarProdutoCarrinho(estoqueRecuperado);

							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Digite apenas números", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null, "Produto não cadastrado no estoque", "Estoque",
									JOptionPane.ERROR_MESSAGE);
							break;
						}
						while (true) {
							String novamente = JOptionPane.showInputDialog("Deseja comparar novamente Sim/Não:");
							if (novamente.equals("Não")) {

								preenchendoCarrinho = false;
								break;
							} else if (novamente.equals("Sim")) {
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Opção inválida: Digite Sim ou Não.", "Estoque",
										JOptionPane.ERROR_MESSAGE);
							}
						}

					} while (preenchendoCarrinho);
					break;
				case "3":

					break;
				case "4":

					String login = JOptionPane.showInputDialog("Digite o seu login:");

					Usuario usuario = recuperarUsuario(login);

					boolean logado = true;

					while (logado) {

						if (usuario != null) {
							String senha = JOptionPane.showInputDialog("Digite o sua senha");
							if (senha.equals(usuario.getSenha())) {

								String opcao = JOptionPane.showInputDialog(null,
										"Informe a opÃƒÂ§ÃƒÂ£o desejada! \n #1 Consultar Todo Estoque \n #2 Cadastrar no Estoque \n #3 Consultar Produto do Estoque \n #4 Retirar do Estoque \n #0 Sair",
										JOptionPane.QUESTION_MESSAGE);

								if (opcao.equals("1")) {
									String estoqueTela = "";
									ArrayList<Estoque> estoqueDisponivel = recuperarTodoEstoque();

									if (estoqueDisponivel == null) {
										JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado", "Estoque",
												JOptionPane.ERROR_MESSAGE);
									} else {
										for (int i = 0; i < estoqueDisponivel.size(); i++) {
											estoqueTela += estoqueDisponivel.get(i).getProduto().getNome() + " possui "
													+ estoqueDisponivel.get(i).getQuantidadeProduto() + " "
													+ estoqueDisponivel.get(i).getProduto().getUnidadeMedida()
													+ " (s) no estoque. \n";
										}
									}
									JOptionPane.showMessageDialog(null, estoqueTela, "Estoque total :",
											JOptionPane.INFORMATION_MESSAGE);
								} else if (opcao.equals("2")) {

									cadastrarEstoque();

								} else if (opcao.equals("3")) {

									Estoque estoqueRecuperado = recuperarEstoque();
									if (estoqueRecuperado != null) {
										JOptionPane.showMessageDialog(null, estoqueRecuperado.toString(), "Estoque",
												JOptionPane.ERROR_MESSAGE);

									} else {
										JOptionPane.showMessageDialog(null, "Produto não cadastrado no estoque",
												"Estoque", JOptionPane.ERROR_MESSAGE);
									}

								} else if (opcao.equals("4")) {

									// removerProdutoEstoque();

								} else if (opcao.equals("0")) {
									logado = false;
								} else {
									JOptionPane.showMessageDialog(null,
											"Selecione uma opÃƒÂ§ÃƒÂ£o vÃƒÂ¡lida!", "Erro",
											JOptionPane.ERROR_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro",
										JOptionPane.ERROR_MESSAGE);

							}

						} else {
							JOptionPane.showMessageDialog(null, "UsuÃ¡rio nÃ£o cadastrado!", "Erro",
									JOptionPane.ERROR_MESSAGE);
							logado = false;
						}
					}

					break;

				case "5":
					executando = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Escolha umas das opÃ§Ãµes validas do Menu",
							"Sistema CompreAqui", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	public static void cadastrarPessoa() {

		ClienteDAOImplTxt daoPessoa = new ClienteDAOImplTxt();

		Object[] itens = { EnumBandeira.ELO, EnumBandeira.HIPERCARD, EnumBandeira.MASTERCARD, EnumBandeira.VISA };
		String nome = JOptionPane.showInputDialog("Digite o seu Nome:");
		String telefone = JOptionPane.showInputDialog("Digite o nÃºmero do seu telefone:");
		String cep = JOptionPane.showInputDialog("Digite o CEP:");
		String estado = JOptionPane.showInputDialog("Estado:");
		String cidade = JOptionPane.showInputDialog("Cidade:");
		String bairro = JOptionPane.showInputDialog("Bairro");
		String rua = JOptionPane.showInputDialog("Rua");
		String numero = JOptionPane.showInputDialog("NÃƒÂºmero da ResidÃƒÂªncia;");
		Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado);
		EnumBandeira bandeira = (EnumBandeira) JOptionPane.showInputDialog(null, "Escolha a bandeira do cartÃƒÂ£o",
				"OpÃƒÂ§ao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
		String numeroCartao = JOptionPane.showInputDialog("Digite o nÃƒÂºmero do seu cartÃƒÂ£o:");
		double limite = 0;
		while (true) {
			try {
				limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o limite do cart�o:"));

				break;
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null,
						"ForneÃ¯Â¿Â½a uma informaÃ¯Â¿Â½Ã¯Â¿Â½o vÃ¯Â¿Â½lida!",
						"Valores numÃ¯Â¿Â½ricos Ex. 47.02", JOptionPane.ERROR_MESSAGE);

			}
		}
		String cvv = JOptionPane.showInputDialog("CVV (CÃƒÂ³digo por trÃƒÂ¡s do cartÃƒÂ£o):");
		String nomeCartao = JOptionPane.showInputDialog("Digite o nome presente cartÃƒÂ£o:");
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
		String descricao = JOptionPane.showInputDialog("Digite a descriÃƒÂ§ÃƒÂ£o do produto:");
		String ean = JOptionPane.showInputDialog("Digite o cÃƒÂ³digo ean do produto:");
		EnunUnidadeMedida unidadeMedida = (EnunUnidadeMedida) JOptionPane.showInputDialog(null,
				"Informe a Unidade de Medida do Produto", "OpÃƒÂ§ao", JOptionPane.INFORMATION_MESSAGE, null,
				medidas, medidas[5]);

		while (true) {
			try {
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preÃƒÂ§o do produto:"));
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto:"));

				break;
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null,
						"ForneÃ¯Â¿Â½a uma informaÃ¯Â¿Â½Ã¯Â¿Â½o vÃ¯Â¿Â½lida!",
						"Valores numÃ¯Â¿Â½ricos Ex. 47.02", JOptionPane.ERROR_MESSAGE);

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
		String descricao = JOptionPane.showInputDialog("Digite a descriÃƒÂ§ÃƒÂ£o do produto:");
		String ean = JOptionPane.showInputDialog("Digite o ean do produto:");
		EnunUnidadeMedida unidadeMedida = (EnunUnidadeMedida) JOptionPane.showInputDialog(null,
				"Escolha a unidade mÃ©dida", "OpÃ§Ãµes", JOptionPane.INFORMATION_MESSAGE, null, medidas,
				medidas[0]);

		while (true) {
			try {
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID de produto: "));
				preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preÃƒÂ§o do produto: "));
				quantidadeProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de produto: "));
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produto: "));
				break;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite apenas nÃºmeros no padrÃ£o: EX = 4.67 ", "Erro",
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
		EstoqueDAOImplTxt produtoNome = new EstoqueDAOImplTxt();

		return null;
	}

	public static Estoque recuperarProdutoId(int id) {
		Estoque idCadastrado = null;

		try {
			int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Produto:"));
			EstoqueDAOImplTxt daoProduto = new EstoqueDAOImplTxt();
			idCadastrado = daoProduto.consultar(idProduto);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Forneça uma informação válida!!", "Valores numéricos Ex. 4702",
					JOptionPane.ERROR_MESSAGE);
		}

		return idCadastrado;

	}

	public static Estoque recuperarEstoque() {

		String estoque = JOptionPane.showInputDialog("Digite o Nome do Produto:");

		EstoqueDAOImplTxt daoEstoque = new EstoqueDAOImplTxt();
		Estoque estoqueRecuperado = daoEstoque.consultar(estoque);
		return estoqueRecuperado;

	}

	public static ArrayList<Pessoa> recuperarTodasPessoas() {
		ClienteDAOImplTxt listaPessoas = new ClienteDAOImplTxt();

		return listaPessoas.listarTodos();

	}

	public static ArrayList<Usuario> recuperarTodosUsuarios() {
		UsuarioDAOImplTxt listaUsuarios = new UsuarioDAOImplTxt();
		return listaUsuarios.listarTodos();
	}

	public static ArrayList<Estoque> recuperarTodoEstoque() {

		EstoqueDAOImplTxt listaEstoque = new EstoqueDAOImplTxt();

		return listaEstoque.listarTodos();

	}

	public static void atualizarProdutoEstoque() {
		EstoqueDAOImplTxt daoProduto = new EstoqueDAOImplTxt();
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID produto que deseja remover:"));
			Estoque idRemocao = recuperarProdutoId(id);

			double quantidadeRemovidaUsuario = Double
					.parseDouble(JOptionPane.showInputDialog("Informe a quantidade do produto que deseja remover:"));
			if (quantidadeRemovidaUsuario <= idRemocao.getQuantidadeProduto()) {
				daoProduto.atualizarQuantidade(idRemocao, quantidadeRemovidaUsuario);
				JOptionPane.showInputDialog("Quantidade de produtos atualizada com sucesso!");
			} else {
				JOptionPane.showInputDialog("Quantidade informada � superior a quantidade existente no estoque!" + "\n"
						+ idRemocao.getQuantidadeProduto() + "produtos no estoque atualmente");
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Forneça uma informação válida!!", "Valores numéricos Ex. 47.02",
					JOptionPane.ERROR_MESSAGE);

		}

	}

}