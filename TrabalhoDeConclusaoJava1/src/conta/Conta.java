package conta;

import leitura.Leitura;



public abstract class Conta {
		
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		protected int numConta;
		private static int numeroDeContas = 0;
		Leitura ler = new Leitura();
		
		public Conta() {
			numConta = numeroDeContas;
			numeroDeContas++;
		}
		
		public static int getNumeroDeContas(){
			return numeroDeContas;
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
		
			System.out.println("Insira o valor do saque:");
			valorDeposito = ler.lerDouble();
			while(!this.saque(valorDeposito)) {
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
}
