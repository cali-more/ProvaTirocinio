package com.nttdata.caligiuri.universita;

import java.util.ArrayList;
import java.util.Date;

public class MainUniversita {

	public static void main(String[] args) {

		GestoreUniversita gunical = new GestoreUniversita();

		//Studenti
		Studente s1 = new Studente ("Giacomo", "Rossi", "RSSGCM80", "s1");
		Studente s2 = new Studente ("Morena", "Verdi", "CLGMRN87", "s2");
		Studente s3 = new Studente ("Sabrina", "Bianchi", "BNCSBN92", "s3");

		//Docenti
		Docente terracina = new Docente ("Giorgio", "Terracina", "TRRGRG75", "d01", 1000.00, RuoloDocente.ORDINARIO);
		Docente russo = new Docente ("Emilio", "Russo", "RSSEML79", "d02", 1200.00, RuoloDocente.RICERCATORE);
		Docente ferrari = new Docente ("Sonia", "Ferrari", "FRRSNO72", "d03", 1500.00, RuoloDocente.A_CONTRATTO);
		Docente dodaro = new Docente("Carmine", "Dodaro", "DDRCRM87", "d04", 500.00, RuoloDocente.A_CONTRATTO);
		Docente cariola = new Docente ("Alfio", "Cariola", "CRLALF62", "d05", 1800.00, RuoloDocente.ORDINARIO);

		//Corsi
		ArrayList <Corso> corso = new ArrayList <Corso>();
		Corso marketing = new Corso ("c01", "Marketing", 10, ferrari);
		Corso baseDiDati = new Corso ("c02", "Base Di Dati", 7, terracina);
		Corso matematica = new Corso ("c03", "Matematica", 9, russo);
		Corso programmazione = new Corso ("c04", "Programmazione Avanzata", 8, dodaro);
		Corso egi = new Corso ("c05", "Egi", 8, cariola);
		corso.add(marketing);
		corso.add(baseDiDati);
		corso.add(matematica);
		corso.add(programmazione);	
		corso.add(egi);


		//aggiunta corso a studente
		s1.setPianoDiStudi(corso);
		s2.setPianoDiStudi(corso);
		s3.setPianoDiStudi(corso);

		//Esami
		Esame e1 = new Esame("Marketing", 28, new Date(), marketing, ferrari);
		s1.addEsame(e1);
		
		Esame e2 = new Esame ("Matematica", 20, new Date(), matematica, russo);
		s1.addEsame(e2);
		
		Esame e3 = new Esame("Base Di Dati", 25, new Date(), baseDiDati, terracina);
		s1.addEsame(e3);
		
		Esame e4 = new Esame ("Programmazione Avanzata", 25, new Date(), programmazione, dodaro);
		s1.addEsame(e4);
		
		Esame e5 = new Esame ("Egi", 30, new Date(), egi, cariola);
		s1.addEsame(e5);
		
		
		Esame es1 = new Esame("Marketing", 26, new Date(), marketing, ferrari);
		s2.addEsame(es1);
		
		Esame es2 = new Esame ("Matematica", 30, new Date(), matematica, russo);
		s2.addEsame(es2);
		
		Esame es3 = new Esame("Base Di Dati", 22, new Date(), baseDiDati, terracina);
		s2.addEsame(es3);
		
		Esame es4 = new Esame ("Programmazione Avanzata", 30, new Date(), programmazione, dodaro);
		s2.addEsame(es4);
		s3.addEsame(es4);
		
		Esame es5 = new Esame ("Egi", 25, new Date(), egi, cariola);
//		s2.addEsame(es5);		
	
		//aggiungo Studenti ad Unical
		gunical.aggiungiStudente(s1);
		gunical.aggiungiStudente(s2);
		gunical.aggiungiStudente(s3);

		gunical.aggiungiCorso();
		System.out.println("CFU maturati da ogni studente: " + gunical.studentiCfuMaturati());
		System.out.println("Media di ogni studente: " + gunical.mediaStudente());
		System.out.println("Media Pesata di ogni studente: " + gunical.mediaStudentePesata());
		System.out.println("Elenco studenti con piano di studio completo: " + gunical.studentiTuttiEsamiSostenuti());
		System.out.println("Per ogni corso studenti con i migliori voti: " + gunical.corsoStudentiMigliori());
		System.out.println("Elenco corsi esami mai sostenuti: " + gunical.corsiEsamiMaiSostenuti());
		System.out.println("Studenti a cui manca esattamente un solo esame: " + gunical.studentiUnicoEsameMancante());
		System.out.println("Docenti che erogano voti alti: " + gunical.listaDocentiMediaAlta());
		System.out.println("Media di ogni corso: " + gunical.mediaCorso());
		System.out.println("Corsi più semplici: " + gunical.corsiPiuSemplici());
	}
}