package pessoal;

import enumerador.UsuarioEnum;

public class Diretor extends Cliente implements Funcionario{
	public Diretor() {
		
	}
	
	public Diretor(String senhaFuncionario, String cpfFuncionario, String nome, String sobrenome, UsuarioEnum cargoFuncionario,int numConta) {
		super(senhaFuncionario,cpfFuncionario,nome,sobrenome, cargoFuncionario,numConta);
	}
}
