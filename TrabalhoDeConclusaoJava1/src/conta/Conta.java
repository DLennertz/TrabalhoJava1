package conta;

public abstract class Conta {
		
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		private static int numeroDeContas;
		
		public Conta() {
			numeroDeContas++;
		}
		
		public static int getNumeroDeContas(){
			return numeroDeContas;
		}
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return this.cpfTitular;
		}
		
		public void deposita(double valor) {
			this.saldo = this.saldo + valor;
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
		
		public abstract void saque(double valor);
		
		public void transfere(Conta destino, double valor) {
			if(valor<=this.saldo) {
				this.saque(valor);
				destino.deposita(valor);
			}
			else {
				System.out.println("Saldo insuficiente para realizar a transferência");
			}
		}
}
