package com.nttdata.caligiuri;

import java.util.ArrayList;
import java.util.List;

public class GestioneNegozio {

	private ArrayList<Prodotto> inventario = new ArrayList<Prodotto>();
	private ArrayList<Prodotto> listino = new ArrayList<Prodotto>();

	public boolean inserisciProdottoInInventario(Prodotto p) {
		if (!cercaProdotto(p.getCodice())) {
			inventario.add(p); 
			return true;
		} else
		return false; 
	}

	// metodo di supporto per cercare un prodotto all'interno dell'inventario
	public boolean cercaProdotto(int codice) {
		for (Prodotto p : inventario) {
			if (p.getCodice() == (codice)) {
				return true;
			}
		}
		return false;
	}

	// metodo di supporto check assemblato/non assemblato
	public boolean isAssemblato(Prodotto p) {
		if (p.getProdotti().size() > 0) {
			return true;
		} else
			return false;
	}

	public void aggiornaInventario(Ordine o) {
		for (Articolo a : o.getElencoArticoli()) {
			for (int i = 0; i < o.getElencoArticoli().size(); i++) {
				if (a.getCodiceProdotto() == o.getElencoArticoli().get(i).getCodiceProdotto()) {
					o.getElencoArticoli().get(i)
							.setQuantitaProdotto(o.getElencoArticoli().get(i).getQuantitaProdotto() + 1);
				}
			}
		}
	}

	public boolean prodottoDisponibile(int codice) { 
		for (Prodotto p : inventario) {
			if (p.getCodice() == (codice)) {
				if (isAssemblato(p)) {
					for (int i = 0; i < p.getProdotti().size(); i++) {
						if (p.getProdotti().get(i).getQuantita() == 0)
							return false;
					}
					return true;
				} else {
					if (p.getQuantita() > 0)
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}
	//da completare
	public List ordineMinimoCosto (Prodotto p) {
		List fornitori = new ArrayList ();
		if (!isAssemblato(p)) {
			System.out.println("null");
		return null;
		} else 
			
			//for(Fornitore f: )
			for (int i=0; i<p.getProdotti().size(); i++) {
				p.getProdotti().get(i).getCodice();
			}
		 
	System.out.println("Lista fornitori");
			return fornitori;
			
	}
}