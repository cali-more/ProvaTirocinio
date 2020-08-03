package com.nttdata.caligiuri.universita;

import java.util.ArrayList;

public class Docente extends Persona {
	
	private String matricola;
	private double salario;
	private ArrayList <Esame> esami;
	private RuoloDocente ruolo;
	
		
	public Docente(String nome, String cognome, String codiceFiscale,
			String matricola, double salario, RuoloDocente ruolo) {
		super(nome, cognome, codiceFiscale);
		this.matricola = matricola;
		this.salario = salario;
		this.ruolo = ruolo;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ArrayList<Esame> getEsami() {
		return esami;
	}

	public void setEsami(ArrayList<Esame> esami) {
		this.esami = esami;
	}

	public RuoloDocente getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloDocente ruolo) {
		this.ruolo = ruolo;
	}
}