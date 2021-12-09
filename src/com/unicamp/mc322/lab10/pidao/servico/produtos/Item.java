package com.unicamp.mc322.lab10.pidao.servico.produtos;

import com.unicamp.mc322.lab10.pidao.servico.Servico;
import com.unicamp.mc322.lab10.pidao.servico.enuns.TipoDesconto;

public class Item extends Servico{
	private double preco;
	private String identificador;
	private double precoAtual;
	

	public Item(String nome, String identificador, double preco) {
		super(nome, identificador);
		this.identificador = identificador;
		this.preco = preco;
		this.precoAtual = preco;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setPrecoComDesconto(double desconto, TipoDesconto porcentagem) {
		switch (porcentagem) {
			case PORCENTAGEM:
			this.precoAtual = this.preco - (this.preco * (desconto/100));
				break;
				
			case VALORFIXO:
			this.precoAtual = this.preco - desconto;
				break;
				
			default:
				break;
		}
	}
	

	
	public void removerDesconto() {
		this.precoAtual = this.preco;
	}

	public double getPrecoDoLanche() {
		return this.precoAtual;
	}

}
