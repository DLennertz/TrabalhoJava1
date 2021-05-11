package leituraEscritaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bancoDeDados.BancoDados;
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
	
	public static void registraSimulacaoRendimento(double valor, int dias, Usuario usuario,double Resultado ) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/SimulacaoRendimento"+usuario.getNome()+usuario.getNumConta()+".txt",true));
		String linha = "SIMULAÇAO DE RENDIMENTO";
		buffWrite.append(linha + "\n");
		
		linha = "Número da Conta: "+ usuario.getNumConta();
		buffWrite.append(linha + "\n");
		
		linha = "Duração da Simulação em Dias: "+ dias;
		buffWrite.append(linha + "\n");
		
		linha = "Valor do Investimento: "+ valor;
		buffWrite.append(linha + "\n");
		
		linha = "Valor Resultante da Simulação: R$" + Resultado;
		buffWrite.append(linha + "\n");
		
		linha = "**********Fim da Simulação**********";
		buffWrite.append(linha + "\n\n");
		
		buffWrite.close();
	}
	
	public static void registraRelatorioTributacao(Conta conta, Usuario usuario) throws IOException {
		
		if (usuario.getSeguroVida() == "Contratado") {
			String linha;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioTributacao"+conta.getNumConta()+".txt",true));
			linha ="##############RELATÓRIO TRIBUTAÇÃO###############";
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos saques (R$ 0,10 por saque): R$" + conta.getNumeroDeSaques() * 0.1;
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos depósiros (R$ 0,10 por depósito): R$" + conta.getNumeroDeDepositos() * 0.1;
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado das tranferencias (R$ 0,20 por transferencia): R$" + conta.getNumerodeTransferencias() * 0.2;
			buffWrite.append(linha + "\n");
			
			linha ="Valor assegurado no Seguro de vida R$" + usuario.getValorSegVida();
			buffWrite.append(linha + "\n");
			
			linha ="TOTAL TRIBUTADO: R$" +(conta.getNumeroDeSaques() * 0.1+ conta.getNumeroDeDepositos() * 0.1 + conta.getNumerodeTransferencias() * 0.2 + usuario.getValorSegVida());
			buffWrite.append(linha + "\n");
			
			buffWrite.close();
		
		}
		
		else {
			String linha;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioTributacao"+conta.getNumConta()+".txt",true));
			linha ="##############RELATÓRIO TRIBUTAÇÃO###############";
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos saques (R$ 0,10 por saque): R$" + conta.getNumeroDeSaques() * 0.1;
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado dos depósiros (R$ 0,10 por depósito): R$" + conta.getNumeroDeDepositos() * 0.1;
			buffWrite.append(linha + "\n");
			
			linha ="Valor tributado das tranferencias (R$ 0,20 por transferencia): R$" + conta.getNumerodeTransferencias() * 0.2;
			buffWrite.append(linha + "\n");
			
			linha ="TOTAL TRIBUTADO: R$" +(conta.getNumeroDeSaques() * 0.1+ conta.getNumeroDeDepositos() * 0.1 + conta.getNumerodeTransferencias() * 0.2);
			buffWrite.append(linha + "\n");
		
			buffWrite.close();
		}
	}
	
	
	public static void registroRelatorioNumeroContas(ArrayList<Conta> lista, int agencia) throws IOException {
		String linha;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date = new Date();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioNumeroContas"+ agencia +sdf.format(date)+".txt"));
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		linha ="##############RELATÓRIO DE CONTAS GERENCIADAS###############";		
		buffWrite.append(linha + "\n");
		
		linha = "Contas pertencentes à agência " + agencia + " em "+ date +": \n";
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
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/Relatoricapitaltotal"+ sdf.format(date)+".txt"));
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		linha =  " ########Capital Total######## ";
		buffWrite.append(linha + "\n");
		linha= "Data e hora da consulta: "+ sdf.format(date);
		buffWrite.append(linha + "\n");
		
		linha = "R$"+ total;
		buffWrite.append(linha + "\n");
		
		buffWrite.close();
	}
	
	public static void registraRelatorioUsuarios(ArrayList<Usuario> lista) throws IOException {
		String linha;
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./temp/RelatorioUsuarios"+ sdf.format(date)+".txt"));
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		linha = "Relatório dos usuários na data: " + sdf.format(date) + "\n";
		buffWrite.append(linha + "\n");
		
		for(Usuario c : lista) {
			linha = "NOME : " + c.getNome() + " "+ c.getSobrenome() +"\nCPF : " + c.getcpfUsuario() + " \nAGÊNCIA : " + (BancoDados.mapContas.get(c.getNumConta())).getAgencia()+"\n###############";
			buffWrite.append(linha + "\n");
		}
		buffWrite.close();
	}
	
}
