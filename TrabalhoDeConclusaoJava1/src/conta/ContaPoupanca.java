package conta;

import java.util.Scanner;

import enumerador.ContaEnum;

public class ContaPoupanca extends Conta{
	    //private ContaEnum tipoConta;
		
	public ContaPoupanca() {
		
	}
		public ContaPoupanca(String cpfTitular, double saldo, int agencia,int numConta, ContaEnum tipo) {
			super(cpfTitular, saldo, agencia,numConta, tipo);
		}
		
		public ContaEnum getTipo(){
			return this.tipoConta;
		}

		@Override
		public String toString() {
			return "ContaPoupanca [tipo=" + tipoConta + ", cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", agencia="
					+ agencia + ", numConta=" + numConta + ", ler=" + ler + "]";
		}
		
		public double simulacaoRendimento(int dias, double valor){
			return valor*Math.pow((1+0.01),dias);
		}
		
		public void processoSimulacaoRendimento() {
			Scanner sc = new Scanner(System.in);
			System.out.println("SIMULAÇÃO RENDIMENTO");
			System.out.println("##########################");
			System.out.println("Insira a quantidade de dias de aplicação: ");
			int dias = sc.nextInt();
			System.out.println("Insira o valor da aplicação: ");
			double valor = sc.nextDouble();
			
			System.out.println("Rendimento simulado = " + simulacaoRendimento(dias,valor));
		}
		
		
}
