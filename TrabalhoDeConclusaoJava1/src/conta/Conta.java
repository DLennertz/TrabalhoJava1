package conta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leituraEscrita.*;
import enums.ContaTipoEnum;
import enums.UsuarioTipoEnum;
import leitura.Leitura;
import leituraEscrita.LeArquivo;
import pessoal.Cliente;
import pessoal.Diretor;
import pessoal.Usuario;

import java.io.FileNotFoundException;



public abstract class Conta {
		
		protected String tipoConta;
		protected int numConta;
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		protected int numeroDeSaques;
		protected int numeroDeDepositos;
		protected int numeroDeTransferencias;
		static Leitura ler = new Leitura();
		
		public Conta(){     
			numeroDeSaques=0;
		    numeroDeDepositos=0;
		    numeroDeTransferencias=0;
		}
		public Conta(String tipo,int numConta, String cpfTitular, double saldo, int agencia){
			this.cpfTitular=cpfTitular;
			this.saldo=saldo;
			this.agencia=agencia;
			this.numConta=numConta;	
			this.tipoConta=tipo;
			numeroDeSaques=0;
		    numeroDeDepositos=0;
		    numeroDeTransferencias=0;
		}
		
		public void incrementaNumeroDeSaques() {
			numeroDeSaques++;
		}
	    public void incrementaNumeroDeDepositos(){
	    	numeroDeDepositos++;
	    }
	    public void incrementaNumeroDeTransferencias(){
	    	numeroDeTransferencias++;
	    }

		public int getNumConta() {
			return numConta;
		}
		
		public String getTipoConta() {
			return tipoConta;
		}
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return this.cpfTitular;
		}
		
		public boolean deposita(double valor) {
			if(valor > 0.1) {
				this.saldo = this.saldo + valor- 0.10;
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public double getSaldo() {
			return this.saldo;
		}
		
		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}
		
		public int getAgencia() {
			return this.agencia;
		}
		
		public boolean saque(double valor) {
			
				if(saldo>=valor && valor > 0) {
					this.saldo = this.saldo - valor - 0.10;
					return true;
				}
				else if(valor <= 0){	
					System.out.println("Erro. Valor so saque igual a 0 ou negativo");
					return false;
				}
				else {
					System.out.println("Saldo Insuficiente");
					return false;
				}
			
		}
		
		public boolean transfere(Conta destino, double valor) {
			if(valor<=this.saldo && valor > 0) {
				this.saque(valor+0.10);
				destino.deposita(valor+0.1);
			return true;
			}
			else if(valor <= 0) {
				System.out.println("Erro. Transferência com valor 0 ou negativo");
			return false;
			}
			else{
				System.out.println("Saldo insuficiente para realizar a transferência");
			return false;
			}
		}
		
		public void processoSaque(Conta contaUsuario, Usuario usuario) throws IOException {
			double valorSaque;
			
			System.out.println("Insira o valor do saque:");
			valorSaque = ler.lerDouble();
			
			if(this.saldo == 0) {
				System.out.println("Erro. Saldo igual a 0, impossivel realizar saque");
				
				}
			else {
				while(!this.saque(valorSaque)){
					System.out.println("Erro ao fazer o saque. Insira novo valor");
					valorSaque = ler.lerDouble();
				}
			}
			EscreveArquivo.registraSaque(contaUsuario, usuario,valorSaque);
			this.incrementaNumeroDeSaques();
		}
		
		public void processoDeposito(Conta contaUsuario, Usuario usuario) throws IOException {
			double valorDeposito;
		
			System.out.println("Insira o valor do depósito:");
			valorDeposito = ler.lerDouble();
			while(!this.deposita(valorDeposito)) {
				System.out.println("Erro ao realizar depósito. Insira novo valor");
				valorDeposito = ler.lerDouble();
			}
			EscreveArquivo.registraDeposito(contaUsuario, usuario,valorDeposito);
			this.incrementaNumeroDeDepositos();
			
		}
		
		public void processoTransferencia(Conta contaUsuario, Usuario usuario) throws IOException {
			
			double valorTransferencia;
			System.out.println("Insira o número da conta de destino: ");
			
			Conta contaDestino = retornaConta();
	
			while(contaDestino == null) {
				System.out.println("Conta não encontrada. Insira novamente o número da conta");
				contaDestino = retornaConta();
			}
			
			System.out.println("Insira o valor a ser transferido: ");
			valorTransferencia = ler.lerDouble();
		
			this.transfere(contaDestino, valorTransferencia);
			EscreveArquivo.registraTransferencia(contaUsuario, contaDestino, usuario, valorTransferencia);
			this.incrementaNumeroDeTransferencias();
		}

		@Override
		public abstract String toString();
		
		
		
		public void imprimirSaldo() {
			LocalDateTime hoje = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String hojeformatado = hoje.format(formatter);
			System.out.println("########################");
			System.out.println("SALDO");
			System.out.println("########################");
			System.out.println("Data : "+ hojeformatado);
			System.out.println("Conta : "+ getNumConta());
			System.out.println("Agencia: " + getAgencia());
			System.out.println("Saldo : " + getSaldo());
			System.out.println("########################");
		}
		
		public Conta retornaConta() throws IOException {
			int numContaDestino;
			Map<Integer,Conta> contas = new HashMap<>();
			contas = LeArquivo.leArquivoDevolveListaContas();
			numContaDestino = ler.lerInteiro();
			return contas.get(numContaDestino);
		}
		
}
