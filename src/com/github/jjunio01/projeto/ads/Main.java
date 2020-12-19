package com.github.jjunio01.projeto.ads;

import java.util.List;

import javax.swing.JOptionPane;

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

	}

	public static void cadastrarPessoa() {
		String nome = JOptionPane.showInputDialog("Digite o seu Nome:");
		String telefone = JOptionPane.showInputDialog("Digite o número do seu telefone:");
		String cep = JOptionPane.showInputDialog("Digite o CEP:");
		String estado = JOptionPane.showInputDialog("Estado:");
		String cidade = JOptionPane.showInputDialog("Cidade:");
		String bairro = JOptionPane.showInputDialog("Bairro");
		String rua = JOptionPane.showInputDialog("Rua");
		String numero = JOptionPane.showInputDialog("Número da Residência;");
		Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado);
		EnumBandeira bandeira = JOptionPane.showInputDialog("Digite a bandeira do cartão:");
		String numeroCartao = JOptionPane.showInputDialog("Digite o número do seu cartão:");
		String limite = JOptionPane.showInputDialog("Limite:");
		String cvv = JOptionPane.showInputDialog("CVV (Código por trás do cartão):");
		String nomeCartao = JOptionPane.showInputDialog("Digite o nome presente cartão:");
		String validade = JOptionPane.showInputDialog("Validade:");
		CartaoCredito cartaoCredito = new CartaoCredito(bandeira, numeroCartao, limite, cvv, nomeCartao, validade);
		Usuario usuario = cadastrarUsuario();
		Pessoa pessoa = new Pessoa(nomeCartao, usuario, telefone, endereco, cartaocredito);
		
		

	}

	public static Usuario cadastrarUsuario() {
		String login = JOptionPane.showInputDialog("Digite o seu login:");
		String senha = JOptionPane.showInputDialog("Digite o sua senha");
		Usuario usuario = new Usuario (login, senha);
		return usuario;

	}

	public static void cadastrarProduto() {

	}

	public static Estoque cadastrarEstoque() {
		return null;
	}

	public static Pessoa recuperarPessoa(String nome) {
		return null;
	}

	public static Usuario recuperarUsuario(String login) {
		return null;
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