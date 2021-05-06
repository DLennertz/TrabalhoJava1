package conta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enumerador.ContaEnum;
import leitura.Leitura;



public abstract class Conta {
		
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		protected int numConta;
		protected ContaEnum tipoConta;
		Leitura ler = new Leitura();
		
		public Conta(){
		}
		
		public Conta(String cpfTitular, double saldo, int agencia,int numConta,ContaEnum tipo){
			this.cpfTitular=cpfTitular;
			this.saldo=saldo;
			this.agencia=agencia;
			this.numConta=numConta;	
			this.tipoConta=tipo;
		}

		public int getNumConta() {
			return numConta;
		}
		
		public ContaEnum getTipoConta() {
			return tipoConta;
		}
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return this.cpfTitular;
		}
		
		public boolean deposita(double valor) {
			if(valor > 0) {
				this.saldo = this.saldo + valor;
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
					this.saldo = this.saldo - valor;
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
				this.saque(valor);
				destino.deposita(valor);
			return true;
			}
			else if(valor <= 0) {
				System.out.println("Erro. Transfer�ncia com valor 0 ou negativo");
			return false;
			}
			else{
				System.out.println("Saldo insuficiente para realizar a transfer�ncia");
			return false;
			}
		}
		
		public void processoSaque() {
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
		}
		
		public void processoDeposito() {
			double valorDeposito;
		
			System.out.println("Insira o valor do dep�sito:");
			valorDeposito = ler.lerDouble();
			while(!this.deposita(valorDeposito)) {
				System.out.println("Erro ao realizar dep�sito. Insira novo valor");
				valorDeposito = ler.lerDouble();
			}
		}
		
		public void processoTransferencia() {
			
			double valorTransferencia;
			System.out.println("Insira o n�mero da conta de destino: ");
			
			Conta contaDestino = retornaConta();
	
			while(contaDestino == null) {
				System.out.println("Conta n�o encontrada. Insira novamente o n�mero da conta");
				contaDestino = retornaConta();
			}
			
			System.out.println("Insira o valor a ser transferido: ");
			valorTransferencia = ler.lerDouble();
		
			this.transfere(contaDestino, valorTransferencia);
			System.out.println(contaDestino);
		}

		@Override
		public abstract String toString();
		
		public static Map<Integer, Conta> getContas(){
			Map<Integer, Conta> contas = new HashMap<>();
			contas.put(678,new ContaCorrente("265",55000,400,678,ContaEnum.ContaCorrente));
			contas.put(53,new ContaCorrente("976",6000,200,53,ContaEnum.ContaCorrente));
			contas.put(78,new ContaCorrente("9465",4000,500,78,ContaEnum.ContaCorrente));
			contas.put(60,new ContaCorrente("5556",15500,200,60,ContaEnum.ContaCorrente));
			contas.put(1,new ContaCorrente("333",4500,310,1,ContaEnum.ContaCorrente));
			contas.put(10,new ContaCorrente("64",5500,400,10,ContaEnum.ContaCorrente));
			contas.put(8,new ContaCorrente("112",6000,200,8,ContaEnum.ContaCorrente));
			contas.put(15,new ContaCorrente("5",4000,500,15,ContaEnum.ContaCorrente));
			contas.put(19,new ContaCorrente("45",15500,200,19,ContaEnum.ContaCorrente));
			contas.put(5,new ContaCorrente("94",4500,310,5,ContaEnum.ContaCorrente));
			contas.put(11,new ContaCorrente("23",500,100,11,ContaEnum.ContaCorrente));
			contas.put(12,new ContaCorrente("4",4400,600,12,ContaEnum.ContaCorrente));
			contas.put(13,new ContaCorrente("92",1100,510,13,ContaEnum.ContaCorrente));
			
			return contas;
		}
		
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
		
		public Conta retornaConta() {
			int numContaDestino;
			Map<Integer,Conta> contas = new HashMap<>();
			contas = getContas();
			numContaDestino = ler.lerInteiro();
			return contas.get(numContaDestino);
		}
		
}
