package pessoal;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bancoDeDados.BancoDados;
import conta.Conta;
import leituraEscritaArquivo.EscreveArquivo;
import leituraEscritaArquivo.LeArquivo;

public class Presidente extends Cliente implements Funcionario{
	
	public Presidente() {
		
	}
	
	public Presidente(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
	}
	
	public void relatorioPresidente() throws IOException {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		lista = LeArquivo.listaClientes();
		Collections.sort(lista);
		System.out.println("RELATÓRIO DOS CLIENTES");
		for(Usuario c : lista) {
			System.out.print("NOME : " + c.nomeUsuario + " \nCPF : " + c.getcpfUsuario() + " \nAGÊNCIA : " + (BancoDados.mapContas.get(c.numConta)).getAgencia()+"\n###############\n");		
		}
		EscreveArquivo.registraRelatorioUsuarios(lista);
	}
	
	public void relatorioCapitalPresidente() throws IOException {
		DecimalFormat formatador = new DecimalFormat("0.00");
		ArrayList<Conta> lista = new ArrayList<Conta>();
		double total = 0;
		lista = LeArquivo.listaContas();
		System.out.println("CAPITAL TOTAL");
		for(Conta c : lista) {
			total+=c.getSaldo();
		}
		System.out.println("TOTAL : R$ " + formatador.format(total));
		
		EscreveArquivo.registroCapitalTotal(total);
	}

	@Override
	public void relatorioNumeroContas() throws IOException {
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Digite o número da Agência: ");
		int agencia = sc.nextInt();
		
		
		lista = LeArquivo.listaContaGerente(agencia);
		System.out.println("RELATÓRIO N# DE CONTAS NA AGÊNCIA "+agencia);
		System.out.print("CONTAS EXISTENTES NA AGÊNCIA: ");
		for(Conta c : lista) {
			if(c.getAgencia() == agencia) {
				System.out.print(c.getNumConta() + " / ");
			}
		}
		System.out.println("\n");
		EscreveArquivo.registroRelatorioNumeroContas(lista, agencia);
	}
	
	
}
