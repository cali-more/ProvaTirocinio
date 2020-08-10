package caligiuri.esercizi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CalcoloMin_Max {
	public void generaFile(String nomeFile) throws IOException {
		BufferedWriter bOut = new BufferedWriter(new FileWriter(nomeFile));
		Random r = new Random(); 
		for(int i=0; i<10; i++) {
			Integer n = r.nextInt(20);
			bOut.append(n.toString()); //scrive all'interno del file
			bOut.newLine();
		}
		bOut.close();
	}
	
	public ArrayList<Integer> leggiFile(String nomeFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
		ArrayList<Integer> linee = new ArrayList<Integer>();
		while(reader.ready()) {
			String linea = reader.readLine();
			linee.add(Integer.parseInt(linea));
		}
		reader.close();
		return linee;
	}//alla fine del metodo, le linee sono già convertite in interi
	
	public Integer calcolaMinimo(String nomeFile) throws IOException {
		ArrayList<Integer> numeri = leggiFile(nomeFile);
		Integer min = Collections.min(numeri);
		return min;
	}
	
	public Integer calcolaMassimo(String nomeFile) throws IOException {
		ArrayList<Integer> numeri = leggiFile(nomeFile);
		Integer max = Collections.max(numeri);
		return max;
	}
	
	public static void main(String[] args) {
		
		CalcoloMin_Max c = new CalcoloMin_Max();
		
		try { 
			c.generaFile("File.txt");
			Integer max = c.calcolaMassimo("File.txt");
			System.out.println(max);
			Integer min = c.calcolaMinimo("File.txt"); 
			System.out.println(min);
		} catch (IOException e) {
			System.out.println("Errore nell'interazione con il file");
		}
	}
}