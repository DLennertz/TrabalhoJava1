package pessoal;

import java.awt.List;
import java.io.IOException;
import java.util.Map;

import conta.Conta;

import java.util.HashMap;

import enums.UsuarioTipoEnum;
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
			Map<Integer,Conta> lista = new HashMap<>();
			
			lista = LeArquivo.listaContaGerente(this.agenciaGerenciada);
			System.out.println("RELATÓRIO N# DE CONTAS NA AGÊNCIA "+this.agenciaGerenciada);
			System.out.println("N# DE CONTAS EXISTENTES : "+ lista.size());
		}
}
