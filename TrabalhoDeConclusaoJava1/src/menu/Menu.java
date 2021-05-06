package menu;

import java.util.Scanner;
import enumerador.ContaEnum;
import conta.Conta;
import leitura.Leitura;
import pessoal.Usuario;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Menu {
	public int menuMovimentacaoConta(){
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual opção você deseja: ");
		
		System.out.println("1- Saque");
		System.out.println("2- Depósito");
		System.out.println("3 - Tranferência de conta para conta");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Opção inválida. Escolha uma opção novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public int menuRelatorio() {
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual opção você deseja: ");
		
		System.out.println("1- Saldo");
		System.out.println("2- Relatório de tributação da conta corrente");
		System.out.println("3 - Relatório de Rendimento da poupança");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Opção invalida. Escolha uma opção novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
	
	public void menuCliente(Conta contaUsuario) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean continuar = true;
		while(continuar) {
			System.out.println("1- Movimentação na conta\n2- Relatórios");
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:	switch(menuMovimentacaoConta()) {
					case 1: contaUsuario.processoSaque();
							break;
					case 2: contaUsuario.processoDeposito();
							break;
					case 3: contaUsuario.processoTransferencia();
							break;
					default: System.out.println("Opção invalida");
			        		break;
					}
					break;
			case 2: switch(menuRelatorio()) {
					case 1:contaUsuario.imprimirSaldo();
							break;
					case 2: if(contaUsuario.getTipoConta()==ContaEnum.ContaCorrente) {
								((ContaCorrente)contaUsuario).getRelatorioTributacao();
							}
							else
							{	System.out.println("A conta não é do tipo Conta Corrente");
							}
							break;
					case 3: if(contaUsuario.getTipoConta()==ContaEnum.ContaPoupanca) {
								((ContaPoupanca)contaUsuario).simulacaoRendimento();
							}
							else
							{	System.out.println("A conta não é do tipo Conta Poupança");
							}
							break;
			default: System.out.println("Opção inválida");
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
}
