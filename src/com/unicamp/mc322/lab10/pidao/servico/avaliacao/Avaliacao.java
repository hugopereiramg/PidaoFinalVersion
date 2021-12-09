package com.unicamp.mc322.lab10.pidao.servico.avaliacao;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.enuns.Nota;

public class Avaliacao {
	private Cliente cliente;
	private int nota;
	private String comentario;
	
	public Avaliacao(Cliente cliente, Nota nota, String comentario) {
		this.cliente = cliente;
		this.nota = nota.getNota();
		this.comentario = comentario;
	}
	
	public Avaliacao(Cliente cliente, Nota nota) {
		this.cliente = cliente;
		this.nota = nota.getNota();
		this.comentario = null;
	}
	
	public int getNota() {
		return this.nota;
	}

}
