package principal;

import conta.*;
import leitura.Leitura;

public class SistemaInterno {
	
	
	
	public static void main(String[] args) {
		Leitura ler = new Leitura();
		String senha, cpf;
		Conta contaOrigem = new ContaCorrente();
		Conta contaDestino = new ContaPoupanca();
		
		System.out.println("Digite seu CPF : ");
		cpf= ler.lerString();
		
		System.out.println("Digite sua senha: ");
		senha= ler.lerString();
		
		switch(contaOrigem.menuCliente()) {
		case 1: contaOrigem.processoSaque();
				break;
		case 2: contaOrigem.processoDeposito();
				break;
		case 3: contaOrigem.processoTransferencia(contaDestino);
				break;
		default: System.out.println("Opção invalida");
        		break;
		}
		
		
		
		
	}
	
	
}


