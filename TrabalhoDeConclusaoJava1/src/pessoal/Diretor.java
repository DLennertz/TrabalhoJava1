package pessoal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bancoDeDados.BancoDados;
import conta.Conta;
import leituraEscritaArquivo.EscreveArquivo;
import leituraEscritaArquivo.LeArquivo;

public class Diretor extends Cliente implements Funcionario{
	public Diretor() {
		
	}
	
	public Diretor(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
	}
	
	public void relatorioDiretor() throws IOException {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		lista = LeArquivo.listaClientes();
		Collections.sort(lista);
		System.out.println("RELATÓRIO DOS CLIENTES");
		for(Usuario c : lista) {
			System.out.print("NOME : " + c.nomeUsuario + " \nCPF : " + c.getcpfUsuario() + " \nAGÊNCIA : " + (BancoDados.mapContas.get(c.numConta)).getAgencia()+"\n###############\n");
		}
		EscreveArquivo.registraRelatorioUsuarios(lista);
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
