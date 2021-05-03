package conta;

public class Conta {
		
		private String cpfTitular;
		private double saldo;
		private int agencia;
		private static int numeroDeContas;
		
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return cpfTitular;
		}
		
		public void deposita(double valor) {
			this.saldo = this.saldo + valor;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}
		
		public int getAgencia() {
			return agencia;
		}
		
		public void saque(double valor) {
			this.saldo = this.saldo - valor;
		}
		
		public void tranfere(Conta destino, double valor) {
			if(valor<=this.saldo) {
				this.saque(valor);
				destino.deposita(valor);
			}
			else {
				System.out.println("Saldo insuficiente para realizar a transferência");
			}
		}
}
