package com.nttdata.caligiuri;

import java.util.ArrayList;
import java.util.List;

public class GestioneNegozio {

	private ArrayList<Prodotto> inventario = new ArrayList<Prodotto>();
	private ArrayList<Fornitore> elencoFornitori = new ArrayList<Fornitore>();

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
	//aggiorno la coppia p q nell'ordine
	public void aggiornaInventario(Ordine o) {
		for (int j=0; j<inventario.size(); j++) {
			for (int i = 0; i<o.getElencoArticoli().size(); i++) {
				if (inventario.get(j).getCodice() == o.getElencoArticoli().get(i).getCodiceProdotto()) {
					o.getElencoArticoli().get(i)
					.setQuantitaProdotto(o.getElencoArticoli().get(i).getQuantitaProdotto()+1);
				}
			}
		}
	}

	// metodo di supporto check assemblato/non assemblato
	public boolean isAssemblato(Prodotto p) {
		if (p.getProdotti().size() > 0) {
			return true;
		} else
			return false;
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

	//aggiungo una lista di Fornitori al Negozio
	public void aggiungiFornitori(Negozio n) {
		for (int i=0; i<n.getElencoFornitori().size(); i++)
			elencoFornitori.add(n.getElencoFornitori().get(i));
	}

	//recupero il fornitore dal prezzo minimo
	public int cercoFornitorePrezzoMinimo(int codice) {
		int codiceFornitore=0;
		double prezzo = Double.MAX_VALUE;
		for (int i=0; i<elencoFornitori.size(); i++) {
			for (int j=0; j<elencoFornitori.get(i).getListino().size(); j++)
				if (elencoFornitori.get(i).getListino().get(j).getCodice() == codice
				&& elencoFornitori.get(i).getListino().get(j).getPrezzo() < prezzo) {
					prezzo = elencoFornitori.get(i).getListino().get(j).getPrezzo();
					codiceFornitore = elencoFornitori.get(i).getcodice();
				}
		}
		return codiceFornitore;
	}

	public List<Integer> ordineMinimoCosto(Prodotto p) {
		List<Integer> listaFornitori = new ArrayList<Integer>();
		if (!isAssemblato(p)) {
			return null;
		} else
			for (int i=0; i<p.getProdotti().size(); i++) {
				if (!listaFornitori.contains(cercoFornitorePrezzoMinimo(p.getProdotti().get(i).getCodice())))
				listaFornitori.add(cercoFornitorePrezzoMinimo(p.getProdotti().get(i).getCodice()));
			}
		return listaFornitori;
	}
	
	public List<String> ordineMinimoCostoVariante(Prodotto p) {
		List<String> listaFornitori = new ArrayList<String>();
		if (!isAssemblato(p)) {
			return null;
		} else
			for (int i=0; i<p.getProdotti().size(); i++) {
				if (!listaFornitori.contains(cercoFornitorePrezzoMinimo(p.getProdotti().get(i).getCodice())))
				listaFornitori.add("F"+cercoFornitorePrezzoMinimo(p.getProdotti().get(i).getCodice())+"  "+(p.getProdotti().get(i).getNome()));
	
			}
		return listaFornitori;
	}
}