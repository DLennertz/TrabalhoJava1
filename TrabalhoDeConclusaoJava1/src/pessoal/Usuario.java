package pessoal;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	protected String senhaUsuario;
	protected String cpfUsuario; 
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	protected Cargo cargoUsuario;
	protected int numConta;
	
	public Usuario() {
		
	}
	
	public Usuario(String senhaUsuario, String cpfUsuario, String nomeUsuario, String sobrenomeUsuario, Cargo cargo,int numConta) {
		this.senhaUsuario=senhaUsuario;
		this.cpfUsuario=cpfUsuario;
		this.nomeUsuario=nomeUsuario;
		this.sobrenomeUsuario=sobrenomeUsuario;
		this.cargoUsuario=cargo;
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
	
	public Cargo getCargo() {
		return cargoUsuario;
	}
	public static Map <String, Usuario> getUsuarios(){
		Map<String, Usuario> mapUsuario= new HashMap<>();
		
		mapUsuario.put("265", new Gerente("abcdef", "265", "Gustavo", "Almeida", Cargo.Gerente,200,678));
		mapUsuario.put("976", new Gerente("vwxyz", "976", "Alan", "Martins", Cargo.Gerente,400,53));
		mapUsuario.put("9465", new Diretor("65432", "9465", "Cintia", "Souza" , Cargo.Diretor,78));
		mapUsuario.put("5556", new Diretor("1472", "5556", "Marcelo", "Andrade" , Cargo.Diretor,60));
		mapUsuario.put("333", new Presidente("klmno", "333", "Bianca", "Silva", Cargo.Presidente,1));
		mapUsuario.put("64",new Cliente("123","64","Maria","Silva",Cargo.Cliente,10));
		mapUsuario.put("112",new Cliente("aeiou","112","Joao","Lacerda",Cargo.Cliente,8));
		mapUsuario.put("5",new Cliente("xpto","5","Joaquim","Manuel",Cargo.Cliente,15));
		mapUsuario.put("45",new Cliente("wxyz","45","Alice","Matta",Cargo.Cliente,19));
		mapUsuario.put("94",new Cliente("senha123","94","Zelda","Abreu",Cargo.Cliente,5));
		mapUsuario.put("23",new Cliente("serratec","23","Victoria","Santana",Cargo.Cliente,11));
		mapUsuario.put("4",new Cliente("wasp","4","Julia","Souza",Cargo.Cliente,12));
		mapUsuario.put("92",new Cliente("rio2016","92","Eli","Pereira",Cargo.Cliente,13));
		 
		return mapUsuario;
	}
}
