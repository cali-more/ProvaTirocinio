package com.nttdata.caligiuri.universita;

import java.util.ArrayList;

public class Studente extends Persona {

	private String matricola;
	private ArrayList <Corso> pianoDiStudi;
	private ArrayList <Esame> esami;

	public Studente(String nome, String cognome, String codiceFiscale, String matricola) {
		super(nome, cognome, codiceFiscale);
		this.matricola = matricola;
		this.esami = new ArrayList<Esame>();
		this.pianoDiStudi = new ArrayList<Corso>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public ArrayList<Esame> getEsami() {
		return esami;
	}

	public void setEsami(ArrayList<Esame> esami) {
		this.esami = esami;
	}

	public ArrayList <Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}

	public void setPianoDiStudi(ArrayList<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}

	public void addEsame(Esame esame) {
		if(cercaEsame(esame.getNome()) && esame.getVoto() >=18 && esame.getVoto() <=30)
			esami.add(esame);
	}

	//Controllo che esami non siano inseriti più volte
	public boolean cercaEsame(String nomeEsame) {
		for (Esame e : esami) {
			if (e.getNome().equals(nomeEsame))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esami == null) ? 0 : esami.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((pianoDiStudi == null) ? 0 : pianoDiStudi.hashCode());
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
		Studente other = (Studente) obj;
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
		if (pianoDiStudi == null) {
			if (other.pianoDiStudi != null)
				return false;
		} else if (!pianoDiStudi.equals(other.pianoDiStudi))
			return false;
		return true;
	}
}