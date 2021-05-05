package pessoal;

public abstract class Funcionario extends Usuario{
		private String senhaFuncionario;
		private String cpfFuncionario;
		private int cargoFuncionario;

		public Funcionario() {
			
		}
		
		public String getSenhaFuncionario() {
			return senhaFuncionario;
		}
		public void setSenhaFuncionario(String senhaFuncionario) {
			this.senhaFuncionario = senhaFuncionario;
		}
		
		public String getCpfFuncionario() {
			return cpfFuncionario;
		}
		public void setCpfFuncionario(String cpfFuncionario) {
			this.cpfFuncionario = cpfFuncionario;
		}
		
		public int getCargoFuncionario() {
			return cargoFuncionario;
		}
		public void setCargoFuncionario(int cargoFuncionario) {
			this.cargoFuncionario = cargoFuncionario;
		}

		@Override
		public String toString() {
			return "Funcionario [senhaFuncionario=" + senhaFuncionario + ", cpfFuncionario=" + cpfFuncionario
					+ ", cargoFuncionario=" + cargoFuncionario + "]";
		}
		
}
