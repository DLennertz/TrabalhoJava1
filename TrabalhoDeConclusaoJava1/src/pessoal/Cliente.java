package pessoal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import conta.Conta;
import conta.ContaCorrente;

public class Cliente extends Usuario{
		
		private String senhaCliente;
		private String cpfCliente; 
		private String nomeCliente;
		private String sobrenomeCliente;
		
		public Cliente() {
			
		}
		
		public Cliente(String senhaCliente, String cpfCliente, String nomeCliente, String sobrenomeCliente) {
			this.senhaCliente=senhaCliente;
			this.cpfCliente=cpfCliente;
			this.nomeCliente=nomeCliente;
			this.sobrenomeCliente=sobrenomeCliente;
		}
		
		public String getSenhaCliente() {
			return this.senhaCliente;
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
			return "Cliente [senhaCliente=" + senhaCliente + ", cpfCliente=" + cpfCliente + ", nomeCliente="
					+ nomeCliente + ", sobrenomeCliente=" + sobrenomeCliente + "]";
		}

		public static Map<String, Cliente> getClientes(){
			Map<String, Cliente> mapClientes = new HashMap<>();
			mapClientes.put("64",new Cliente("123","64","Maria","Silva"));
			mapClientes.put("112",new Cliente("aeiou","112","Joao","Lacerda"));
			mapClientes.put("5",new Cliente("xpto","5","Joaquim","Manuel"));
			mapClientes.put("45",new Cliente("wxyz","45","Alice","Matta"));
			mapClientes.put("94",new Cliente("senha123","94","Zelda","Abreu"));
			mapClientes.put("23",new Cliente("serratec","23","Victoria","Santana"));
			mapClientes.put("4",new Cliente("wasp","4","Julia","Souza"));
			mapClientes.put("92",new Cliente("rio2016","92","Eli","Pereira"));
			
			return mapClientes;
		}
		
}
