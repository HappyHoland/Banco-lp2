package br.ufrn.imd.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	
	private List <Banco> bancos;
	private List <Agencia> agencias;
	private List <Cliente> clientes;
	private List <Transacao> transacoes;
	
	public Data(String fileBancos, String fileAgencias, String fileClientes, String fileTransacoes) {
		readBancos(fileBancos);
		readAgencias(fileAgencias);
		readClientes(fileClientes);
		readTransacoes(fileTransacoes);
	}
	
	public List<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void readClientes(String filename) {
		clientes = new ArrayList<Cliente>();
		File file = new File(filename);
		Agencia aux = new Agencia();
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {

				Cliente cliente = new Cliente();
				cliente.setId(Integer.parseInt(sc.nextLine()));
				cliente.setConta(sc.nextLine());
				cliente.setSenha(sc.nextLine());
				cliente.setNome(sc.nextLine());
				cliente.setCpf(sc.nextLine());
				cliente.setEndereco(sc.nextLine());
				
				aux.setId(Integer.parseInt(sc.nextLine()));
				
				if (agencias.contains(aux)) {
					for (Agencia a : agencias) {
						if (aux == a) {
							aux = a;
							
							break;
						}
					}
				}
				
				cliente.setAgencia(aux);
				cliente.setSaldo(Double.parseDouble(sc.nextLine()));
				
				sc.nextLine();
				
				clientes.add(cliente);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readAgencias(String filename) {
		agencias = new ArrayList<Agencia>();
		File file = new File(filename);
		Banco aux = new Banco();
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {

				Agencia agencia = new Agencia();
				agencia.setId(Integer.parseInt(sc.nextLine()));
				agencia.setDescricao(sc.nextLine());
				agencia.setEndereco(sc.nextLine());
				
				aux.setId(Integer.parseInt(sc.nextLine()));
				
				if (bancos.contains(aux)) {
					for (Banco b : bancos) {
						if (aux == b) {
							aux = b;
							
							break;
						}
					}
				}
				
				agencia.setBanco(aux);
				
				sc.nextLine();
				
				agencias.add(agencia);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readBancos(String filename) {
		bancos = new ArrayList <Banco>();
		File file = new File(filename);
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {

				Banco banco = new Banco();
				banco.setId(Integer.parseInt(sc.nextLine()));
				banco.setDescricao(sc.nextLine());
				
				sc.nextLine();
				
				bancos.add(banco);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readTransacoes(String filename) {
		transacoes = new ArrayList <Transacao>();
		File file = new File(filename);
		Cliente aux1 = new Cliente(), aux2 = new Cliente();
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {

				Transacao trans = new Transacao();
				trans.setId(Integer.parseInt(sc.nextLine()));
				
				aux1.setConta(sc.nextLine());
				aux2.setConta(sc.nextLine());
				
				for (Cliente c : clientes) {
					if (aux1 == c) {
						
						trans.setFrom(c);
						
					} else if (aux2 == c) {
						
						trans.setTo(c);
					}
				}
				
				trans.setValor(Double.parseDouble(sc.nextLine()));
				trans.setData(LocalDate.parse(sc.nextLine()));
				
				sc.nextLine();
				
				transacoes.add(trans);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
