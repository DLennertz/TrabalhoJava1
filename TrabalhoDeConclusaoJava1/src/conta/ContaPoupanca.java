package conta;

public class ContaPoupanca extends Conta{
		private int tipo;
		
		public ContaPoupanca() {
			this.tipo=1;
		}
		
		public int getTipo(){
			return this.tipo;
		}

		@Override
		public String toString() {
			return "ContaPoupanca [tipo=" + tipo + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + ", ler=" + ler + "]";
		}
		
		public void simulacaoRendimento(){
			
		}
		
		
}
