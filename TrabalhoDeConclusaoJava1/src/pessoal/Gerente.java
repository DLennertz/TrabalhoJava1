package pessoal;

import enums.UsuarioTipoEnum;

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

		public void relatorioGerente() {
			System.out.println("ENTROU NA FUNÇAO!");
		}
}
