package com.nttdata.caligiuri;

import java.util.ArrayList;

public class Prodotto {

	private int codice;
	private String nome;
	private ArrayList<Prodotto> prodotti;
	private double prezzo;
	private int quantita;
	
	//costruttore per prodotto assemblato
	public Prodotto(int codice, String nome, ArrayList<Prodotto> prodotti,double prezzo, int quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		this.prodotti = prodotti;
		this.quantita = quantita;
	}
	//costruttore per prodotto componente
	public Prodotto(int codice, String nome,double prezzo, int quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.prodotti = new ArrayList<Prodotto>();
	}
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}

