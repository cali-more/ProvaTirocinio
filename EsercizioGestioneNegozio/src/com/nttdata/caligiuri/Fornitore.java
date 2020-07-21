package com.nttdata.caligiuri;

import java.util.ArrayList;

public class Fornitore {
	private int codice;
	private String nome;
	private String indirizzo;
	private ArrayList<Prodotto> listino;
	
	public Fornitore(int codice, String nome, String indirizzo,
			ArrayList<Prodotto> listino) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.listino = listino;
	}

	public int getcodice() {
		return codice;
	}

	public void setcodice(int codice) {
		this.codice = codice;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getindirizzo() {
		return indirizzo;
	}

	public void setindirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public ArrayList<Prodotto> getListino() {
		return listino;
	}

	public void setListino(ArrayList<Prodotto> listino) {
		this.listino = listino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((listino == null) ? 0 : listino.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornitore other = (Fornitore) obj;
		if (codice != other.codice)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (listino == null) {
			if (other.listino != null)
				return false;
		} else if (!listino.equals(other.listino))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
