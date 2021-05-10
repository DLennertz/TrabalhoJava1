package pessoal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import bancoDeDados.BancoDados;
import conta.Conta;
import leituraEscrita.LeArquivo;

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
	}
	
	public void relatorioCapitalPresidente() throws IOException {
		ArrayList<Conta> lista = new ArrayList<Conta>();
		double total = 0;
		lista = LeArquivo.listaContas();
		System.out.println("CAPITAL TOTAL");
		for(Conta c : lista) {
			total+=c.getSaldo();
		}
		System.out.println("TOTAL : " + total);
	}
}
