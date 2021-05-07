package conta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.ContaTipoEnum;
import enums.UsuarioTipoEnum;
import leitura.Leitura;
import pessoal.Cliente;
import pessoal.Diretor;
import java.io.FileNotFoundException;



public abstract class Conta {
		
		protected String tipoConta;
		protected int numConta;
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		
		Leitura ler = new Leitura();
		
		public Conta(){
		}
		
		public Conta(String tipo,int numConta, String cpfTitular, double saldo, int agencia){
			this.cpfTitular=cpfTitular;
			this.saldo=saldo;
			this.agencia=agencia;
			this.numConta=numConta;	
			this.tipoConta=tipo;
		}

		public int getNumConta() {
			return numConta;
		}
		
		public String getTipoConta() {
			return tipoConta;
		}
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return this.cpfTitular;
		}
		
		public boolean deposita(double valor) {
			if(valor > 0) {
				this.saldo = this.saldo + valor;
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public double getSaldo() {
			return this.saldo;
		}
		
		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}
		
		public int getAgencia() {
			return this.agencia;
		}
		
		public boolean saque(double valor) {
			
				if(saldo>=valor && valor > 0) {
					this.saldo = this.saldo - valor;
					return true;
				}
				else if(valor <= 0){	
					System.out.println("Erro. Valor so saque igual a 0 ou negativo");
					return false;
				}
				else {
					System.out.println("Saldo Insuficiente");
					return false;
				}
			
		}
		
		public boolean transfere(Conta destino, double valor) {
			if(valor<=this.saldo && valor > 0) {
				this.saque(valor);
				destino.deposita(valor);
			return true;
			}
			else if(valor <= 0) {
				System.out.println("Erro. Transferência com valor 0 ou negativo");
			return false;
			}
			else{
				System.out.println("Saldo insuficiente para realizar a transferência");
			return false;
			}
		}
		
		public void processoSaque() {
			double valorSaque;
			
			System.out.println("Insira o valor do saque:");
			valorSaque = ler.lerDouble();
			
			if(this.saldo == 0) {
				System.out.println("Erro. Saldo igual a 0, impossivel realizar saque");
				
				}
			else {
				while(!this.saque(valorSaque)){
					System.out.println("Erro ao fazer o saque. Insira novo valor");
					valorSaque = ler.lerDouble();
				}
			}
		}
		
		public void processoDeposito() {
			double valorDeposito;
		
			System.out.println("Insira o valor do depósito:");
			valorDeposito = ler.lerDouble();
			while(!this.deposita(valorDeposito)) {
				System.out.println("Erro ao realizar depósito. Insira novo valor");
				valorDeposito = ler.lerDouble();
			}
		}
		
		public void processoTransferencia() throws IOException {
			
			double valorTransferencia;
			System.out.println("Insira o número da conta de destino: ");
			
			Conta contaDestino = retornaConta();
	
			while(contaDestino == null) {
				System.out.println("Conta não encontrada. Insira novamente o número da conta");
				contaDestino = retornaConta();
			}
			
			System.out.println("Insira o valor a ser transferido: ");
			valorTransferencia = ler.lerDouble();
		
			this.transfere(contaDestino, valorTransferencia);
			System.out.println(contaDestino);
		}

		@Override
		public abstract String toString();
		
		public static Map<Integer, Conta> getContas() throws IOException{
			Map<Integer, Conta> contas = new HashMap<>();
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
				String linha = "";
				
				while (true) {
					linha = buffRead.readLine();
					if (linha != null) {
						String[] pp = linha.split(";");
						if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
							ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
							contas.put(Integer.parseInt(pp[1]), cc);
						}
						else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
							ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
							contas.put(Integer.parseInt(pp[1]), cp);
						}
						
					} else
						break;
				}
				buffRead.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
			}

			return contas;
		}
		
		public void imprimirSaldo() {
			LocalDateTime hoje = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String hojeformatado = hoje.format(formatter);
			System.out.println("########################");
			System.out.println("SALDO");
			System.out.println("########################");
			System.out.println("Data : "+ hojeformatado);
			System.out.println("Conta : "+ getNumConta());
			System.out.println("Agencia: " + getAgencia());
			System.out.println("Saldo : " + getSaldo());
			System.out.println("########################");
		}
		
		public Conta retornaConta() throws IOException {
			int numContaDestino;
			Map<Integer,Conta> contas = new HashMap<>();
			contas = getContas();
			numContaDestino = ler.lerInteiro();
			return contas.get(numContaDestino);
		}
		
}
