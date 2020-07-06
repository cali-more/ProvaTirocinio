package caligiuri.esercizi;
/*
 * Dati due array verificare che uno sia anagramma dell’altro
 */
import java.util.*;

public class Anagramma {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Inserisci la prima parola: ");
		String primaParola = in.nextLine();
		System.out.println("Inserisci la seconda parola: ");
		String secondaParola = in.nextLine();
		
		// acquisizione parole
		boolean isAnagramma = true;
		if (primaParola.length() == secondaParola.length()) 
			
			//verifica anagramma
			for (int i = 0; i < primaParola.length(); i++) {
				char c = primaParola.charAt(i);
				int indice = secondaParola.indexOf(c);
				if(indice >= 0)
					secondaParola = secondaParola.substring(0,indice) + secondaParola.substring(indice+1);
				else 
					isAnagramma = false;
			}
		else 
			isAnagramma = false;
		
		// comunicazione dei risutati
		if (isAnagramma)
			System.out.println("Anagramma vero!");
		else
			System.out.println("Anagramma falso!");
	}

	}


