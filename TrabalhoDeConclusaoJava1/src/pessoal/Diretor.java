package pessoal;

import enums.UsuarioTipoEnum;

public class Diretor extends Cliente implements Funcionario{
	public Diretor() {
		
	}
	
	public Diretor(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		super(tipoUsuario, nomeUsuario, sobrenomeUsuario, senhaUsuario, cpfUsuario,numConta);
	}
}
