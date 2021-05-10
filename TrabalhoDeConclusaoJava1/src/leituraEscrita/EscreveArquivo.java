package leituraEscrita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import conta.Conta;
import pessoal.Usuario;

public class EscreveArquivo {
		public static void registraDeposito(Conta contaUsuario,Usuario usuario, double valorDeposito) throws IOException {
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
			String linha = "**********Deposito**********";
			buffWrite.append(linha + "\n");
			
			linha = "Agencia: "+contaUsuario.getAgencia();
			buffWrite.append(linha + "\n");
			
			linha = "Conta: "+usuario.getNumConta();
			buffWrite.append(linha + "\n");
			
			linha = "Depósito: R$"+valorDeposito;
			buffWrite.append(linha + "\n");
			
			linha = "**********Fim do Deposito**********";
			buffWrite.append(linha + "\n\n");
			
			buffWrite.close();
		}
		
public static void registraSaque(Conta contaUsuario,Usuario usuario, double valorSaque) throws IOException {
			
			try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
			//PrintWriter out = new PrintWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt", true));
		
			String linha = "**********Saque**********";
			buffWrite.append(linha + "\n");
			
			linha = "Agencia: "+contaUsuario.getAgencia();
			buffWrite.append(linha + "\n");
			
			linha = "Conta: "+usuario.getNumConta();
			buffWrite.append(linha + "\n");
			
			linha = "Saque: R$"+valorSaque;
			buffWrite.append(linha + "\n");
			
			linha = "**********Fim do Saque**********";
			buffWrite.append(linha + "\n\n");
		
			buffWrite.close();
			}
			catch(IOException e) {
				System.out.println("Erro de escrita");
			}
		}

	public static void registraTransferencia(Conta contaUsuario,Conta contaDestino,Usuario usuario, double valorTransferencia) throws IOException {
		
		try {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
		//PrintWriter out = new PrintWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt", true));
	
		String linha = "**********Transferencia**********";
		buffWrite.append(linha + "\n");
		
		linha = "Agencia: "+contaUsuario.getAgencia();
		buffWrite.append(linha + "\n");
		
		linha = "Conta Remetente: "+usuario.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Conta Destinatária: "+contaDestino.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Valor Transferido: R$"+valorTransferencia;
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim da Transferencia**********";
		buffWrite.append(linha + "\n\n");
	
		buffWrite.close();
		}
		catch(IOException e) {
			System.out.println("Erro de escrita");
		}
	}	

}
