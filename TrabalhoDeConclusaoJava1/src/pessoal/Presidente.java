package pessoal;

import enums.UsuarioTipoEnum;

public class Presidente extends Cliente implements Funcionario{
	
	public Presidente() {
		
	}
	
	public Presidente(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
	}
}
