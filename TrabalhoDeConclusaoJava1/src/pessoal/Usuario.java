package pessoal;

import java.util.HashMap;
import java.util.Map;

import enumerador.UsuarioEnum;

public class Usuario {
	protected String senhaUsuario;
	protected String cpfUsuario; 
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	protected UsuarioEnum cargoUsuario;
	protected int numConta;
	
	public Usuario() {
		
	}
	
	public Usuario(String senhaUsuario, String cpfUsuario, String nomeUsuario, String sobrenomeUsuario, UsuarioEnum cargo,int numConta) {
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
	
	public UsuarioEnum getCargo() {
		return cargoUsuario;
	}
	public static Map <String, Usuario> getUsuarios(){
		Map<String, Usuario> mapUsuario= new HashMap<>();
		
		mapUsuario.put("265", new Gerente("abcdef", "265", "Gustavo", "Almeida", UsuarioEnum.Gerente,200,678));
		mapUsuario.put("976", new Gerente("vwxyz", "976", "Alan", "Martins", UsuarioEnum.Gerente,400,53));
		mapUsuario.put("9465", new Diretor("65432", "9465", "Cintia", "Souza" , UsuarioEnum.Diretor,78));
		mapUsuario.put("5556", new Diretor("1472", "5556", "Marcelo", "Andrade" , UsuarioEnum.Diretor,60));
		mapUsuario.put("333", new Presidente("klmno", "333", "Bianca", "Silva", UsuarioEnum.Presidente,1));
		mapUsuario.put("64",new Cliente("123","64","Maria","Silva",UsuarioEnum.Cliente,10));
		mapUsuario.put("112",new Cliente("aeiou","112","Joao","Lacerda",UsuarioEnum.Cliente,8));
		mapUsuario.put("5",new Cliente("xpto","5","Joaquim","Manuel",UsuarioEnum.Cliente,15));
		mapUsuario.put("45",new Cliente("wxyz","45","Alice","Matta",UsuarioEnum.Cliente,19));
		mapUsuario.put("94",new Cliente("senha123","94","Zelda","Abreu",UsuarioEnum.Cliente,5));
		mapUsuario.put("23",new Cliente("serratec","23","Victoria","Santana",UsuarioEnum.Cliente,11));
		mapUsuario.put("4",new Cliente("wasp","4","Julia","Souza",UsuarioEnum.Cliente,12));
		mapUsuario.put("92",new Cliente("rio2016","92","Eli","Pereira",UsuarioEnum.Cliente,13));
		 
		return mapUsuario;
	}
}
