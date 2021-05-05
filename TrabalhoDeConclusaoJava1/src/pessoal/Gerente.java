package pessoal;
 

public class Gerente extends Cliente implements Funcionario {
		private int agenciaGerenciada;
		
		public Gerente() {
			
		}
		
		public Gerente(String senhaFuncionario, String cpfFuncionario, String nome, String sobrenome, Cargo cargoFuncionario,int agencia) {
			super(senhaFuncionario,cpfFuncionario,nome,sobrenome, cargoFuncionario);
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

			
}
