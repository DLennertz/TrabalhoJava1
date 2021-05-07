package pessoal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.ContaTipoEnum;
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
	public static Map <String, Usuario> getUsuarios() throws IOException{
		Map<String, Usuario> mapUsuario= new HashMap<>();
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					 if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
						 //String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta
						Diretor d = new Diretor(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						mapUsuario.put(pp[4], d);
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
						//String tipoUsuario, String nomeUsuario, String sobrenomeUsuario, String senhaUsuario, String cpfUsuario,int numConta
						Cliente cli = new Cliente(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						//String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta
						mapUsuario.put(pp[4], cli);
						
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}
		 
		return mapUsuario;
	}
}
