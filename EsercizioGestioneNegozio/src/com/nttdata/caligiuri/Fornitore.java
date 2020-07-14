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
}
