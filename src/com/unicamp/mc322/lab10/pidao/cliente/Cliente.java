package com.unicamp.mc322.lab10.pidao.cliente;

import java.lang.Math;

public class Cliente {
	private String nome;
	private String cpf;
	private int[] endereco;
	private int numeroDePedidos;
	
	public Cliente(String nome, String cpf, int x, int y) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = new int[2];
		this.endereco[0] = x;
		this.endereco[1] = y;
		this.numeroDePedidos = 0;
	}
	
	public int getNumeroDePedidos() {
		return this.numeroDePedidos;
	}

	public void addPedido() {
		this.numeroDePedidos = this.numeroDePedidos + 1;
	}
	
	public void cancelaPedido() {
		this.numeroDePedidos = this.numeroDePedidos - 1;
	}
	
	public int calcularDistancia(int x, int y) {
		int distancia =(int) Math.sqrt(Math.pow(this.endereco[0] - x, 2) + Math.pow(this.endereco[1] - y, 2));
		return distancia;
	}
	
	public String getNome() {
		return this.nome;
	}

}
