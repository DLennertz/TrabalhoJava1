package conta;

import enumerador.ContaEnum;

public class ContaPoupanca extends Conta{
	    private ContaEnum tipoConta;
		
		public ContaPoupanca() {
			this.tipoConta=ContaEnum.ContaPoupanca;
		}
		
		public ContaEnum getTipo(){
			return this.tipoConta;
		}

		@Override
		public String toString() {
			return "ContaPoupanca [tipo=" + tipoConta + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + ", ler=" + ler + "]";
		}
		
		public double simulacaoRendimento(double dias, double investimento){
			return dias * investimento;
		}
		
		
}
