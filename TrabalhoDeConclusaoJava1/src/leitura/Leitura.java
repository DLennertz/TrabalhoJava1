package leitura;

import java.util.Scanner;

public class Leitura {
	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		String x =ler.next();
		//ler.close();
		return x;
	}
	
	public int lerInteiro() {
		Scanner ler = new Scanner(System.in);
		Integer x = ler.nextInt();
		//ler.close();
		return x;
	}
	
	public double lerDouble() {
		Scanner ler = new Scanner(System.in);
		double x =ler.nextDouble();
		//ler.close();
		return x;
	}
}
