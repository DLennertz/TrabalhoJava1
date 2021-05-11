package menu;

import java.util.Scanner;

import conta.Conta;
import enums.ContaTipoEnum;
import pessoal.Usuario;

public class seguroDeVida {
	
	static Scanner sc = new Scanner (System.in);
	static int esc;
	static double valorSeg;
	static double tributoSeg;
	static boolean cont = false; 
	

	public static void seguroVida (Conta contaUsuario, Usuario usuario) {
		
		
		if (contaUsuario.getTipoConta().equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
			
			System.out.println(contaUsuario.getTipoConta() + " nao e aceitavel para esse servico");
		}
		else if (usuario.getSeguroVida() == "Contratado") {
			System.out.println("Voce ja possue esse servico contratado");
		}
		else  {
		
			do {
			
			System.out.println("Desejar contratar o Seguro de vida?");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			esc = sc.nextInt();
			
			switch (esc) {
			
				case 1:
					
					
					do {
					
					System.out.println("Informe o valor que sera segurado: R$");
					valorSeg = sc.nextDouble();
					
					tributoSeg = valorSeg * 0.2;
					
						if (contaUsuario.saque(valorSeg - tributoSeg  - 0.10 )) {
							
							usuario.setValorSegVida(valorSeg);
							cont = true;
							
							System.out.println("Servico Contratado");
							usuario.setSeguroVida("Contratado");
							
						}
						
					} while (cont == false);
					
					
					break;
			
				case 2:
					break;
					
				default:
					System.out.println("Escolha invalida");
					break;
			}
			
			} while (esc != 1 && esc != 2);
			
			
	}
		
	}
	
}
