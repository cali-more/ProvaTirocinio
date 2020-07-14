package com.nttdata.caligiuri;

public class Articolo {

	private int codiceProdotto;
	private int quantitaProdotto;

	public Articolo(int codiceProdotto, int quantitaProdotto) {
		super();
		this.codiceProdotto = codiceProdotto;
		this.quantitaProdotto = quantitaProdotto;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public int getQuantitaProdotto() {
		return quantitaProdotto;
	}

	public void setQuantitaProdotto(int quantitaProdotto) {
		this.quantitaProdotto = quantitaProdotto;
	}
}
