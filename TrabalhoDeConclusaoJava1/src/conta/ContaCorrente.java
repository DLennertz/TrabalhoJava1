package conta;

import enumerador.ContaEnum;

public class ContaCorrente extends Conta{
		private ContaEnum tipoConta;
		
		public ContaCorrente() {
			
		}
		
		public ContaCorrente(String cpfTitular, double saldo, int agencia,int numConta, ContaEnum tipo) {
			super(cpfTitular, saldo, agencia,numConta);
			this.tipoConta=tipo;
		}
		
		public ContaEnum getTipo() {
			return this.tipoConta;
		}

		@Override
		public String toString() {
			return "ContaCorrente [tipo=" + tipoConta + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + "]";
		}

		public void getRelatorioTributacao() {
			
		}
		
		
}
