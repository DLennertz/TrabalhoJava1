package menu;

import leitura.Leitura;

public class Menu {
	public int menuCliente(){
		int opcao;
		Leitura ler = new Leitura();
		System.out.println("Escolha qual opção você deseja: ");
		
		System.out.println("1- Saque");
		System.out.println("2- Deposito");
		System.out.println("3 - Tranferencia de conta para conta");
		opcao = ler.lerInteiro();
		while(opcao < 1 || opcao > 3) {
			System.out.println("Opção invalida. Escolha uma opção novamente");
			opcao = ler.lerInteiro();
		}
		return opcao;
	}
}
