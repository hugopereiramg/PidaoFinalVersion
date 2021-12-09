package com.unicamp.mc322.lab10.pidao.servico.produtos;

import com.unicamp.mc322.lab10.pidao.servico.Servico;

public class Entregador extends Servico{
	private boolean proximo;
	
	
	public Entregador (String nome, String cpf) {
		super(nome, cpf);
		this.proximo = true;
	}
	
	public void setProximo(boolean proximo) {
		this.proximo = proximo;
	}
	
	public boolean getProximo() {
		return this.proximo;
	}	

}
