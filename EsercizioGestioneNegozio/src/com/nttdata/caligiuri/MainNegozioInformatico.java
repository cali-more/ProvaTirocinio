package com.nttdata.caligiuri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MainNegozioInformatico {
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		GestioneNegozio gn=new GestioneNegozio();
		ArrayList<Prodotto> prodotti= new ArrayList<Prodotto>();
		ArrayList<Articolo> articoli= new ArrayList<Articolo>();
		ArrayList<Articolo> articoli1= new ArrayList<Articolo>();
		ArrayList<Prodotto> prodotti1= new ArrayList<Prodotto>();
		
		// mi creo i prodotti per fare i test
		Prodotto p1= new Prodotto(01, "Mouse", 10.00, 3);
		Prodotto p2= new Prodotto(02, "Tastiera", 10.00, 1);
		Prodotto p3= new Prodotto(03, "Mouse", 10.00, 0);
		Prodotto p4= new Prodotto(04, "Mouse", 10.00, 2);
		
		//popolo l'arrayList prodotti1
		prodotti1.add(p1);
		prodotti1.add(p2);
		
		//creo un prodotto assemblato
		Prodotto p5= new Prodotto(05, "Notebook", prodotti1, 10.00, 2);
		
		// inserisco i prodotti nell'inventario funzionalita 1
		if(gn.inserisciProdottoInInventario(p1))
		System.out.println("Prodotto aggiunto");
		else 
			System.out.println("Prodotto esistente");
		if(gn.inserisciProdottoInInventario(p1))
			System.out.println("Prodotto aggiunto");
		else 
			System.out.println("Prodotto esistente");
		if(gn.inserisciProdottoInInventario(p3))
			System.out.println("Prodotto aggiunto");
		else 
			System.out.println("Prodotto esistente");
		if(gn.inserisciProdottoInInventario(p1))
			System.out.println("Prodotto aggiunto");
		else 
			System.out.println("Prodotto esistente");
		if(gn.inserisciProdottoInInventario(p5))
			System.out.println("Prodotto aggiunto");
		else 
			System.out.println("Prodotto esistente");
		
		//popolo l'arrayList prodotti
		prodotti.add(p1);
		prodotti.add(p2);
		
		//creo i fornitori
		Fornitore f1=new Fornitore(001,"Mario","via uno",prodotti);
		Fornitore f2=new Fornitore(002,"Maria","via due",prodotti1);
		
		
		//creo un articolo
	    Articolo a1= new Articolo(01, 10);
	    Articolo a2= new Articolo(02, 15);
	    
	    //popolo l'arrayList articoli
	    articoli.add(a1);
	    articoli.add(a2);

		//creo un ordine
		Ordine o1= new Ordine(f1, articoli);
		System.out.println("Prima  :"+articoli.get(0).getQuantitaProdotto());
		System.out.println("Prima  :"+articoli.get(1).getQuantitaProdotto());
		gn.aggiornaInventario(o1); //testo il la funzionalità per l'ordine o1
		System.out.println("Dopo  :"+articoli.get(0).getQuantitaProdotto());
		System.out.println("Dopo  :"+articoli.get(1).getQuantitaProdotto());

	//testo il la funzionalità per l'ordine o2
		articoli1.add(a1);
		Ordine o2= new Ordine(f1, articoli1);
		System.out.println("Prima  :"+articoli.get(0).getQuantitaProdotto());
		gn.aggiornaInventario(o2);
		System.out.println("Dopo  :"+articoli.get(0).getQuantitaProdotto());
				
   //testo il metodo di supporto per il prodotto p3
		 System.out.println("ass/NONass "+gn.isAssemblato(p3));
		 //testo la funzionalità 3 per il prodotto p3
     if(gn.prodottoDisponibile(p3.getCodice()))
    	 System.out.println("true");
     else
    	 System.out.println("false");
     
 
     System.out.println("ass/NONAss " +gn.isAssemblato(p5));
    if(gn.prodottoDisponibile(p5.getCodice()))
 	 System.out.println("true");
     else
    	 System.out.println("false");
    
    
    gn.ordineMinimoCosto(p5);
	}
}
