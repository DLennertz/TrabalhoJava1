package conta;

import java.io.IOException;

import bancoDeDados.BancoDados;
import leituraEscritaArquivo.EscreveArquivo;

public class ContaCorrente extends Conta{
		//private ContaEnum tipoConta;
		
		public ContaCorrente() {
			
		}
		
		public ContaCorrente(String tipo,int numConta,String cpfTitular, double saldo, int agencia) {
			super(tipo,numConta,cpfTitular, saldo, agencia);
		}
		
		public String getTipo() {
			return this.tipoConta;
		}

		@Override
		public String toString() {
			return "ContaCorrente [tipo=" + tipoConta + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + "]";
		}

		public void relatorioTributacao() throws IOException {
			System.out.println("##############RELATÓRIO TRIBUTAÇÃO###############");
			System.out.println("Valor tributado dos saques (R$ 0,10 por saque): R$" + this.numeroDeSaques * 0.1);
			System.out.println("Valor tributado dos depósiros (R$ 0,10 por depósito): R$" + this.numeroDeDepositos * 0.1);
			System.out.println("Valor tributado das tranferencias (R$ 0,20 por transferencia): R$" + this.numeroDeTransferencias * 0.2);
			System.out.println("TOTAL TRIBUTADO: R$" +(this.numeroDeSaques * 0.1+ this.numeroDeDepositos * 0.1 + this.numeroDeTransferencias * 0.2));
			
			EscreveArquivo.registraRelatorioTributacao(BancoDados.mapContas.get(this.numConta));
		}
		
		
}
