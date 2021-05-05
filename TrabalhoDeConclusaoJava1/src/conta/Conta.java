package conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leitura.Leitura;



public abstract class Conta {
		
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		protected int numConta;
		Leitura ler = new Leitura();
		
		public Conta(){
		}
		
		public Conta(String cpfTitular, double saldo, int agencia,int numConta){
			this.cpfTitular=cpfTitular;
			this.saldo=saldo;
			this.agencia=agencia;
			this.numConta=numConta;	
		}

		public int getNumConta() {
			return numConta;
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
				System.out.println("Erro. Transferência com valor 0 ou negativo");
			return false;
			}
			else{
				System.out.println("Saldo insuficiente para realizar a transferência");
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
		
			System.out.println("Insira o valor do depósito:");
			valorDeposito = ler.lerDouble();
			while(!this.deposita(valorDeposito)) {
				System.out.println("Erro ao realizar depósito. Insira novo valor");
				valorDeposito = ler.lerDouble();
			}
		}
		
		public void processoTransferencia() {
			int numContaDestino;
			double valorTransferencia;
			System.out.println("Insira o número da conta de destino: ");
			numContaDestino = ler.lerInteiro();
			
			Conta contaDestino = new ContaPoupanca();
			
			System.out.println("Insira o valor a ser transferido: ");
			valorTransferencia = ler.lerDouble();
		
			this.transfere(contaDestino, valorTransferencia);
		}

		@Override
		public abstract String toString();
		
		public static Map<String, Conta> getContas(){
			Map<String, Conta> contas = new HashMap<>();
			contas.put("64",new ContaCorrente("64",5500,400,10));
			contas.put("112",new ContaCorrente("112",6000,200,8));
			contas.put("5",new ContaCorrente("5",4000,500,15));
			contas.put("45",new ContaCorrente("45",15500,200,19));
			contas.put("94",new ContaCorrente("94",4500,310,5));
			contas.put("23",new ContaCorrente("23",500,100,11));
			contas.put("4",new ContaCorrente("4",4400,600,12));
			contas.put("92",new ContaCorrente("92",1100,510,13));
			
			return contas;
		}
		
		public void imprimirSaldo() {
			System.out.println("########################");
			System.out.println("Conta : "+ getNumConta());
			System.out.println("Saldo : " + getSaldo());
			System.out.println("########################");
		}
}
