package com.nttdata.caligiuri.universita;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GestoreUniversita {

	private ArrayList<Studente> studenti = new ArrayList<Studente>();
	private ArrayList<Corso> corsi = new ArrayList<Corso>();

	DecimalFormat format = new DecimalFormat("###,##");
	
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
	public HashMap<Studente, Integer> studentiCfuMaturati () {
		HashMap<Studente, Integer> mapCfuMaturati = new HashMap<>();
		for (Studente s : studenti) {
			int sommaCfu = 0;
			for (Corso c : corsi) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if(s.getEsami().get(i).getNome().equals(c.getNome()))
						sommaCfu += c.getCfu();
				}
			}
			mapCfuMaturati.put(s,sommaCfu);
		}
		return mapCfuMaturati;
	}

	//non richiesta dalla traccia
	public HashMap<Studente, Double> mediaStudente() {
		HashMap<Studente, Double> mapMedia = new HashMap<>();
		for (Studente s : studenti) {
			Double somma = 0.0;
			Integer conta = 0;
			for (int i=0; i<s.getEsami().size(); i++) {
				somma += s.getEsami().get(i).getVoto();
				conta++;
			}
			if (conta != 0)
				mapMedia.put(s, somma/conta);
			else
				mapMedia.put(s, 0.0);
		}
		return mapMedia;
	}

	// 2. Per ogni studente la sua media pesata
	public HashMap<Studente, Double> mediaStudentePesata() {
		HashMap<Studente, Double> mapMediaPesata = new HashMap<>();
		for (Studente s : studenti) {
			Double numeratore = 0.0;
			Double denominatore = 0.0;
			for (Corso c : corsi) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if(s.getEsami().get(i).getNome().equals(c.getNome())) {
						numeratore += s.getEsami().get(i).getVoto() * c.getCfu();
						denominatore += c.getCfu();
					}
				}
				if (denominatore != 0)
					mapMediaPesata.put(s, Double.valueOf(format.format(numeratore/denominatore)));
				else
					mapMediaPesata.put(s, 0.0);
			}
		}
		return mapMediaPesata;
	}

	// 3. Elenco Studenti che hanno sostenuto tutti gli esami del piano di studi
	public ArrayList<Studente> studentiTuttiEsamiSostenuti() {
		ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
		for (Studente s : studenti) {
			if (s.getPianoDiStudi().size() == s.getEsami().size())
				listaStudenti.add(s);
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
	public HashMap<Corso, ArrayList <Studente>> corsoStudentiMigliori() {
		HashMap<Corso, ArrayList <Studente>> studentiMigliori = new HashMap<>();
		int voto = 0;
		ArrayList<Studente> studente; 
		for (Corso c : corsi) {
			voto = 0;
			studente = new ArrayList<Studente>();
			for (Studente s : studenti) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if (s.getEsami().get(i).getCorso().getNome().equals(c.getNome()) && s.getEsami().get(i).getVoto() > voto) {
						voto = s.getEsami().get(i).getVoto();
						studente.clear();
						studente.add(s);
					}
					else if (s.getEsami().get(i).getCorso().getNome().equals(c.getNome()) && s.getEsami().get(i).getVoto() == voto) {
						studente.add(s);;
					}
				}

			}
			studentiMigliori.put(c, studente);
		}
		return studentiMigliori;
	}

	// 1° supporto per il punto 5
	public List<Docente> aggiungiDc() {
		ArrayList<Docente> docenti = new ArrayList<Docente>();
		for (int i=0; i<studenti.size(); i++) {
			for (int j=0; j<studenti.get(i).getEsami().size(); j++) {
				if (!(docenti.contains(studenti.get(i).getEsami().get(j).getDocente())))
					docenti.add(studenti.get(i).getEsami().get(j).getDocente());
			}
		}
		return docenti;
	}

	// 2° supporto per il punto 5
	public HashMap<Docente, Double> ruoloDocentiVotiAlti() {
		ArrayList<Docente> docenti = new ArrayList<Docente>();
		double sommaEsami = 0.0;
		int conta = 0;
		Docente dc = null;
		HashMap<Docente, Double> mapDocenti = new HashMap<>();
		docenti.addAll(aggiungiDc());
		for (Docente d: docenti) {
			sommaEsami = 0.0;
			conta = 0;
			for (int i=0; i<studenti.size(); i++) {
				for (int j=0; j<studenti.get(i).getEsami().size(); j++) {
					if (studenti.get(i).getEsami().get(j).getDocente().getCognome() == d.getCognome()) {
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
	public HashMap<RuoloDocente, List <Docente>> listaDocentiMediaAlta() {
		HashMap<Docente, Double> mapDocenti = new HashMap<Docente, Double>();
		mapDocenti = (HashMap<Docente, Double>) ruoloDocentiVotiAlti();
		ArrayList<Docente> docenteMediaAlta;
		HashMap<RuoloDocente, List<Docente>> ruoloDocente = new HashMap<RuoloDocente, List<Docente>>();
		double voto = 0.0;
		for (RuoloDocente rd : RuoloDocente.values()) {
			docenteMediaAlta = new ArrayList<>();
			voto = 0.0;
			for (Entry<Docente, Double> entry : mapDocenti.entrySet()) {
				if (entry.getKey().getRuolo().equals(rd) && entry.getValue() > voto) {
					voto = entry.getValue();
					docenteMediaAlta.clear(); 
					docenteMediaAlta.add(entry.getKey());
				} else if (entry.getKey().getRuolo().equals(rd) && entry.getValue() == voto) { 
					docenteMediaAlta.add(entry.getKey());
				}
			}
			ruoloDocente.put(rd, docenteMediaAlta);
		}
		return ruoloDocente;
	}

	// 6. Lista dei corsi per i quali nessuno studente ha sostenuto l'esame
	public List<Corso> corsiEsamiMaiSostenuti() {
		List<Corso> corsiEsami = new ArrayList<>();
		if(studentiTuttiEsamiSostenuti().size()>0)
			return corsiEsami;
		boolean check = true;
		for (Corso c : corsi) {
			check = true;
			for (Studente s : studenti) {
				for (int i=0; i<s.getEsami().size(); i++) {
					if (s.getEsami().get(i).getNome().equals(c.getNome())) {
						check = false;
						break;
					}
				}
			}
			if (check)
				corsiEsami.add(c);
		}
		return corsiEsami;
	}

	//metoto di supporto punto 7
	public HashMap<Corso, Double> mediaCorso() {
		HashMap<Corso,Double> mediaCorso = new HashMap<Corso,Double>();
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
				mediaCorso.put(c,Double.valueOf(format.format(somma/conta)));
			else
				mediaCorso.put(c, 0.0);
		}
		return mediaCorso;
	}

	// 7. Lista dei corsi più semplici, ovvero per i quali la media voto è la più alta
	public List<Corso> corsiPiuSemplici() {
		HashMap<Corso, Double> mediaCorso = new HashMap<Corso, Double>();
		mediaCorso = (HashMap<Corso, Double>) mediaCorso();
		List<Corso> corsiSemplici = new ArrayList<>();
		Double voto = 0.0;
		for (Entry<Corso, Double> entry : mediaCorso.entrySet()) {
			if(entry.getValue()>voto) {
				voto = entry.getValue();
				corsiSemplici.clear();
				corsiSemplici.add(entry.getKey());
			}
			else 
				if (entry.getValue() == voto) {
					corsiSemplici.add( entry.getKey());
				}
		}
		return corsiSemplici;
	}

	// 1° metodo di supporto punto 8
	public List<Corso> aggiungiPS(Studente s) {
		ArrayList<Corso> pianoDiStudi = new ArrayList<Corso>();
		for (int i=0; i<s.getPianoDiStudi().size(); i++) {
			pianoDiStudi.add(s.getPianoDiStudi().get(i));
		}
		return pianoDiStudi;
	}

	// 2° metodo di supporto punto 8
	public List<Corso> aggiungiEsami(Studente s) {
		ArrayList<Corso> esami = new ArrayList<Corso>();
		for (int i=0; i<s.getEsami().size(); i++) {
			esami.add(s.getEsami().get(i).getCorso());
		}
		return esami;
	}
	
	// 8. Le matricole degli studenti a cui manca esattamente un esame, e l'esame mancante
	public HashMap<Studente, Corso> studentiUnicoEsameMancante() {
		HashMap<Studente, Corso> matricola = new HashMap<Studente, Corso>();
		for (Studente s : studenti) {
			ArrayList<Corso> pianoDiStudi = new ArrayList<Corso>();
			ArrayList<Corso> esami = new ArrayList<Corso>();
			if (s.getPianoDiStudi().size() - s.getEsami().size() == 1) { 
				pianoDiStudi.addAll(aggiungiPS(s));
				esami.addAll(aggiungiEsami(s));
				pianoDiStudi.removeAll(esami);
				matricola.put(s, pianoDiStudi.get(0));
			}
		}
		return matricola;
	}
}