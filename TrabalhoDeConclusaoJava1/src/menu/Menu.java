package menu;

import pessoal.Gerente;
import pessoal.Presidente;
import pessoal.Diretor;
import java.io.IOException;
import java.util.Scanner;

import conta.Conta;
import leitura.Leitura;
import pessoal.Usuario;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.ContaTipoEnum;
import exception.ContaException;

public class Menu {
	public int menuMovimentacaoConta(){
		int opcao;
		Leitura ler = new Leitura();
		System.out.println(" _______________________");
		System.out.println("|______Movimenta��o_____|");
		System.out.println("|                       |");	
		System.out.println("|1- Saque               |");
		System.out.println("|2- Dep�sito            |");
		System.out.println("|3- Tranfer�ncia        |");
		System.out.println("|0- Voltar              |");
		System.out.println("|_______________________|");
		opcao = ler.lerInteiro();
		while(opcao < 0 ||opcao > 3) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente: ");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioCliente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println(" ____________________________________________");
		System.out.println("|__________________Relat�rio_________________|");
		System.out.println("|                                            |");
		System.out.println("|1- Saldo                                    |");
		System.out.println("|2- Relat�rio de tributa��o da conta corrente|");
		System.out.println("|3- Relat�rio de rendimento da poupan�a      |");
		System.out.println("|0- Voltar                                   |");
		System.out.println("|____________________________________________|");
		opcao = ler.lerInteiro();
		while(opcao < 0 ||opcao > 3) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente: ");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioGerente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println(" ____________________________________________");
		System.out.println("|__________________Relat�rio_________________|");
		System.out.println("|                                            |");
		System.out.println("|1- Saldo                                    |");
		System.out.println("|2- Relat�rio de tributa��o da conta corrente|");
		System.out.println("|3- Relat�rio de rendimento da poupan�a      |");
		System.out.println("|4- N�mero contas das ag�ncia gerenciada     |");
		System.out.println("|0- Voltar                                   |");
		System.out.println("|____________________________________________|");
		opcao = ler.lerInteiro();
		while(opcao < 0 || opcao > 4) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente: ");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioDiretor() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println(" _________________________________________________________________");
		System.out.println("|_____________________________Relat�rio___________________________|");
		System.out.println("|                                                                 |");
		System.out.println("|1- Saldo                                                         |");
		System.out.println("|2- Relat�rio de tributa��o da conta corrente                     |");
		System.out.println("|3- Relat�rio de rendimento da poupan�a                           |");
		System.out.println("|4- Relat�rio com as informa��es dos clientes (Nome CPF Ag�ncia)  |");
		System.out.println("|5- Relat�rio do n�mero de contas em uma Ag�ncia                  |");
		System.out.println("|0- Voltar                                                        |");
		System.out.println("|_________________________________________________________________|");
		opcao = ler.lerInteiro();
		while(opcao < 0 || opcao > 5) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente: ");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioPresidente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println(" _________________________________________________________________");
		System.out.println("|_____________________________Relat�rio___________________________|");
		System.out.println("|                                                                 |");
		System.out.println("|1- Saldo                                                         |");
		System.out.println("|2- Relat�rio de tributa��o da conta corrente                     |");
		System.out.println("|3- Relat�rio de rendimento da poupan�a                           |");
		System.out.println("|4- Relat�rio com as informa��es dos clientes (Nome CPF Ag�ncia)  |");
		System.out.println("|5- Relat�rio com o valor de capital do banco                     |");
		System.out.println("|6- Relat�rio do n�mero de contas em uma Ag�ncia                  |");
		System.out.println("|0- Voltar                                                        |");
		System.out.println("|_________________________________________________________________|");
		opcao = ler.lerInteiro();
		while(opcao < 0 || opcao > 6) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente: ");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public void menuCliente(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean continuar = true;
		do {
			System.out.println(" _________________________");
			System.out.println("|___________MENU__________|");
			System.out.println("|                         |");
			System.out.println("|1- Movimenta��o na conta |");
			System.out.println("|2- Relat�rios            |");
			System.out.println("|3- Seguro de Vida        |");
			System.out.println("|4- Sair                  |");
			System.out.println("|_________________________|");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:	switch(menuMovimentacaoConta()) {
				
			
					case 1: contaUsuario.processoSaque(contaUsuario,usuario);
							break;
					case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
							break;
					case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
							break;
					case 0: 
			        		break;
					}
					break;
			case 2: switch(menuRelatorioCliente()) {
					case 1:contaUsuario.imprimirSaldo();
							break;
					case 2: if((contaUsuario.getTipoConta()).equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
								((ContaCorrente)contaUsuario).relatorioTributacao(usuario);
							}
							else
							{	System.out.println("A conta n�o � do tipo Conta Corrente!");
							}
							break;
					case 3: if((contaUsuario.getTipoConta()).equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
								((ContaPoupanca)contaUsuario).processoSimulacaoRendimento(usuario);
							}
							else
							{	System.out.println("A conta n�o � do tipo Conta Poupan�a!");
							}
							break;
					case 0:
							break;
					}
					break;
			case 3:seguroDeVida.seguroVida(contaUsuario, usuario);
				break;
			case 4:continuar = false;
					break;
			default: System.out.println("Op��o inv�lida!");
			 		break;
			}
		}
		while(continuar);
		//sc.close();
	}
		
	
	public void menuGerente(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println(" _________________________");
			System.out.println("|___________MENU__________|");
			System.out.println("|                         |");
			System.out.println("|1- Movimenta��o na conta |");
			System.out.println("|2- Relat�rios            |");
			System.out.println("|3- Sair                  |");
			System.out.println("|_________________________|");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							case 0:
									break;
						}
						break;
				case 2: switch (menuRelatorioGerente()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente!");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a!");
									}
									break;
							case 4: ((Gerente)usuario).relatorioNumeroContas();
									break;
							case 0:
									break;
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida!");
						break;
			}	
		}
		while(continuar);
		//sc.close();
	}
	
	
	public void menuDiretor(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println(" _________________________");
			System.out.println("|___________MENU__________|");
			System.out.println("|                         |");
			System.out.println("|1- Movimenta��o na conta |");
			System.out.println("|2- Relat�rios            |");
			System.out.println("|3- Sair                  |");
			System.out.println("|_________________________|");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							case 0:
									break;
						}
						break;
				case 2: switch (menuRelatorioDiretor()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente!");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a!");
									}
									break;
							case 4: ((Diretor)usuario).relatorioDiretor();
									break;
							case 5: ((Diretor)usuario).relatorioNumeroContas();
									break;
							case 0:
									break;
								
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida!");
						break;
			}	
		}
		while(continuar);
		//sc.close();
	}
	
	public void menuPresidente(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println(" _________________________");
			System.out.println("|___________MENU__________|");
			System.out.println("|                         |");
			System.out.println("|1- Movimenta��o na conta |");
			System.out.println("|2- Relat�rios            |");
			System.out.println("|3- Sair                  |");
			System.out.println("|_________________________|");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							case 0:
									break;
						}
						break;
				case 2: switch (menuRelatorioPresidente()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente!");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento(usuario);
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a!");
									}
									break;
							case 4: ((Presidente)usuario).relatorioPresidente();
									break;
							case 5:	((Presidente)usuario).relatorioCapitalPresidente();
									break;
							case 6:((Presidente)usuario).relatorioNumeroContas();
									break;
							case 0 :
									break;
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida!");
						break;
			}	
		}
		while(continuar);
		//sc.close();
	}
}
