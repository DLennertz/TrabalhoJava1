package cliente;

public class Cliente {
		
		private String senhaCliente;
		private String cpfCliente; 
		
		public Cliente() {
			
		}
		
		public String getSenhaCliente() {
			return senhaCliente;
		}
		public void setSenhaCliente(String senhaCliente) {
			this.senhaCliente = senhaCliente;
		}
		public String getCpfCliente() {
			return cpfCliente;
		}
		public void setCptCliente(String cpfCliente) {
			this.cpfCliente = cpfCliente;
			
		}

		@Override
		public String toString() {
			return "Cliente [senhaCliente=" + senhaCliente + ", cpfCliente=" + cpfCliente + "]";
		}
		
		
}
