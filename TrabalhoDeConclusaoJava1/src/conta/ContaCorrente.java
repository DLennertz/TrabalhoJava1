package conta;

import enumerador.ContaEnum;

public class ContaCorrente extends Conta{
		private int tipo;
		
		public ContaCorrente() {
			
		}
		
		public ContaCorrente(String cpfTitular, double saldo, int agencia,int numConta, ContaEnum tipo) {
			super(cpfTitular, saldo, agencia,numConta,tipo);
		}
		
		public int getTipo() {
			return this.tipo;
		}

		@Override
		public String toString() {
			return "ContaCorrente [tipo=" + tipo + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + "]";
		}

		public void getRelatorioTributacao() {
			
		}
		
		
}
