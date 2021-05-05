package conta;

public class ContaCorrente extends Conta{
		private int tipo;
		
		public ContaCorrente() {
			
		}
		
		public ContaCorrente(String cpfTitular, double saldo, int agencia,int numConta) {
			super(cpfTitular, saldo, agencia,numConta);
		}
		
		public int getTipo() {
			return this.tipo;
		}

		@Override
		public String toString() {
			return "ContaCorrente [tipo=" + tipo + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + ", ler=" + ler + "]";
		}

		
		
		
}
