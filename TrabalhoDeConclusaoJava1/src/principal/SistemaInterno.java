package principal;

import conta.*;
import leitura.Leitura;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		Leitura ler = new Leitura();
		String senha, cpf;
		int opcao;
		boolean continuar = true;
		Conta contaOrigem = new ContaCorrente();
		Conta contaDestino = new ContaPoupanca();
		
		System.out.println("Digite seu CPF : ");
		cpf= ler.lerString();
		
		System.out.println("Digite sua senha: ");
		senha= ler.lerString();
		
		while(continuar) {
			switch(contaOrigem.menuCliente()) {
			case 1: contaOrigem.processoSaque();
					break;
			case 2: contaOrigem.processoDeposito();
					break;
			case 3: contaOrigem.processoTransferencia();
					break;
			default: System.out.println("Op��o invalida");
	        		break;
			}
			
			System.out.println("Deseja realizar nova opera��o? 1-sim 2-n�o");
			opcao = ler.lerInteiro();
			
			while(opcao != 1 && opcao !=2) {
				System.out.println("Op��o invalida. insira nova op��o");
				opcao = ler.lerInteiro();
			}
			if(opcao == 2) {
				continuar = false; 
			}
		}
		
		
		
	}
	
	
}


