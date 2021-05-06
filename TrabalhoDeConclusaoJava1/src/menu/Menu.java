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
	
	public int menuRelatorio() {
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
	
	public void menuCliente(Conta contaUsuario) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean continuar = true;
		while(continuar) {
			System.out.println("1- Movimenta��o na conta\n2- Relat�rios");
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:	switch(menuMovimentacaoConta()) {
					case 1: contaUsuario.processoSaque();
							break;
					case 2: contaUsuario.processoDeposito();
							break;
					case 3: contaUsuario.processoTransferencia();
							break;
					default: System.out.println("Op��o invalida");
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
							{	System.out.println("A conta n�o � do tipo Conta Corrente");
							}
							break;
					case 3: if(contaUsuario.getTipoConta()==ContaEnum.ContaPoupanca) {
								((ContaPoupanca)contaUsuario).simulacaoRendimento();
							}
							else
							{	System.out.println("A conta n�o � do tipo Conta Poupan�a");
							}
							break;
			default: System.out.println("Op��o inv�lida");
			 		break;
			}
			System.out.println(contaUsuario);
			System.out.println("Deseja realizar nova opera��o? 1-sim 2-n�o");
			opcao = sc.nextInt();
			
			while(opcao != 1 && opcao !=2) {
				System.out.println("Op��o invalida. insira nova op��o");
				opcao = sc.nextInt();
			}
			if(opcao == 2) {
				continuar = false; 
			}
		}
	
	}
}
}
