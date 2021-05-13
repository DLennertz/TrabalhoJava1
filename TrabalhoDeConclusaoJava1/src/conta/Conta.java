package conta;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import bancoDeDados.BancoDados;
import exception.ContaException;
import leitura.Leitura;
import leituraEscritaArquivo.*;
import pessoal.Usuario;



public abstract class Conta {
		
		protected String tipoConta;
		protected int numConta;
		protected String cpfTitular;
		protected double saldo;
		protected int agencia;
		protected int numeroDeSaques;
		protected int numeroDeDepositos;
		protected int numeroDeTransferencias;
		static Leitura ler = new Leitura();
		
		public Conta(){     
			numeroDeSaques=0;
		    numeroDeDepositos=0;
		    numeroDeTransferencias=0;
		}
		public Conta(String tipo,int numConta, String cpfTitular, double saldo, int agencia){
			this.cpfTitular=cpfTitular;
			this.saldo=saldo;
			this.agencia=agencia;
			this.numConta=numConta;	
			this.tipoConta=tipo;
			numeroDeSaques=0;
		    numeroDeDepositos=0;
		    numeroDeTransferencias=0;
		}
		
		public void incrementaNumeroDeSaques() {
			numeroDeSaques++;
		}
	    public void incrementaNumeroDeDepositos(){
	    	numeroDeDepositos++;
	    }
	    public void incrementaNumeroDeTransferencias(){
	    	numeroDeTransferencias++;
	    }
	    
	    public int getNumerodeTransferencias() {
	    	return numeroDeTransferencias;
	    }
	    
	    public int getNumeroDeSaques() {
	    	return numeroDeSaques;
	    }
	    
	    public int getNumeroDeDepositos () {
	    	return numeroDeDepositos;
	    }

		public int getNumConta() {
			return numConta;
		}
		
		public void setNumConta(int numConta) {
			this.numConta=numConta;
		}
		
		public String getTipoConta() {
			return tipoConta;
		}
		
		public void setTipoConta(String tipoConta) {
			this.tipoConta=tipoConta;
		}
		
		public void setCPFTitular(String cpfTitular){
			this.cpfTitular =cpfTitular;
		}
		
		public String getCPFTitular() {
			return this.cpfTitular;
		}
		
		public boolean deposita(double valor) {
			if(valor > 0.1) {
				this.saldo = this.saldo + valor- 0.10;
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
		
		public boolean saque(double valor) throws ContaException {
			
				if(saldo>=valor && valor > 0) {
					this.saldo = this.saldo - valor - 0.10;
					return true;
				}
				else if(valor <= 0){	
					throw new ContaException("Valor do saque menor ou igual a zero.");
				}
				else {
					throw new ContaException("Saldo Insuficiente!");
				}
			
		}
		
		public boolean transfere(Conta destino, double valor) throws ContaException {
			if(valor<=this.saldo+0.1 && valor > 0) {
				this.saque(valor+0.10);
				destino.deposita(valor+0.1);
			return true;
			}
			else if(valor <= 0) {
				System.out.println("Erro. Transferência com valor 0 ou negativo.");
			return false;
			}
			else{
				System.out.println("Saldo insuficiente para realizar a transferência.");
			return false;
			}
		}
		
		public void processoSaque(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
			double valorSaque;
			
			System.out.print("Insira o valor do saque: R$ ");
			valorSaque = ler.lerDouble();
			
			if(this.saldo == 0) {
				System.out.println("Erro. Saldo igual a 0, impossível realizar o saque!");
				
				}
			else {
				try {
				this.saque(valorSaque);
				EscreveArquivo.registraSaque(contaUsuario, usuario,valorSaque);
				System.out.printf("\nSaldo da conta: R$ %.2f", contaUsuario.getSaldo());
				System.out.println("");
				this.incrementaNumeroDeSaques();
				}
				catch(ContaException e){	
					System.out.println(e);
				}
				
			}
			
		}
		
		public void processoDeposito(Conta contaUsuario, Usuario usuario) throws IOException {
			double valorDeposito;
		
			System.out.print("Insira o valor do depósito: R$ ");
			valorDeposito = ler.lerDouble();
			while(!this.deposita(valorDeposito)) {
				System.out.println("Erro ao realizar depósito. Insira novo valor: ");
				valorDeposito = ler.lerDouble();
			}
			EscreveArquivo.registraDeposito(contaUsuario, usuario,valorDeposito);
			System.out.printf("\nSaldo da conta: R$ %.2f", contaUsuario.getSaldo());
			System.out.println("");
			this.incrementaNumeroDeDepositos();
			
		}
		
		public void processoTransferencia(Conta contaUsuario, Usuario usuario) throws IOException, ContaException {
			
			double valorTransferencia;
			System.out.print("\nInsira o número da conta de destino: ");
			
			Conta contaDestino = retornaConta();
	
			while(contaDestino == null || contaUsuario.getNumConta() == contaDestino.getNumConta()) {
				
				if (contaDestino == null) {
					System.out.println("\nConta não encontrada! \n");
				}
				else if(contaUsuario.getNumConta() == contaDestino.getNumConta()) {
					System.out.println("\nImpossível transferir para sua própria conta.\n");
				}
				
				System.out.print("Insira novamente o número da conta: ");
				contaDestino = retornaConta();
			}
			
			System.out.print("Insira o valor a ser transferido: R$ ");
			valorTransferencia = ler.lerDouble();
		
			this.transfere(contaDestino, valorTransferencia);
			EscreveArquivo.registraTransferencia(contaUsuario, contaDestino, usuario, valorTransferencia);
			System.out.printf("\nSaldo do remetente: R$ %.2f", contaUsuario.getSaldo());
			System.out.println("");
			this.incrementaNumeroDeTransferencias();
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
			System.out.println("Agência: " + getAgencia());
			System.out.printf("Saldo : R$%.2f", getSaldo());
			System.out.println("\n########################\n");
		}
		
		public Conta retornaConta() throws IOException {
			int numContaDestino;
			numContaDestino = ler.lerInteiro();
			return BancoDados.mapContas.get(numContaDestino);
		}
		
}
