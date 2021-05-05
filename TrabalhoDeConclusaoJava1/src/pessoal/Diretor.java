package pessoal;


public class Diretor extends Cliente implements Funcionario{
	public Diretor() {
		
	}
	
	public Diretor(String senhaFuncionario, String cpfFuncionario, String nome, String sobrenome, Cargo cargoFuncionario) {
		super(senhaFuncionario,cpfFuncionario,nome,sobrenome, cargoFuncionario);
	}
}
