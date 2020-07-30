package com.nttdata.caligiuri.universita;

import java.util.ArrayList;

public class Docente extends Persona{
	
	private String matricola;
	private double salario;
	private ArrayList <Esame> esami;
	private ArrayList <Studente> studenti;
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

	public ArrayList<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}

	public RuoloDocente getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloDocente ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esami == null) ? 0 : esami.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((studenti == null) ? 0 : studenti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		if (esami == null) {
			if (other.esami != null)
				return false;
		} else if (!esami.equals(other.esami))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		if (ruolo != other.ruolo)
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		if (studenti == null) {
			if (other.studenti != null)
				return false;
		} else if (!studenti.equals(other.studenti))
			return false;
		return true;
	}
	
}
