package principal;

import conta.*;
import java.util.Scanner;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		
		String senha, cpf;
		Conta contaOrigem = new ContaCorrente();
		
		System.out.println("Digite seu CPF : ");
		cpf= lerString();
		
		System.out.println("Digite sua senha: ");
		senha= lerString();
		
		switch(menuCliente()) {
		case 1: processoSaque(contaOrigem);
				break;
		case 2: processoDeposito(contaOrigem);
				break;
		case 3: processoTransferencia(contaOrigem);
				break;
		default: System.out.println("Opção invalida");
        		break;
		}
		
		
		
		
	}
	static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.next();
	}
	
	static int lerInteiro() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}
	
	static double lerDouble() {
		Scanner ler = new Scanner(System.in);
		return ler.nextDouble();
	}
	
	static int menuCliente(){
		int opcao;
		System.out.println("Escolha qual opção você deseja: ");
		
		System.out.println("1- Saque");
		System.out.println("2- Deposito");
		System.out.println("3 - Tranferencia de conta para conta");
		opcao = lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Opção invalida. Escolha uma opção novamente");
			opcao = lerInteiro();
		}
		return opcao;
	}
	
	static void processoSaque(Conta original) {
		double valorSaque;
		
		System.out.println("Insira o valor do saque:");
		valorSaque = lerDouble();
		original.saque(valorSaque);
		
	}
	
	static void processoDeposito(Conta original) {
		double valorDeposito;
	
		System.out.println("Insira o valor do saque:");
		valorDeposito = lerDouble();
		original.saque(valorDeposito);
	}
	
	static void processoTransferencia(Conta Original) {
		int numContaDestino;
		double valorTransferencia;
		System.out.println("Insira o número da conta de destino: ");
		numContaDestino = lerInteiro();
		
		System.out.println("Insira o valor a ser transferido: ");
		valorTransferencia = lerDouble();
		
		Original.transfere(contaDestino, valorTransferencia);
	}
}


