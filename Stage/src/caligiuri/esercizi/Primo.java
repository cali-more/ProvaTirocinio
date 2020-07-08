package caligiuri.esercizi;
/*
 * Scrivere un programma Java che legga un intero Standard Input (tastiera) 
 * e restituisca su Console true se il numero è primo, false altrimenti.
 */
import java.util.Scanner;

public class Primo {

	public static Scanner in = new Scanner(System.in);

	public static boolean primo ( int x ) {
		for (int i = 2; i <= Math.sqrt(x) ; i++) {
			if ( x % i == 0 ) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("Inserisci un numero intero positivo: ");
		int n = in.nextInt();
		System.out.println(primo (n));
		System.out.println("La lista dei numeri primi da 1 a " + n + " è:");

		for (int i = 1; i <= n; i++) {
			if (primo(i)) {
				System.out.println( " " + i + " ");
			}
		}

	}

}
