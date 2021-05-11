package pessoal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import bancoDeDados.BancoDados;
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
}
