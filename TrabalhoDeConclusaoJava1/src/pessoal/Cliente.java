package pessoal;

public class Cliente extends Usuario{
		
		public Cliente() {
			
		}
		
		public Cliente(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
			super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
		}

		@Override
		public String toString() {
			return "Cliente [senhaUsuario=" + senhaUsuario + ", cpfUsuario=" + cpfUsuario + ", nomeUsuario="
					+ nomeUsuario + ", sobrenomeUsuario=" + sobrenomeUsuario + ", tipoUsuario=" + tipoUsuario + "]";
		}
		
		
		

}
