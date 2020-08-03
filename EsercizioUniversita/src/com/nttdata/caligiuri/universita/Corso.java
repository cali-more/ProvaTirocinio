package com.nttdata.caligiuri.universita;

public class Corso {
	
	private String codice;
	private String nome;
	private Integer cfu;
	private Docente docente;

	public Corso(String codice, String nome, Integer cfu, Docente docente) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.cfu = cfu;
		this.docente = docente;
	}
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCfu() {
		return cfu;
	}
	
	public void setCfu(Integer cfu) {
		this.cfu = cfu;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + nome + "]";
	}
}