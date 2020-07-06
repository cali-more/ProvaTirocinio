package caligiuri.esercizi;
/*
 *  Individuare l’elemento massimo in un array di interi
 */
import java.util.*;
public class MassimoInArray {

	public static Scanner in=new Scanner(System.in);

	public static void scriviArray(int x[]) {
		for (int i = 0; i < x.length; i++ ) {
			System.out.print(x[i] + " ");
		}
	}
	
	public static void leggiArray(int x[]) {
		for (int i = 0; i < x.length; i++ ) {
			x[i] = in.nextInt();
		}
	}
	
	public static int maxInArray(int v[]) {
		int max = v[0];
		for (int e : v) {
			if (e > max) {
				max = e;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		int a[] = new int[5];
		
		System.out.println ("Inserisci 5 numeri interi: ");
		leggiArray(a);
		
		System.out.println ("Questo e' l'array che hai inserito: ");
		scriviArray(a);
		
	System.out.println ("L'elemento massimo nell'array che hai inserito è: " + maxInArray(a));
		
		
		
	}

}
