package leituraEscritaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bancoDeDados.BancoDados;
import conta.Conta;
import pessoal.Usuario;

public class EscreveArquivo {
		public static void registraDeposito(Conta contaUsuario,Usuario usuario, double valorDeposito) throws IOException {
			
			DecimalFormat formatador = new DecimalFormat("0.00");
			
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
			String linha = "**********Dep�sito**********";
			buffWrite.append(linha + "\n");
			
			linha = "Ag�ncia: " + contaUsuario.getAgencia();
			buffWrite.append(linha + "\n");
			
			linha = "Conta: " + usuario.getNumConta();
			buffWrite.append(linha + "\n");
			
			linha = "Dep�sito: R$ " + formatador.format(valorDeposito);
			buffWrite.append(linha + "\n");
			
			linha = "**********Fim do Dep�sito**********";
			buffWrite.append(linha + "\n\n");
			
			buffWrite.close();
		}
		
		public static void registraSaque(Conta contaUsuario,Usuario usuario, double valorSaque) throws IOException {
			
			DecimalFormat formatador = new DecimalFormat("0.00");
			
			try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
			//PrintWriter out = new PrintWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt", true));
		
			String linha = "**********Saque**********";
			buffWrite.append(linha + "\n");
			
			linha = "Ag�ncia: " + contaUsuario.getAgencia();
			buffWrite.append(linha + "\n");
			
			linha = "Conta: " + usuario.getNumConta();
			buffWrite.append(linha + "\n");
			
			linha = "Saque: R$ " + formatador.format(valorSaque);
			buffWrite.append(linha + "\n");
			
			linha = "**********Fim do Saque**********";
			buffWrite.append(linha + "\n\n");
		
			buffWrite.close();
			}
			catch(IOException e) {
				System.out.println("Erro de escrita!");
			}
		}

	public static void registraTransferencia(Conta contaUsuario,Conta contaDestino,Usuario usuario, double valorTransferencia) throws IOException {
		
		DecimalFormat formatador = new DecimalFormat("0.00");
		
		try {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt",true));
		//PrintWriter out = new PrintWriter(new FileWriter("./temp/"+usuario.getNome()+usuario.getNumConta()+".txt", true));
	
		String linha = "**********Transfer�ncia**********";
		buffWrite.append(linha + "\n");
		
		linha = "Ag�ncia: " + contaUsuario.getAgencia();
		buffWrite.append(linha + "\n");
		
		linha = "Conta Remetente: " + usuario.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Conta Destinat�ria: " + contaDestino.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Valor Transferido: R$ " + formatador.format(valorTransferencia);
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim da Transfer�ncia**********";
		buffWrite.append(linha + "\n\n");
	
		buffWrite.close();
		}
		catch(IOException e) {
			System.out.println("Erro de escrita! ");
		}
	}	
	
	public static void registraSimulacaoRendimento(double valor, int dias, Usuario usuario,double Resultado ) throws IOException {
		
		DecimalFormat formatador = new DecimalFormat("0.00");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/SimulacaoRendimento"+usuario.getNome()+usuario.getNumConta()+".txt",true));
		String linha = "SIMULA��O DE RENDIMENTO";
		buffWrite.append(linha + "\n");
		
		linha = "N�mero da Conta: " + usuario.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Dura��o da Simula��o em Dias: " + dias;
		buffWrite.append(linha + "\n");
		
		linha = "Valor do Investimento: R$ " + formatador.format(valor);
		buffWrite.append(linha + "\n");
		
		linha = "Valor Resultante da Simula��o: R$ " + formatador.format(Resultado);
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim da Simula��o**********";
		buffWrite.append(linha + "\n\n");
		
		buffWrite.close();
	}
	
	public static void registraRelatorioTributacao(Conta conta, Usuario usuario) throws IOException {
		
		DecimalFormat formatador = new DecimalFormat("0.00");
		
		if (usuario.getSeguroVida() == "Contratado") {
			String linha;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioTributacao"+conta.getNumConta()+".txt",true));
			linha ="##############RELAT�RIO TRIBUTA��O###############";
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos saques (R$ 0,10 por saque): R$ " + formatador.format(conta.getNumeroDeSaques() * 0.1);
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos dep�siros (R$ 0,10 por dep�sito): R$ " + formatador.format(conta.getNumeroDeDepositos() * 0.1);
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado das tranfer�ncias (R$ 0,20 por transfer�ncia): R$ " + formatador.format(conta.getNumerodeTransferencias() * 0.2);
			buffWrite.append(linha + "\n");
			
			linha ="Valor assegurado no Seguro de vida: R$ " + formatador.format(usuario.getValorSegVida());
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado do seguro (20 por cento do valor assegurado): R$ " + formatador.format(usuario.getValorSegVida() * 0.2);
			buffWrite.append(linha + "\n");
			
			linha ="TOTAL TRIBUTADO: R$ " + formatador.format((conta.getNumeroDeSaques() * 0.1 + conta.getNumeroDeDepositos() * 0.1 + conta.getNumerodeTransferencias() * 0.2 + usuario.getValorSegVida() * 0.2));
			buffWrite.append(linha + "\n");
			
			buffWrite.close();
		
		}
		
		else {
			String linha;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioTributacao"+conta.getNumConta()+".txt",true));
			linha ="##############RELAT�RIO TRIBUTA��O###############";
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos saques (R$ 0,10 por saque): R$ " + formatador.format(conta.getNumeroDeSaques() * 0.1);
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos dep�siros (R$ 0,10 por dep�sito): R$ " + formatador.format(conta.getNumeroDeDepositos() * 0.1);
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado das tranfer�ncias (R$ 0,20 por transfer�ncia): R$ " + formatador.format(conta.getNumerodeTransferencias() * 0.2);
			buffWrite.append(linha + "\n");
			
			linha ="TOTAL TRIBUTADO: R$ " + formatador.format((conta.getNumeroDeSaques() * 0.1 + conta.getNumeroDeDepositos() * 0.1 + conta.getNumerodeTransferencias() * 0.2));
			buffWrite.append(linha + "\n");
		
			buffWrite.close();
		}
	}
	
	
	public static void registroRelatorioNumeroContas(ArrayList<Conta> lista, int agencia) throws IOException {
		String linha;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date = new Date();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioNumeroContas" + agencia + sdf.format(date) + ".txt"));
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		linha ="##############RELAT�RIO DE CONTAS GERENCIADAS###############";		
		buffWrite.append(linha + "\n");
		
		linha = "Contas pertencentes � ag�ncia " + agencia + " em " + date + ": \n";
		buffWrite.append(linha);
		
		for(Conta c : lista) {
			linha = c.getNumConta() + " / ";
			buffWrite.append(linha);
		}
		
		buffWrite.close();
		
	}
	
	public static void registroCapitalTotal(double total) throws IOException {
		String linha;
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date = new Date();
		DecimalFormat formatador = new DecimalFormat("0.00");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/Relatoricapitaltotal" + sdf.format(date) + ".txt"));
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		linha = " ########Capital Total######## ";
		buffWrite.append(linha + "\n");
		linha= "Data e hora da consulta: " + sdf.format(date);
		buffWrite.append(linha + "\n");
		
		linha = "R$ " + formatador.format(total);
		buffWrite.append(linha + "\n");
		
		buffWrite.close();
	}
	
	public static void registraRelatorioUsuarios(ArrayList<Usuario> lista) throws IOException {
		String linha;
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioUsuarios"+ sdf.format(date)+".txt"));
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		linha = "Relat�rio dos usu�rios na data: " + sdf.format(date) + "\n";
		buffWrite.append(linha + "\n");
		
		for(Usuario c : lista) {
			linha = "NOME: " + c.getNome() + " "+ c.getSobrenome() +"\nCPF: " + c.getcpfUsuario() + " \nAG�NCIA: " + (BancoDados.mapContas.get(c.getNumConta())).getAgencia()+"\n###############";
			buffWrite.append(linha + "\n");
		}
		buffWrite.close();
	}
	
}
