package caligiuri.esercizi;
/*
 * Scrivere un programma Java che legga un intero rappresentante un voto compreso 
 * da 0 e 30 da Standard Input (tastiera) e restituisca su Console:
– «Esame Superato!» se il voto è compreso tra 18 e 30
– «Esame non Superato!» se il voto è inferiore a 18
 */
import java.util.Scanner;

public class Esame {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("Inserisci il tuo voto: ");
		int voto = s.nextInt();
		
		if (voto >= 18 && voto <=30) {
				System.out.println("Esame Superato!");
			}
			else {
				System.out.println("Esame non Superato!");
				s.close();
		}

	}
}