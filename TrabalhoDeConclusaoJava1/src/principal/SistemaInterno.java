package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import conta.*;
import leitura.Leitura;
import menu.Menu;
import pessoal.Cliente;
import pessoal.Funcionario;
import pessoal.Usuario;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		String senha, cpf;
		
		
		Conta contaUsuario = new ContaCorrente();
		Conta contaDestino = new ContaPoupanca();
		Usuario usuario = new Usuario();
		
		
		Map<String, Usuario> mapUsuario = new HashMap<>();
		
		mapUsuario = Usuario.getUsuarios();
		
		//Log in
		System.out.println("Digite seu CPF : ");
		cpf= sc.next();
		
		usuario = mapUsuario.get(cpf);
		
		while(usuario==null) {
			System.out.println("CPF não encontrado. Insira novo CPF");
			cpf= sc.next();
			usuario = mapUsuario.get(cpf);
		}
		System.out.println(usuario);
		System.out.println("Digite sua senha: ");
		senha= sc.next();

		while(!usuario.getSenhaUsuario().equals(senha)) {
			System.out.println("Senha Incorreta. Insira nova senha");
			senha= sc.next();//sc.next();
		}
		
		Map<Integer, Conta>	mapContas = new HashMap<>();
		mapContas = Conta.getContas();
		
		contaUsuario = mapContas.get(usuario.getNumConta());
		
		switch(usuario.getCargo()) {
		case Cliente: 	menu.menuCliente(contaUsuario);
						break;
						
		default: 		System.out.println("Erro");
						break;
		}
		
		System.out.println(contaUsuario);
		//Menu Cliente
		
		}	
		
	}	



