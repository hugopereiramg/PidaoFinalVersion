package com.unicamp.mc322.lab10.pidao.servico.enuns;

public enum Nota {
	Uma(1), Duas(2), Três(3), Quatro(4), Cinco(5);
	
	public int valorNota;
	Nota(int valor) {
		valorNota = valor;
	}
	
	public int getNota() {
		return valorNota;
	}
	
}
