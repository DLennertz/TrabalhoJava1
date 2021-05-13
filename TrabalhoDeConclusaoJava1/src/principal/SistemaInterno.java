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
		boolean continuar= true;
		int opcao;
		
		LeArquivo.leArquivoDevolveListaContas();
		LeArquivo.leArquivoUsuario();
		//Log in
		while(continuar) {
		System.out.println(" ___________________________________________");
		System.out.println("|                                           |");
		System.out.print("|Digite seu CPF : ");
		cpf= sc.next();
		
		usuario = BancoDados.mapUsuario.get(cpf);
		
		while(usuario==null) {
			System.out.print("|CPF não encontrado. Insira novo CPF: ");
			cpf= sc.next();
			usuario = BancoDados.mapUsuario.get(cpf);
		}
		System.out.print("|Digite sua senha: ");
		senha= sc.next();

		while(!usuario.getSenhaUsuario().equals(senha)) {
			System.out.print("|Senha Incorreta. Insira nova senha: ");
			senha= sc.next();
		}
		System.out.println("|___________________________________________|\n");
		
		
		
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
			default: 		System.out.println("Erro!");
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
			default: 		System.out.println("Erro!");
							break;
			}
		}
		else {
			System.out.println("Erro tipo de conta inválida!");
		}
		System.out.println(" ___________________________");
		System.out.println("|Deseja realizar novo log-in?|");
		System.out.println("|1- Sim                      |");
		System.out.println("|2- Não                      |");
		System.out.println("|___________________________ |\n");
		opcao= sc.nextInt();
		
		while(opcao>2 || opcao<1) {
			System.out.println("Erro. Opção inválida. Reinsira a opção");
			opcao = sc.nextInt();
		}
			
		if(opcao==2) {
			continuar=false;
		}
		
		}
		}
	}	



