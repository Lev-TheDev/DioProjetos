package application;

import java.util.Locale;
import java.util.Scanner;

import exceptions.ParametrosInvalidosException;

public class Contador {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		int parametroUm = sc.nextInt();
		int parametroDois = sc.nextInt();
		
		try {
			contar(parametroUm, parametroDois);
			
		} catch (ParametrosInvalidosException e) {
			System.out.println("ERRO: O segundo parâmetro deve ser maior que o primeiro.");
		}
		
		sc.close();
	}
	
	static void contar(int param1, int param2) throws ParametrosInvalidosException{
		if (param1 > param2){
			throw new ParametrosInvalidosException();
		} else {
			int contagem = param2 - param1;
			for (int i = 1; i <= contagem; i++) {
				System.out.println("Imprimindo o número " + i + ".");
			}
		}
	}

}
