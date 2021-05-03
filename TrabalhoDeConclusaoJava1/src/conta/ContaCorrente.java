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
		public void saque(double valor) {
			this.saldo = this.saldo - valor;
			
		}
		
		
}
