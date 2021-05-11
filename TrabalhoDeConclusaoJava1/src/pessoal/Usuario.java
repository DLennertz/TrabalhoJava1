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
	
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario=senhaUsuario;
	}
	
	public int getNumConta() {
		return numConta;
	}
	
	public void setNumConta(int numConta) {
		this.numConta=numConta;
	}
	
	public String getcpfUsuario(){
		return cpfUsuario;
	}
	
	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario=cpfUsuario;
	}
	
	public String getTipo() {
		return tipoUsuario;
	}
	
	public void setTipo(String tipo) {
		this.tipoUsuario=tipo;
	}
	
	public String getNome() {
		return nomeUsuario;
	}
	
	public void setNome(String nome) {
		this.nomeUsuario=nome;
	}
	
	public String getSobrenome() {
		return sobrenomeUsuario;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenomeUsuario=sobrenome;
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
