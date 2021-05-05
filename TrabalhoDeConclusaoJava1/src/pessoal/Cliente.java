package pessoal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import conta.Conta;
import conta.ContaCorrente;

public class Cliente extends Usuario{
		
		public Cliente() {
			
		}
		
		public Cliente(String senhaCliente, String cpfCliente, String nomeCliente, String sobrenomeCliente, Cargo cargo) {
			super(senhaCliente, cpfCliente, nomeCliente, sobrenomeCliente, cargo);
		}

		@Override
		public String toString() {
			return "Cliente [senhaUsuario=" + senhaUsuario + ", cpfUsuario=" + cpfUsuario + ", nomeUsuario="
					+ nomeUsuario + ", sobrenomeUsuario=" + sobrenomeUsuario + ", cargoUsuario=" + cargoUsuario + "]";
		}
		
		
		

}
