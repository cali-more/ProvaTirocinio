package caligiuri.esercizi;
/*
 * Scrivere un programma Java che legga un intero Standard Input (tastiera) 
 * e restituisca su Console il suo fattoriale.
 */

import java.util.Scanner;

public class Fattoriale {

	public static int fattoriale (int numero) {

		int fat = 1;
		for (int i=1; i<=numero; i++) {
			fat *= i;
		}
		return fat;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);

		System.out.println("Inserisci il tuo numero: ");

		int numero = sc.nextInt();

		System.out.println("Il fattoriale di: " + numero + " è: " + fattoriale (numero));
		sc.close();
	}
}