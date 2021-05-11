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
			
			linha = "Dep�sito: R$"+valorDeposito;
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
		
		linha = "Conta Destinat�ria: "+contaDestino.getNumConta();
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
	
	public static void registraSimulacaoRendimento(double valor, int dias, Usuario usuario,double Resultado ) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/SimulacaoRendimento"+usuario.getNome()+usuario.getNumConta()+".txt",true));
		String linha = "SIMULA�AO DE RENDIMENTO";
		buffWrite.append(linha + "\n");
		
		linha = "N�mero da Conta: "+ usuario.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Dura��o da Simula��o em Dias: "+ dias;
		buffWrite.append(linha + "\n");
		
		linha = "Valor do Investimento: "+ valor;
		buffWrite.append(linha + "\n");
		
		linha = "Valor Resultante da Simula��o: R$" + Resultado;
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim da Simula��o**********";
		buffWrite.append(linha + "\n\n");
		
		buffWrite.close();
	}
	
	public static void registraRelatorioTributacao(Conta conta) throws IOException {
		String linha;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioTributacao"+conta.getNumConta()+".txt",true));
		linha ="##############RELAT�RIO TRIBUTA��O###############";
		buffWrite.append(linha + "\n");
		
		linha ="Valor tributado dos saques (R$ 0,10 por saque): R$" + conta.getNumeroDeSaques() * 0.1;
		buffWrite.append(linha + "\n");
		
		linha ="Valor tributado dos dep�siros (R$ 0,10 por dep�sito): R$" + conta.getNumeroDeDepositos * 0.1;
		buffWrite.append(linha + "\n");
		
		linha ="Valor tributado das tranferencias (R$ 0,20 por transferencia): R$" + conta.getNumerodeTransferencias() * 0.2;
		buffWrite.append(linha + "\n");
		
		linha ="TOTAL TRIBUTADO: R$" +(conta.getNumeroDeSaques() * 0.1+ conta.getNumeroDeDepositos * 0.1 + conta.getNumerodeTransferencias() * 0.2);
		buffWrite.append(linha + "\n");
		
		buffWrite.close();
	}
	
	
}
