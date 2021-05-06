package pessoal;

import enumerador.UsuarioEnum;

public class Presidente extends Cliente implements Funcionario{
	
	public Presidente() {
		
	}
	
	public Presidente(String senhaFuncionario, String cpfFuncionario, String nome, String sobrenome, UsuarioEnum cargoFuncionario, int numConta) {
		super(senhaFuncionario,cpfFuncionario,nome,sobrenome, cargoFuncionario,numConta);
	}
}
