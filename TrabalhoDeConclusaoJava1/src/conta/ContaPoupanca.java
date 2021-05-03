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
		public void saque(double valor) {
			this.saldo = this.saldo - valor;
			
		}
}
