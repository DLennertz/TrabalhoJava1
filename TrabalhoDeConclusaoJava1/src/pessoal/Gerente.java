package pessoal;

import java.io.IOException;
import conta.Conta;

import java.util.ArrayList;

import leituraEscrita.EscreveArquivo;
import leituraEscrita.LeArquivo;

public class Gerente extends Cliente implements Funcionario {
		private int agenciaGerenciada;
		
		public Gerente() {
			
		}
		
		public Gerente(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta,int agencia) {
			super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
			this.agenciaGerenciada=agencia;
		}
		public int getAgenciaGerenciada() {
			return agenciaGerenciada;
		}
		public void setAgenciaGerenciada(int agenciaGerenciada) {
			this.agenciaGerenciada = agenciaGerenciada;
		}

		@Override
		public String toString() {
			return "Gerente [agenciaGerenciada=" + agenciaGerenciada + ", senhaUsuario=" + senhaUsuario
					+ ", cpfUsuario=" + cpfUsuario + ", nomeUsuario=" + nomeUsuario + ", sobrenomeUsuario="
					+ sobrenomeUsuario + ", tipoUsuario=" + tipoUsuario + "]";
		}

		public void relatorioGerente() throws IOException {
			ArrayList<Conta> lista = new ArrayList<Conta>();
			
			lista = LeArquivo.listaContaGerente(this.agenciaGerenciada);
			System.out.println("RELATÓRIO N# DE CONTAS NA AGÊNCIA "+this.agenciaGerenciada);
			System.out.print("CONTAS EXISTENTES NA AGÊNCIA: ");
			for(Conta c : lista) {
				if(c.getAgencia() == this.agenciaGerenciada) {
					System.out.print(c.getNumConta() + " / ");
				}
			}
			System.out.println("\n");
			EscreveArquivo.registroRelatorioNumeroContas(lista, agenciaGerenciada);
		}
}
