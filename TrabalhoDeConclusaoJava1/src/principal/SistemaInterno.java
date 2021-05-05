package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cliente.Cliente;
import conta.*;
import leitura.Leitura;
import menu.Menu;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		String senha, cpf;
		int opcao;
		boolean continuar = true;
		Conta contaUsuario = new ContaCorrente();
		Conta contaDestino = new ContaPoupanca();
		Cliente usuario = new Cliente();
		
		
		Map<String, Cliente> mapClientes = new HashMap<>();
		
		mapClientes = Cliente.getClientes();
		
		
		//Log in
		System.out.println("Digite seu CPF : ");
		cpf= sc.next();
		
		usuario = mapClientes.get(cpf);
		
		while(usuario==null) {
			System.out.println("CPF não encontrado. Insira novo CPF");
			cpf= sc.next();
			usuario = mapClientes.get(cpf);
		}
		
		System.out.println(usuario);
		
		System.out.println("Digite sua senha: ");
		senha= sc.next();

		while(usuario.getSenhaCliente()!=senha) {
			System.out.println("Senha Incorreta. Insira nova senha");
			senha= usuario.getSenhaCliente();//sc.next();
		}
		
		Map<String, Conta>	mapContas = new HashMap<>();
		mapContas = Conta.getContas();
		contaUsuario = mapContas.get(usuario.getCpfCliente());
		System.out.println(contaUsuario);
		//Menu Cliente
		while(continuar) {
			switch(menu.menuCliente()) {
			case 1: contaUsuario.processoSaque();
					break;
			case 2: contaUsuario.processoDeposito();
					break;
			case 3: contaUsuario.processoTransferencia();
					break;
			default: System.out.println("Opção invalida");
	        		break;
			}
			
			System.out.println(contaUsuario);
			System.out.println("Deseja realizar nova operação? 1-sim 2-não");
			opcao = sc.nextInt();
			
			while(opcao != 1 && opcao !=2) {
				System.out.println("Opção invalida. insira nova opção");
				opcao = sc.nextInt();
			}
			if(opcao == 2) {
				continuar = false; 
			}
		}	
	}	
}


