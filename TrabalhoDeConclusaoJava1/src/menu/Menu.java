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

public class Menu {
	public int menuMovimentacaoConta(){
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saque");
		System.out.println("2- Dep�sito");
		System.out.println("3 - Tranfer�ncia de conta para conta");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Op��o inv�lida. Escolha uma op��o novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioCliente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saldo");
		System.out.println("2- Relat�rio de tributa��o da conta corrente");
		System.out.println("3 - Relat�rio de Rendimento da poupan�a");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Op��o invalida. Escolha uma op��o novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioGerente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saldo");
		System.out.println("2- Relat�rio de tributa��o da conta corrente");
		System.out.println("3 - Relat�rio de Rendimento da poupan�a");
		System.out.println("4 - N�mero contas das ag�ncia gerenciada");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 4) {
			System.out.println("Op��o invalida. Escolha uma op��o novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioDiretor() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saldo");
		System.out.println("2- Relat�rio de tributa��o da conta corrente");
		System.out.println("3 - Relat�rio de Rendimento da poupan�a");
		System.out.println("4 - Relat�rio com as informa��es dos clientes (Nome CPF Ag�ncia)");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 4) {
			System.out.println("Op��o invalida. Escolha uma op��o novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorioPresidente() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saldo");
		System.out.println("2- Relat�rio de tributa��o da conta corrente");
		System.out.println("3 - Relat�rio de Rendimento da poupan�a");
		System.out.println("4 - Relat�rio com as informa��es dos clientes (Nome CPF Ag�ncia)");
		System.out.println("5 - Relat�rio com o valor de capital do banco");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 5) {
			System.out.println("Op��o invalida. Escolha uma op��o novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public void menuCliente(Conta contaUsuario, Usuario usuario) throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean continuar = true;
		do {
			System.out.println("1- Movimenta��o na conta\n2- Relat�rios\n3- Sair");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:	switch(menuMovimentacaoConta()) {
					case 1: contaUsuario.processoSaque(contaUsuario,usuario);
							break;
					case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
							break;
					case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
							break;
					default: System.out.println("Op��o invalida");
			        		break;
					}
					break;
			case 2: switch(menuRelatorioCliente()) {
					case 1:contaUsuario.imprimirSaldo();
							break;
					case 2: if((contaUsuario.getTipoConta()).equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
								((ContaCorrente)contaUsuario).relatorioTributacao();
							}
							else
							{	System.out.println("A conta n�o � do tipo Conta Corrente");
							}
							break;
					case 3: if((contaUsuario.getTipoConta()).equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
								((ContaPoupanca)contaUsuario).processoSimulacaoRendimento();
							}
							else
							{	System.out.println("A conta n�o � do tipo Conta Poupan�a");
							}
							break;
					default:System.out.println("Erro");
							break;
					}
					break;
			case 3:continuar = false;
					break;
			default: System.out.println("Op��o inv�lida");
			 		break;
			}
		}
		while(continuar);
		sc.close();
	}
		
	
	public void menuGerente(Conta contaUsuario, Usuario usuario) throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println("1- Movimenta��o da conta\n 2- Relat�rios \n 3- Sair");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							default:System.out.println("Op��o inv�lida!");
									break;
						}
						break;
				case 2: switch (menuRelatorioGerente()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a");
									}
									break;
							case 4: ((Gerente)usuario).relatorioGerente();
									break;
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida.");
						break;
			}	
		}
		while(continuar);
		sc.close();
	}
	
	
	public void menuDiretor(Conta contaUsuario, Usuario usuario) throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println("1- Movimenta��o da conta\n 2- Relat�rios \n 3- Sair");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							default:System.out.println("Op��o inv�lida!");
									break;
						}
						break;
				case 2: switch (menuRelatorioDiretor()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a");
									}
									break;
							case 4: ((Diretor)usuario).relatorioDiretor();
									break;
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida.");
						break;
			}	
		}
		while(continuar);
		sc.close();
	}
	
	public void menuPresidente(Conta contaUsuario, Usuario usuario) throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcao; 
		boolean continuar = true;
		do {
			System.out.println("1- Movimenta��o da conta\n 2- Relat�rios \n 3- Sair");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: switch (menuMovimentacaoConta()) {
							case 1: contaUsuario.processoSaque(contaUsuario,usuario);
									break;
							case 2: contaUsuario.processoDeposito(contaUsuario,usuario);
									break;
							case 3: contaUsuario.processoTransferencia(contaUsuario,usuario);
									break;
							default:System.out.println("Op��o inv�lida!");
									break;
						}
						break;
				case 2: switch (menuRelatorioPresidente()) {
							case 1: contaUsuario.imprimirSaldo();
									break;
							case 2: if(contaUsuario.getTipoConta()==ContaTipoEnum.CORRENTE.getTipo()) {
										((ContaCorrente)contaUsuario).relatorioTributacao();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Corrente");
									}
									break;
					
							case 3: if(contaUsuario.getTipoConta()==ContaTipoEnum.POUPANCA.getTipo()) {
										((ContaPoupanca)contaUsuario).processoSimulacaoRendimento();
									}
									else{	
										System.out.println("A conta n�o � do tipo Conta Poupan�a");
									}
									break;
							case 4: ((Presidente)usuario).relatorioPresidente();
									break;
							case 5:	((Presidente)usuario).relatorioCapitalPresidente();
									break;
						}
						break;
				case 3: continuar = false;
						break;
				default:System.out.println("Op��o inv�lida.");
						break;
			}	
		}
		while(continuar);
		sc.close();
	}
}
