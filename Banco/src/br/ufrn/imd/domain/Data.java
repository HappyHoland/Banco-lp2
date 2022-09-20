package br.ufrn.imd.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	public Data() {};
	
	public List <Cliente> readClientes(String filename) {
		List <Cliente> clientes = new ArrayList<Cliente>();
		File file = new File(filename);
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {

				Cliente cliente = new Cliente();
				cliente.setId(Integer.parseInt(sc.nextLine()));
				cliente.setConta(sc.nextLine());
				cliente.setTipo(sc.nextLine());
				cliente.setNome(sc.nextLine());
				cliente.setCpf(sc.nextLine());
				cliente.setEndereco(sc.nextLine());
				cliente.getAgencia().setId(Integer.parseInt(sc.nextLine()));
				cliente.setSaldo(Double.parseDouble(sc.nextLine()));
				cliente.setFatura(Double.parseDouble(sc.nextLine()));
				
				clientes.add(cliente);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return clientes;
		
	}
}
