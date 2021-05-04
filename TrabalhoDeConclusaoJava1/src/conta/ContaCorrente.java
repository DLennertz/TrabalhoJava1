package conta;

public class ContaCorrente extends Conta{
		private int tipo;
		
		public ContaCorrente() {
			this.tipo=2;
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
