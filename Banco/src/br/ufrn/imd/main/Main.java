package br.ufrn.imd.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import br.ufrn.imd.domain.*;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		Data data = new Data("data/bancos.txt", "data/agencias.txt", "data/clientes.txt", "data/transacoes.txt");
		Scanner sc = new Scanner(System.in);
		boolean end = false;
		int opcao = -1;
		String aux;
		
		try {
			
			while (!end) {
				System.out.println("Escolha uma opcao: ");
				System.out.println("1 - Entrar");
				System.out.println("2 - Cadastrar");
				System.out.println("0 - Sair");
				
				do {
					opcao = Integer.parseInt(sc.nextLine());
				} while (opcao > 2 || opcao < 0);
				
				switch (opcao) {
					case 1:
						System.out.println("Insira o numero da conta: ");
						aux = sc.nextLine();
						
						cliente.setConta(aux);
						
						if (data.getClientes().contains(cliente)) {
							cliente = data.getClientes().get(data.getClientes().indexOf(cliente));
							
							System.out.println("Insira a senha: ");
							
							aux = sc.nextLine();
								
							if (aux != cliente.getSenha()) {
								System.out.println("Senha incorreta");
							} else {
								System.out.println("WIP");
							}
							
						} else {
							System.out.println("Conta nao encontrada.");
						}
						
						break;
					
					default:
						System.out.println("WIP");
				}
			}
			
		} finally {
			
			sc.close();
		}
		
				
	}

}
