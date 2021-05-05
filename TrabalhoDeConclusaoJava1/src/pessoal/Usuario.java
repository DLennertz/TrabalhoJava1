package pessoal;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	protected String senhaUsuario;
	protected String cpfUsuario; 
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	protected Cargo cargoUsuario;
	
	public Usuario() {
		
	}
	
	public Usuario(String senhaUsuario, String cpfUsuario, String nomeUsuario, String sobrenomeUsuario, Cargo cargo) {
		this.senhaUsuario=senhaUsuario;
		this.cpfUsuario=cpfUsuario;
		this.nomeUsuario=nomeUsuario;
		this.sobrenomeUsuario=sobrenomeUsuario;
		this.cargoUsuario=cargo;
	}
	
	public String getSenhaUsuario(){
		return senhaUsuario;
	}
	
	public String getcpfUsuario(){
		return cpfUsuario;
	}
	
	public static Map <String, Usuario> getUsuarios(){
		Map<String, Usuario> mapUsuario= new HashMap<>();
		
		mapUsuario.put("265", new Gerente("abcdef", "265", "Gustavo", "Almeida", Cargo.Gerente,200));
		mapUsuario.put("976", new Gerente("vwxyz", "976", "Alan", "Martins", Cargo.Gerente,400));
		mapUsuario.put("9465", new Diretor("65432", "9465", "Cintia", "Souza" , Cargo.Diretor));
		mapUsuario.put("5556", new Diretor("1472", "5556", "Marcelo", "Andrade" , Cargo.Diretor));
		mapUsuario.put("333", new Presidente("klmno", "333", "Bianca", "Silva", Cargo.Presidente));
		mapUsuario.put("64",new Cliente("123","64","Maria","Silva",Cargo.Cliente));
		mapUsuario.put("112",new Cliente("aeiou","112","Joao","Lacerda",Cargo.Cliente));
		mapUsuario.put("5",new Cliente("xpto","5","Joaquim","Manuel",Cargo.Cliente));
		mapUsuario.put("45",new Cliente("wxyz","45","Alice","Matta",Cargo.Cliente));
		mapUsuario.put("94",new Cliente("senha123","94","Zelda","Abreu",Cargo.Cliente));
		mapUsuario.put("23",new Cliente("serratec","23","Victoria","Santana",Cargo.Cliente));
		mapUsuario.put("4",new Cliente("wasp","4","Julia","Souza",Cargo.Cliente));
		mapUsuario.put("92",new Cliente("rio2016","92","Eli","Pereira",Cargo.Cliente));
		 
		return mapUsuario;
	}
}
