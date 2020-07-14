package com.nttdata.caligiuri;

import java.util.ArrayList;

public class Negozio {
	
	private ArrayList <Prodotto> inventario;
	private ArrayList <Fornitore> elencoFornitori;

	public Negozio(ArrayList<Prodotto> inventario, ArrayList<Fornitore> elencoFornitori) {
		super();
		this.inventario = inventario;
		this.elencoFornitori = elencoFornitori;
	}

	public ArrayList<Prodotto> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Prodotto> inventario) {
		this.inventario = inventario;
	}

	public ArrayList<Fornitore> getElencoFornitori() {
		return elencoFornitori;
	}

	public void setElencoFornitori(ArrayList<Fornitore> elencoFornitori) {
		this.elencoFornitori = elencoFornitori;
	}
	

}
