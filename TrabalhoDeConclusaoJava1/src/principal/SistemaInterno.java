package principal;

import java.io.IOException;
import java.util.Scanner;

import bancoDeDados.BancoDados;
import conta.*;
import enums.ContaTipoEnum;
import exception.ContaException;
import leituraEscritaArquivo.LeArquivo;
import menu.Menu;
import pessoal.Usuario;

public class SistemaInterno {
	
	
	public static void main(String[] args) throws IOException, ContaException {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		String senha, cpf;
		Usuario usuario = new Usuario();
		
	
		LeArquivo.leArquivoUsuario();
		//Log in
		System.out.println(" ____________________________");
		System.out.println("|                            |");
		System.out.print("|Digite seu CPF :");
		cpf= sc.next();

	
		usuario = BancoDados.mapUsuario.get(cpf);
		
			while(usuario==null) {
				System.out.println("CPF não encontrado. Insira novo CPF");
				cpf= sc.next();
				usuario = BancoDados.mapUsuario.get(cpf);
			}

		System.out.print("|Digite sua senha:");
		senha= sc.next();

		while(!usuario.getSenhaUsuario().equals(senha)) {
			System.out.println("Senha Incorreta. Insira nova senha");
			senha= sc.next();
		}
		System.out.println("|____________________________|\n");
		
		LeArquivo.leArquivoDevolveListaContas();
		
		if((BancoDados.mapContas.get(usuario.getNumConta()).getTipoConta()).equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())){
			ContaCorrente contaUsuario = new ContaCorrente();
			contaUsuario =(ContaCorrente) BancoDados.mapContas.get(usuario.getNumConta());
			
			switch(usuario.getTipo()) {
			case "Cliente": 	menu.menuCliente(contaUsuario,usuario);
								break;
			case "Gerente": 	menu.menuGerente(contaUsuario,usuario);
								break;
			case "Diretor": 	menu.menuDiretor(contaUsuario,usuario);
								break;
			case "Presidente":  menu.menuPresidente(contaUsuario,usuario);
								break;
			default: 		System.out.println("Erro");
							break;
			}
		}
		else if((BancoDados.mapContas.get(usuario.getNumConta()).getTipoConta()).equalsIgnoreCase( ContaTipoEnum.POUPANCA.getTipo())){
			ContaPoupanca contaUsuario = new ContaPoupanca();
			contaUsuario = (ContaPoupanca) BancoDados.mapContas.get(usuario.getNumConta());
			
			switch(usuario.getTipo()) {
			case "Cliente":		 menu.menuCliente(contaUsuario,usuario);
								break;
			case "Gerente": 	menu.menuGerente(contaUsuario,usuario);
								break;		
			case "Diretor": 	menu.menuDiretor(contaUsuario,usuario);
								break;
			case "Presidente":  menu.menuPresidente(contaUsuario,usuario);
								break;				
			default: 		System.out.println("Erro");
							break;
			}
		}
		else {
			System.out.println("Erro tipo de conta inválida");
		}
		
		sc.close();
		}
	}	



