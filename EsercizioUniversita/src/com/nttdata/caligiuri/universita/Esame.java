package com.nttdata.caligiuri.universita;

import java.util.Date;

public class Esame {
	
	private String nome;
	private Integer voto;
	private Date data;
	private Corso corso;
	private Docente docente;
	
	public Esame(String nome, Integer voto, Date data, Corso corso, Docente docente) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
		this.corso = corso;
		this.docente = docente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVoto() {
		return voto;
	}
	public void setVoto(Integer voto) {
		this.voto = voto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Esame [nome=" + nome + ", docente=" + docente + "]";
	}
}