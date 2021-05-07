package leituraEscrita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import conta.Conta;
import pessoal.Usuario;

public class EscreveArquivo {
		public static void registraDeposito(Conta contaUsuario,Usuario usuario, double valorDeposito) throws IOException {
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt"));
			String linha = "**********Deposito**********";
			buffWrite.append(linha + "\n");
			
			linha = "Agencia: "+contaUsuario.getAgencia();
			buffWrite.append(linha + "\n");
			
			linha = "Conta: "+usuario.getNumConta();
			buffWrite.append(linha + "\n");
			
			linha = "Depósito: R$"+valorDeposito;
			buffWrite.append(linha + "\n");
			
			linha = "**********Fim do Deposito**********";
			buffWrite.append(linha + "\n");
			
			buffWrite.close();
		}
		
public static void registraSaque(Conta contaUsuario,Usuario usuario, double valorSaque) throws IOException {
			
			try {
			//BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt"));
			FileWriter fw = new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
		
			String linha = "**********Saque**********";
			bw.write(linha + "\n");
			
			linha = "Agencia: "+contaUsuario.getAgencia();
			bw.write(linha + "\n");
			
			linha = "Conta: "+usuario.getNumConta();
			bw.write(linha + "\n");
			
			linha = "Saque: R$"+valorSaque;
			bw.write(linha + "\n");
			
			linha = "**********Fim do Deposito**********";
			bw.write(linha + "\n");
		
			bw.close();
			}
			catch(IOException e) {
				System.out.println("Erro de escrita");
			}
		}
		
			

}
