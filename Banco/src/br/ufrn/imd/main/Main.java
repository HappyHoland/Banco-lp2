package br.ufrn.imd.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import br.ufrn.imd.domain.*;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		Scanner input = new Scanner(System.in);
		File file = new File("data/clientes.txt");
		
		try {
			Scanner clientData = new Scanner(file);
			
			System.out.println(clientData.nextLine());
			
			
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
			
		} finally {
			
			input.close();
		}
		
				
	}

}
