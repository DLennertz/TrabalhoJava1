package principal;

import conta.*;

public class SistemaInterno {

	public static void main(String[] args) {
		Conta conta1 = new ContaCorrente();
		Conta conta2 = new ContaPoupanca();
		
		System.out.println(Conta.getNumeroDeContas());
	}

}
