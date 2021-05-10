package leituraEscrita;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bancoDeDados.BancoDados;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.ContaTipoEnum;
import enums.UsuarioTipoEnum;
import pessoal.Cliente;
import pessoal.Diretor;
import pessoal.Gerente;
import pessoal.Presidente;
import pessoal.Usuario;

public class LeArquivo {
	
	
	public static Map<Integer, Conta> leArquivoDevolveListaContas() throws IOException{
		Map<Integer, Conta> contas = new HashMap<>();
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
						ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						BancoDados.mapContas.put(Integer.parseInt(pp[1]), cc);
					}
					else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
						ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						BancoDados.mapContas.put(Integer.parseInt(pp[1]), cp);
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}

		return contas;
	}
	
	public static void leArquivoUsuario() throws IOException{
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					 if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
						Diretor d = new Diretor(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						BancoDados.mapUsuario.put(pp[4], d);
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
						Cliente cli = new Cliente(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						BancoDados.mapUsuario.put(pp[4], cli);
						
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getTipo())) {
						Presidente PRE = new Presidente(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						BancoDados.mapUsuario.put(pp[4], PRE);
						
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getTipo())) {
						Gerente G = new Gerente(pp[0], pp[1], pp[2], pp[3], pp[4], Integer.parseInt(pp[5]),Integer.parseInt(pp[6]));
						BancoDados.mapUsuario.put(pp[4], G);
						
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}
		 
	}
	
	public static ArrayList<Conta> listaContaGerente(int agenciaGerenciada) throws IOException{
		ArrayList<Conta> contas = new ArrayList<Conta>();
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())&& Integer.parseInt(pp[4])==agenciaGerenciada) {
						ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						contas.add(cc);
					}
					else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo()) && Integer.parseInt(pp[4])==agenciaGerenciada) {
						ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						contas.add(cp);
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}

		return contas;
	}
	
	public static ArrayList<Usuario> listaClientes() throws IOException{
		ArrayList<Usuario> clientes = new ArrayList<Usuario>();
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					 if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
						Diretor d = new Diretor(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						clientes.add(d);
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
						Cliente cli = new Cliente(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						clientes.add(cli);
						
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getTipo())) {
						Presidente PRE = new Presidente(pp[0], pp[1], (pp[2]), pp[3], pp[4], Integer.parseInt(pp[5]));
						clientes.add(PRE);
						
					}
					else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getTipo())) {
						Gerente G = new Gerente(pp[0], pp[1], pp[2], pp[3], pp[4], Integer.parseInt(pp[5]),Integer.parseInt(pp[6]));
						clientes.add(G);
						
					
				} else
					break;
			}
		}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}

		return clientes;
	}
	
	public static ArrayList<Conta> listaContas() throws IOException{
		ArrayList<Conta> contas = new ArrayList<Conta>();
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("./temp/Repositorio.txt"));
			String linha = "";
			
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] pp = linha.split(";");
					if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
						ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						contas.add(cc);
					}
					else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
						ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), (pp[2]), Double.parseDouble(pp[3]), Integer.parseInt(pp[4]));
						contas.add(cp);
					}
					
				} else
					break;
			}
			buffRead.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no path informado: ./temp/Repositorio.txt");
		}

		return contas;
	}
}
