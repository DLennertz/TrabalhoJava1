package pessoal;

public class Usuario  implements Comparable<Usuario>{
	protected String tipoUsuario;
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	protected String senhaUsuario;
	protected String cpfUsuario; 
	protected int numConta;
	
	protected String seguroVida;
	protected double valorSegVida;
	
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
	
	public String getNome() {
		return nomeUsuario;
	}
	
	public String getSobrenome() {
		return sobrenomeUsuario;
	}
	
	
	
	public String getSeguroVida() {
		return seguroVida;
	}

	public void setSeguroVida(String seguroVida) {
		this.seguroVida = seguroVida;
	}
	

	public double getValorSegVida() {
		return valorSegVida;
	}

	public void setValorSegVida(double valorSegVida) {
		this.valorSegVida = valorSegVida;
	}
	
	
	
	
	
	@Override
	public int compareTo(Usuario o) {
		return this.nomeUsuario.compareTo(o.nomeUsuario);
	}

	

}
