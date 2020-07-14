package com.nttdata.caligiuri;

import java.util.ArrayList;

public class GestioneNegozio {

	private ArrayList<Prodotto> inventario = new ArrayList<Prodotto>();

	public boolean inserisciProdottoInInventario(Prodotto p) {
		if (!cercaProdotto(p.getCodice())) {
			inventario.add(p); //aggiunge il prodotto
			return true;
		} else
		return false; //prodotto esistente
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
					for (int i = 0; i < p.prodotti.size(); i++) {
						if (p.prodotti.get(i).getQuantita() == 0)
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
}