package pessoal;

import java.util.HashMap;
import java.util.Map;

import enums.UsuarioTipoEnum;

public class Usuario {
	protected String tipoUsuario;
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	protected String senhaUsuario;
	protected String cpfUsuario; 
	protected int numConta;
	
	public Usuario() {
		
	}
	
	public Usuario(String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta) {
		this.senhaUsuario=senhaUsuario;
		this.cpfUsuario=cpfUsuario;
		this.nomeUsuario=nomeUsuario;
		this.sobrenomeUsuario=sobrenomeUsuario;
		this.tipoUsuario=tipoUsuario;
		this.numConta=numConta;
	}
	
	public String getSenhaUsuario(){
		return senhaUsuario;
	}
	
	public int getNumConta() {
		return numConta;
	}
	public String getcpfUsuario(){
		return cpfUsuario;
	}
	
	public String getTipo() {
		return tipoUsuario;
	}
	public static Map <String, Usuario> getUsuarios(){
		Map<String, Usuario> mapUsuario= new HashMap<>();
		
		mapUsuario.put("265", new Gerente("Gerente","Gustavo", "Almeida","abcdef", "265",678,200));
		mapUsuario.put("976", new Gerente("Gerente","Alan", "Martins","vwxyz", "976",53,400));
		mapUsuario.put("9465", new Diretor("Diretor","Cintia", "Souza" ,"65432", "9465", 78));
		mapUsuario.put("5556", new Diretor("Diretor","Marcelo", "Andrade" ,"1472", "5556", 60));
		mapUsuario.put("333", new Presidente("Presidente","Bianca", "Silva","klmno","333",1));
		mapUsuario.put("64",new Cliente("Cliente","Maria","Silva","123","64",10));
		mapUsuario.put("112",new Cliente("Cliente","Joao","Lacerda","aeiou","112",8));
		mapUsuario.put("5",new Cliente("Cliente","Joaquim","Manuel","xpto","5",15));
		mapUsuario.put("45",new Cliente("Cliente","Alice","Matta","wxyz","45",19));
		mapUsuario.put("94",new Cliente("Cliente","Zelda","Abreu","senha123","94",5));
		mapUsuario.put("23",new Cliente("Cliente","Victoria","Santana","serratec","23",11));
		mapUsuario.put("4",new Cliente("Cliente","Julia","Souza","wasp","4",12));
		mapUsuario.put("92",new Cliente("Cliente","Eli","Pereira","rio2016","92",13));
		mapUsuario.put("321",new Cliente("Cliente","Julia","Souza","wasp","321",1001));
		mapUsuario.put("9210",new Cliente("Cliente","Eli","Pereira","rio2016","9210",1002));
		 
		return mapUsuario;
	}
}
