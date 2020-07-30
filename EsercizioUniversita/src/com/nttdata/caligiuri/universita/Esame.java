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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((voto == null) ? 0 : voto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (voto == null) {
			if (other.voto != null)
				return false;
		} else if (!voto.equals(other.voto))
			return false;
		return true;
	}
}