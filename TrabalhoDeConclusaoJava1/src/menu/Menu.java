package menu;

import java.util.Scanner;

import conta.Conta;
import leitura.Leitura;
import pessoal.Usuario;

public class Menu {
	public int menuMovimentacaoConta(){
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual op��o voc� deseja: ");
		
		System.out.println("1- Saque");
		System.out.println("2- Deposito");
		System.out.println("3 - Tranferencia de conta para conta");
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
			switch(menuMovimentacaoConta()) {
			case 1: contaUsuario.processoSaque();
					break;
			case 2: contaUsuario.processoDeposito();
					break;
			case 3: contaUsuario.processoTransferencia();
					break;
			default: System.out.println("Op��o invalida");
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
