package com.nttdata.caligiuri;

import java.util.ArrayList;

public class MainNegozioInformatico {
	
	public static void main(String[] args) {
		
		GestioneNegozio gn=new GestioneNegozio();
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		ArrayList<Articolo> articoli = new ArrayList<Articolo>();
		ArrayList<Articolo> articoli1 = new ArrayList<Articolo>();
		ArrayList<Prodotto> prodotti1 = new ArrayList<Prodotto>();
		ArrayList<Fornitore> fornitori = new ArrayList<Fornitore>();
		
		//creo i prodotti per fare i test
		Prodotto p1= new Prodotto(01, "Mouse", 11.00, 3);
		Prodotto p2= new Prodotto(02, "Tastiera", 25.00, 1);
		Prodotto p3= new Prodotto(03, "HDD", 5.00, 5);
		
		Prodotto p4= new Prodotto(01, "Mouse", 05.00, 2);
		Prodotto p6= new Prodotto(02, "Tastiera", 13.00, 2);
		Prodotto p7= new Prodotto(03, "HDD", 10.00, 2);
		
		//popolo l'arrayList prodotti1
		prodotti1.add(p4);
		prodotti1.add(p6);
		prodotti1.add(p7);
		
		
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
		prodotti.add(p3);
		
		//creo i fornitori
		Fornitore f1=new Fornitore(001,"Mario","via uno",prodotti);
		Fornitore f2=new Fornitore(002,"Maria","via due",prodotti1);
		fornitori.add(f2);
		fornitori.add(f1);
		
		//creo un articolo
	    Articolo a1= new Articolo(02, 10);
	    Articolo a2= new Articolo(05, 15);
	    Articolo a3= new Articolo(01, 20);
	    
	    //popolo l'arrayList articoli
	    articoli.add(a1);
	    articoli.add(a2);
	    articoli.add(a3);

		//creo un ordine
		Ordine o1= new Ordine(f1, articoli);
		System.out.println("Prima  :"+articoli.get(0).getQuantitaProdotto());
		System.out.println("Prima  :"+articoli.get(1).getQuantitaProdotto());
		System.out.println("Prima  :"+articoli.get(2).getQuantitaProdotto());
		
		gn.aggiornaInventario(o1); //testo il la funzionalit� per l'ordine o1
		System.out.println("Dopo  :"+articoli.get(0).getQuantitaProdotto());
		System.out.println("Dopo  :"+articoli.get(1).getQuantitaProdotto());
		System.out.println("Dopo  :"+articoli.get(2).getQuantitaProdotto());

	//testo il la funzionalit� per l'ordine o2
		articoli1.add(a1);
		Ordine o2= new Ordine(f1, articoli1);
		//System.out.println("Prima  :"+articoli.get(0).getQuantitaProdotto());
		gn.aggiornaInventario(o2);
		//System.out.println("Dopo  :"+articoli.get(0).getQuantitaProdotto());
				
   //testo il metodo di supporto per il prodotto p3
		 System.out.println("ass/NONass "+gn.isAssemblato(p3));
		 //testo la funzionalit� 3 per il prodotto p3
     if(gn.prodottoDisponibile(p3.getCodice()))
    	 System.out.println("true");
     else
    	 System.out.println("false");
     
 
     System.out.println("ass/NONAss " +gn.isAssemblato(p5));
    if(gn.prodottoDisponibile(p5.getCodice()))
 	 System.out.println("true");
     else
    	 System.out.println("false");
    
    Negozio n = new Negozio(prodotti1, fornitori);
    
    gn.aggiungiFornitori(n);
    
    System.out.println("Output ordineMinimoCosto: "+ gn.ordineMinimoCosto(p5));
    
    System.out.println("Output ordineMinimoCostoVariante: "+ gn.ordineMinimoCostoVariante(p5));
	}
}
