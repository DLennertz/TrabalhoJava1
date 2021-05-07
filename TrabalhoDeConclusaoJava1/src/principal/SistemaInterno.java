package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import conta.*;
import enums.ContaTipoEnum;
import leitura.Leitura;
import menu.Menu;
import pessoal.Cliente;
import pessoal.Funcionario;
import pessoal.Usuario;
import pessoal.Gerente;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		String senha, cpf;
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
			senha= sc.next();
		}
	
		Map<Integer, Conta>	mapContas = new HashMap<>();
		mapContas = Conta.getContas();
		
		if(mapContas.get(usuario.getNumConta()).getTipoConta() == ContaTipoEnum.CORRENTE.getTipo()){
			ContaCorrente contaUsuario = new ContaCorrente();
			contaUsuario =(ContaCorrente) mapContas.get(usuario.getNumConta());
			
			switch(usuario.getTipo()) {
			case "Cliente": 	menu.menuCliente(contaUsuario);
							break;
			case "Gerente": menu.menuGerente(contaUsuario,usuario);
							break;
			default: 		System.out.println("Erro");
							break;
			}
		}
		else if(mapContas.get(usuario.getNumConta()).getTipoConta() == ContaTipoEnum.POUPANCA.getTipo()){
			ContaPoupanca contaUsuario = new ContaPoupanca();
			contaUsuario = (ContaPoupanca) mapContas.get(usuario.getNumConta());
			
			switch(usuario.getTipo()) {
			case "Cliente": 	menu.menuCliente(contaUsuario);
							break;
							
			default: 		System.out.println("Erro");
							break;
			}
		}
		else {
			System.out.println("Erro tipo de conta inválida");
		}
		
		
		System.out.println(mapContas.get(12));
		System.out.println(mapContas.get(10));
		//Menu Cliente
		
		}
	}	



