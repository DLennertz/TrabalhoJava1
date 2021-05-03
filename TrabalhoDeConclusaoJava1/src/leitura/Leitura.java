package leitura;

import java.util.Scanner;

public class Leitura {
	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.next();
	}
	
	public int lerInteiro() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}
	
	public double lerDouble() {
		Scanner ler = new Scanner(System.in);
		return ler.nextDouble();
	}
}
