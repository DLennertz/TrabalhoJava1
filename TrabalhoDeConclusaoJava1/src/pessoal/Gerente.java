package pessoal;

import enumerador.UsuarioEnum;

public class Gerente extends Cliente implements Funcionario {
		private int agenciaGerenciada;
		
		public Gerente() {
			
		}
		
		public Gerente(String senhaFuncionario, String cpfFuncionario, String nome, String sobrenome, UsuarioEnum cargoFuncionario,int numConta,int agencia) {
			super(senhaFuncionario,cpfFuncionario,nome,sobrenome, cargoFuncionario,numConta);
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
					+ sobrenomeUsuario + ", cargoUsuario=" + cargoUsuario + "]";
		}

		public void relatorioGerente() {
			System.out.println("ENTROU NA FUNÇAO!");
		}
}
