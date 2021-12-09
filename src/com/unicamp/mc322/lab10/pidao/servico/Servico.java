package com.unicamp.mc322.lab10.pidao.servico;

import java.util.ArrayList;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.avaliacao.Avaliacao;
import com.unicamp.mc322.lab10.pidao.servico.enuns.Nota;

public abstract class Servico {
	protected String nome;
	protected String identificador;
	private ArrayList<Avaliacao> avaliacoes;
	
	public Servico(String nome, String identificador) {
		this.nome = nome;
		this.identificador = identificador;
		this.avaliacoes = new ArrayList<Avaliacao>();
	}
	
	public String obterMediaDasAvaliacoes() {
		double soma = 0;
		if(this.avaliacoes.size() > 0) {
			for(Avaliacao avaliacao1: this.avaliacoes) {
				soma =  soma + avaliacao1.getNota();
			}
		}else {
			return "Sem notas";
		}
		
		String str = Math.round((soma / this.avaliacoes.size())*100.0)/100.0 +"";
		return str;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addAvaliacao(Cliente cliente, Nota nota, String comentario) {
		Avaliacao avaliacao = new Avaliacao(cliente, nota, comentario);
		this.avaliacoes.add(avaliacao);				
	}
	
	public void addAvaliacao(Cliente cliente, Nota nota) {
		Avaliacao avaliacao = new Avaliacao(cliente, nota);
		this.avaliacoes.add(avaliacao);				
	}
	
	public void imprimirAvaliacao() {
		System.out.println("A media de " + this.nome + " foi " + this.obterMediaDasAvaliacoes());
	}

}
