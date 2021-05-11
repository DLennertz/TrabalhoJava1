package conta;

import java.io.IOException;

import bancoDeDados.BancoDados;
import leituraEscritaArquivo.EscreveArquivo;
import pessoal.Usuario;

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

		public void relatorioTributacao(Usuario usuario) throws IOException {
			
			if (usuario.getSeguroVida() == "Contratado") {
				
				System.out.println("##############RELAT�RIO TRIBUTA��O###############");
				System.out.printf("Valor tributado dos saques (R$ 0,10 por saque): R$%.2f" , this.numeroDeSaques * 0.1 );
				System.out.println();
				System.out.printf("Valor tributado dos dep�sitos (R$ 0,10 por dep�sito): R$%.2f" , this.numeroDeDepositos * 0.1 );
				System.out.println();
				System.out.printf("Valor tributado das tranferencias (R$ 0,20 por transferencia): R$%.2f" , this.numeroDeTransferencias * 0.2 );
				System.out.println();
				System.out.printf("Valor assegurado no Seguro de vida R$%.2f" , usuario.getValorSegVida() );
				System.out.println();
				System.out.printf("TOTAL TRIBUTADO: R$%.2f" ,(this.numeroDeSaques * 0.1+ this.numeroDeDepositos * 0.1 + this.numeroDeTransferencias * 0.2 + usuario.getValorSegVida()) );
				System.out.println();
				
			}
			
			else {
				System.out.println("##############RELAT�RIO TRIBUTA��O###############");
				System.out.printf("Valor tributado dos saques (R$ 0,10 por saque): R$%.2f" , this.numeroDeSaques * 0.1 );
				System.out.println();
				System.out.printf("Valor tributado dos dep�sitos (R$ 0,10 por dep�sito): R$%.2f" , this.numeroDeDepositos * 0.1 );
				System.out.println();
				System.out.printf("Valor tributado das tranferencias (R$ 0,20 por transferencia): R$%.2f" , this.numeroDeTransferencias * 0.2 );
				System.out.println();
				System.out.printf("TOTAL TRIBUTADO: R$%.2f" ,(this.numeroDeSaques * 0.1+ this.numeroDeDepositos * 0.1 + this.numeroDeTransferencias * 0.2) );
				System.out.println();
			}
			
			
			EscreveArquivo.registraRelatorioTributacao(BancoDados.mapContas.get(this.numConta), usuario);
			
		}
		
		
}
