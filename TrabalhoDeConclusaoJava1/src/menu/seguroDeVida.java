package menu;

import java.util.Scanner;

import conta.Conta;
import exception.ContaException;
import pessoal.Usuario;

public class seguroDeVida {
	
	static Scanner sc = new Scanner (System.in);
	static int esc;
	static double valorSeg;
	static double tributoSeg;
	static boolean cont = false; 
	

	public static void seguroVida (Conta contaUsuario, Usuario usuario) throws ContaException {
		
		
		
		if (usuario.getSeguroVida() == "Contratado") {
			System.out.println("Voc� j� possui esse servi�o contratado.");
		}
		else  {
		
			do {
			
			System.out.println("Deseja contratar o seguro de vida?");
			System.out.println("1- Sim");
			System.out.println("2- N�o");
			esc = sc.nextInt();
			
			switch (esc) {
			
				case 1:
					
					
				
					
					System.out.println("Informe o valor que ser� segurado: R$");
					valorSeg = sc.nextDouble();
					
					tributoSeg = valorSeg * 0.2;
					
						try  {
							contaUsuario.saque(valorSeg - tributoSeg  - 0.10);
							usuario.setValorSegVida(valorSeg);
							
							System.out.println("Servi�o Contratado!");
							usuario.setSeguroVida("Contratado");	
						}
						catch(ContaException e){
							System.out.println(e);
						}
						
					
					
					
					break;
			
				case 2:
					break;
					
				default:
					System.out.println("Escolha inv�lida!");
					break;
			}
			
			} while (esc != 1 && esc != 2);
			
			
	}
		
	}
	
}
