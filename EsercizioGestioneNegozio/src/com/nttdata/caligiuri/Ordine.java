package com.nttdata.caligiuri;

import java.util.ArrayList;

public class Ordine {
	private Fornitore fornitore;
	private ArrayList<Articolo> elencoArticoli;
	
	public Ordine(Fornitore fornitore, ArrayList<Articolo> elencoArticoli) {
		super();
		this.fornitore = fornitore;
		this.elencoArticoli = elencoArticoli;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	public ArrayList<Articolo> getElencoArticoli() {
		return elencoArticoli;
	}

	public void setElencoArticolo(ArrayList<Articolo> elencoArticoli) {
		this.elencoArticoli = elencoArticoli;
	}

}
