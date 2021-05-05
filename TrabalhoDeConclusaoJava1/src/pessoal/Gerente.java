package pessoal;
 

public class Gerente extends Funcionario {
		private int agenciaGerenciada;
		
		public Gerente() {
			
		}
		
		public int getAgenciaGerenciada() {
			return agenciaGerenciada;
		}
		public void setAgenciaGerenciada(int agenciaGerenciada) {
			this.agenciaGerenciada = agenciaGerenciada;
		}

		@Override
		public String toString() {
			return "Gerente [agenciaGerenciada=" + agenciaGerenciada + ", getSenhaFuncionario()="
					+ getSenhaFuncionario() + ", getCpfFuncionario()=" + getCpfFuncionario()
					+ ", getCargoFuncionario()=" + getCargoFuncionario() + "]";
		}
		
		
}
