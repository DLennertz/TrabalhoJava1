package pessoal;

import java.io.IOException;
import java.util.ArrayList;

import bancoDeDados.BancoDados;
import conta.Conta;
import enums.UsuarioTipoEnum;
import leituraEscrita.LeArquivo;

public class Diretor extends Cliente implements Funcionario{
	public Diretor() {
		
	}
	
	public Diretor(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
	}
	
	public void relatorioDiretor() throws IOException {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		lista = LeArquivo.listaClientes();
		//lista.sort();
		System.out.println("RELATÓRIO DOS CLIENTES");
		for(Cliente c : lista) {
			System.out.print("NOME : " + c.nomeUsuario + " \nCPF : " + c.getcpfUsuario() + " \nAGÊNCIA : " + (BancoDados.mapContas.get(c.numConta)).getAgencia()+"\n###############\n");
			
		}
	}
}
