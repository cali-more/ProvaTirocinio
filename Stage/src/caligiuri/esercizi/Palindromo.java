package caligiuri.esercizi;
/*
 * Verificare che un array sia palindromo
 */
import java.util.*;

public class Palindromo {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void scriviArray (int x[]) {
		for (int i=0; i<x.length; i++ ) {
			System.out.println(x[i] + " ");
		}
	}
	
	public static void leggiArray (int x[]) {
		for (int i=0; i<x.length; i++ ) {
			x[i] = in.nextInt();
		}
	}
	
	public static boolean palindromo (int a[]) {
		for (int i=0; i<a.length/2; i++) {
			if (a[i] != a[a.length-1-i])
			 	return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int x [] = new int [3];
		
		System.out.println("Inserisci un array di 3 elementi.. ");
		leggiArray(x);
		
		System.out.println("Questo e' l'array che hai inserito: ");
		scriviArray(x);
		
		if (palindromo(x))
			System.out.println("L'array è PALINDROMO");
		else
			System.out.println("L'array NON è palindromo");
	}
}