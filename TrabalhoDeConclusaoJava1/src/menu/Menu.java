package menu;

import leitura.Leitura;

public class Menu {
	public int menuCliente(){
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
}
