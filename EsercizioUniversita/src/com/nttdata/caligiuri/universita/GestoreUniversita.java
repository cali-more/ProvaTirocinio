package com.nttdata.caligiuri.universita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GestoreUniversita {

	private ArrayList<Studente> studenti = new ArrayList<Studente>();
	private ArrayList<Corso> corsi = new ArrayList<Corso>();

	public void aggiungiStudente(Studente s) {
		if (cercaStudente(s.getMatricola()))
			studenti.add(s);
	}

	// metodo di supporto
	public boolean cercaStudente(String matricola) {
		for (Studente s : studenti) {
			if (s.getMatricola().equals(matricola))
				return false;
		}
		return true;
	}

	// 1. Per ogni studente il numero di CFU maturati
	public ArrayList<String> studentiCfuMaturati() {
		ArrayList<String> cfu = new ArrayList<String>();
		for (Studente s : studenti) {
			int sommaCfu = 0;
			for (int i=0; i<s.getEsami().size(); i++) {
				for (int j=0; j<s.getPianoDiStudi().size(); j++)
					if(s.getEsami().get(i).getNome().equals(s.getPianoDiStudi().get(j).getNome()))
					sommaCfu += s.getPianoDiStudi().get(j).getCfu();
		}
			cfu.add("Matricola:" + s.getMatricola() + "  CFU:" + sommaCfu);
		}
		return cfu;
	}

	//non richiesta dalla traccia
	public ArrayList<String> mediaStudente() {
		ArrayList<String> media = new ArrayList<String>();
		for (Studente s : studenti) {
			Double somma = 0.0;
			Integer conta = 0;
			for (int i=0; i<s.getEsami().size(); i++) {
				somma += s.getEsami().get(i).getVoto();
				conta++;
			}
			if (conta != 0)
				media.add("Matricola:" + s.getMatricola() + " Media:" + (somma/conta));
			else
				media.add("Matricola:" + s.getMatricola() + " Media:" + 0);
		}
		return media;
	}

	// 2. Per ogni studente la sua media pesata
	public ArrayList<String> mediaStudentePesata() {
		ArrayList<String> mediaPesata = new ArrayList<String>();
		for (Studente s : studenti) {
			float numeratore = 0;
			float denominatore = 0;
			for (int i=0; i<s.getEsami().size(); i++) {
				for (int j=0; j<s.getPianoDiStudi().size(); j++)
					if(s.getEsami().get(i).getNome().equals(s.getPianoDiStudi().get(j).getNome())) {
				numeratore += s.getEsami().get(i).getVoto() * s.getPianoDiStudi().get(j).getCfu();
				denominatore += s.getPianoDiStudi().get(j).getCfu();
					}
			}
			if (denominatore != 0)
				mediaPesata.add("Matricola:" + s.getMatricola() + " Media:" + (numeratore/denominatore));
			else
				mediaPesata.add("Matricola:" + s.getMatricola() + " Media:" + 0);
		}
		return mediaPesata;
	}

	// 3. Elenco Studenti che hanno sostenuto tutti gli esami del piano di studi
	public ArrayList<String> studentiTuttiEsamiSostenuti() {
		ArrayList<String> listaStudenti = new ArrayList<String>();
		for (Studente s : studenti) {
			if (s.getPianoDiStudi().size() == s.getEsami().size())
				listaStudenti.add("Matricola:" + s.getMatricola());
		}
		return listaStudenti;
	}
	
	// metodo di supporto per il 4° punto
	public List<Corso> aggiungiCorso() {
		for (Studente s : studenti) {
			for (int i=0; i<s.getPianoDiStudi().size(); i++) {
				if (!(corsi.contains(s.getPianoDiStudi().get(i))))
					corsi.add(s.getPianoDiStudi().get(i));
			}
		}
		return corsi;
	}

	// 4. Per ogni corso gli studenti con i migliori voti
	public List<String> corsoStudentiMigliori() {
		int voto = 0;
		List<String> studentiMigliori = new ArrayList<>();
		List<String> matricola = new ArrayList<>();
		for (Corso c : corsi) {
			voto = 0;
			matricola.clear();
			for (Studente s : studenti) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if (s.getEsami().get(i).getCorso().getNome().equals(c.getNome()) && s.getEsami().get(i).getVoto() > voto) {
						voto = s.getEsami().get(i).getVoto();
						matricola.clear();
						matricola.add(s.getMatricola());
					}
					else if (s.getEsami().get(i).getCorso().getNome().equals(c.getNome()) && s.getEsami().get(i).getVoto() == voto) {
						matricola.add(s.getMatricola());
					}
				}
			}
			studentiMigliori.add(matricola+" "+c.getNome());
		}
		return studentiMigliori;
	}

	// 1° supporto per il punto 5
	public List<String> aggiungiDc() {
		ArrayList<String> docenti = new ArrayList<String>();
		for (int i=0; i<studenti.size(); i++) {
			for (int j=0; j<studenti.get(i).getEsami().size(); j++) {
				if (!(docenti.contains(studenti.get(i).getEsami().get(j).getDocente().getCognome())))
					docenti.add(studenti.get(i).getEsami().get(j).getDocente().getCognome());
			}
		}
		return docenti;
	}
	
	// 2° supporto per il punto 5
	public HashMap<Docente, Double> ruoloDocentiVotiAlti() {
		ArrayList<String> docenti = new ArrayList<String>();
		double sommaEsami = 0.0;
		int conta = 0;
		Docente dc = null;
		HashMap<Docente, Double> mapDocenti = new HashMap<>();
		docenti.addAll(aggiungiDc());
		for (String d: docenti) {
			sommaEsami = 0.0;
			conta = 0;
			for (int i=0; i<studenti.size(); i++) {
				for (int j=0; j<studenti.get(i).getEsami().size(); j++) {
					if (studenti.get(i).getEsami().get(j).getDocente().getCognome() == d) {
						sommaEsami += studenti.get(i).getEsami().get(j).getVoto();
						dc=studenti.get(i).getEsami().get(j).getDocente();
						conta++;
					}
				}
			}  
			mapDocenti.put(dc, sommaEsami/conta);
		}
		return mapDocenti;
	}

	// 5. Per ogni ruolo, il docente che mediamente eroga i voti più alti
	public List<String> listaDocentiMediaAlta() {
		HashMap<Docente, Double> mapDocenti = new HashMap<Docente, Double>();
		mapDocenti = (HashMap<Docente, Double>) ruoloDocentiVotiAlti().clone();
		ArrayList<String> mediAlta = new ArrayList<>();
		ArrayList<String> ruoloDocente = new ArrayList<>();
		double voto = 0.0;
		for (RuoloDocente rd : RuoloDocente.values()) {
			mediAlta.clear();
			voto = 0.0;
			for (Entry<Docente, Double> entry : mapDocenti.entrySet()) {
				if (entry.getKey().getRuolo().equals(rd) && entry.getValue() > voto) {
					voto = entry.getValue();
					mediAlta.clear(); 
					mediAlta.add(entry.getKey().getRuolo()+" "+entry.getKey().getCognome() + " " + voto);
				}
			}
			ruoloDocente.addAll(mediAlta);
		}
		return ruoloDocente;
	}

	// 6. Lista dei corsi per i quali nessuno studente ha sostenuto l'esame
	public List<String> corsiEsamiMaiSostenuti() {
		List<String> corsiEsami = new ArrayList<>();
		if(studentiTuttiEsamiSostenuti().size()>0)
			return corsiEsami;
		boolean check = false;
		for (Corso c : corsi) {
			check = false;
			for (Studente s : studenti) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if (s.getEsami().get(i).getNome().equals(c.getNome())) {
						check = true;
						break;
					}
				}
			}
			if (check == false)
				corsiEsami.add(c.getNome());
		}
		return corsiEsami;
	}

	//metoto di supporto punto 7
	public HashMap<String, Double> mediaCorso() {
		HashMap<String,Double> mediaCorso = new HashMap<String,Double>();
		for (Corso c : corsi) {
			Double somma = 0.0;
			Integer conta = 0;
			for (Studente s : studenti){
				for (int i=0; i<s.getEsami().size(); i++) {
					if (s.getEsami().get(i).getNome().equals(c.getNome())) {
						somma += s.getEsami().get(i).getVoto();
						conta++;
					}
				}
			} 
			if (conta != 0)
				mediaCorso.put(c.getNome(),(somma/conta));
			else
				mediaCorso.put(c.getNome(), 0.0);
		}
		return mediaCorso;
	}

	// 7. Lista dei corsi più semplici, ovvero per i quali la media voto è la più alta
	public List<String> corsiPiuSemplici() {
		HashMap<String, Double> mediaCorso = new HashMap<String, Double>();
		mediaCorso = (HashMap<String, Double>) mediaCorso().clone();
		ArrayList< String> corsiSemplici = new ArrayList<>();
		double voto = 0.0;
		for (Entry<String, Double> entry : mediaCorso.entrySet()) {
			if(entry.getValue()>voto) {
				voto = entry.getValue();
				corsiSemplici.clear();
				corsiSemplici.add( entry.getKey()+" "+voto);
			}
			else 
				if (entry.getValue() == voto) {
					voto=entry.getValue();
					corsiSemplici.add( entry.getKey()+" "+voto);
				}
		}
		return corsiSemplici;
	}

	// 1° metodo di supporto punto 8
	public List<String> aggiungiPS(Studente s) {
		ArrayList<String> pianoDiStudi = new ArrayList<String>();
		for (int i=0; i<s.getPianoDiStudi().size(); i++) {
			pianoDiStudi.add(s.getPianoDiStudi().get(i).getNome());
		}
		return pianoDiStudi;
	}

	// 2° metodo di supporto punto 8
	public List<String> aggiungiEsami(Studente s) {
		ArrayList<String> esami = new ArrayList<String>();
		for (int i=0; i<s.getEsami().size(); i++) {
			esami.add(s.getEsami().get(i).getNome());
		}
		return esami;
	}

	// 8. Le matricole degli studenti a cui manca esattamente un esame, e l'esame mancante
	public List<String> studentiUnicoEsameMancante() {
		List<String> matricola = new ArrayList<String>();
		for (Studente s : studenti) {
			ArrayList<String> pianoDiStudi = new ArrayList<String>();
			ArrayList<String> esami = new ArrayList<String>();
			if (s.getPianoDiStudi().size() - s.getEsami().size() == 1) { 
				pianoDiStudi.addAll(aggiungiPS(s));
				esami.addAll(aggiungiEsami(s));
				pianoDiStudi.removeAll(esami);
				matricola.add(s.getMatricola() + " " + pianoDiStudi);
			}
		}
		return matricola;
	}
}
