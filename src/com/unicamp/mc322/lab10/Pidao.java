package com.unicamp.mc322.lab10;

import java.util.ArrayList;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.enuns.Nota;
import com.unicamp.mc322.lab10.pidao.servico.enuns.TipoDesconto;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Entregador;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Item;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Pedido;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Restaurante;

public class Pidao {
	private static Pidao pd;
	private ArrayList<Restaurante> restaurantes;
	
	private Pidao() {
		this.restaurantes = new ArrayList<Restaurante>();
	}
	
	public static Pidao getInstance() {
		if(pd == null ) {
			pd = new Pidao();
		}
		return pd;
	}
	
	public void imprimirPedidos() {
		System.out.println("------------------------------------------------------");
		System.out.println("Resumo dos pedidos");
		for(Restaurante restaurante:this.restaurantes) {
			restaurante.imprimirPedidos();
		}
		System.out.println("------------------------------------------------------");
		System.out.println(" ");
	}
	
	public void addRestaurante(String nome, String cnpj, int x, int y) {
		Restaurante restaurante = new Restaurante(nome, cnpj, x , y);
		this.restaurantes.add(restaurante);
	}
	
	private Restaurante pegarRestaurantePorCNPJ(String cnpj) {
		for(int i = 0; i < this.restaurantes.size(); i++) {
			if (this.restaurantes.get(i).getCNPJ().equals(cnpj)) {
				return this.restaurantes.get(i);
			}
		}
		return null;
	}
	
	public void addItem(String cnpj, String nome, String identificador, double preco) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		Item item = new Item(nome, identificador, preco);
		restaurante.adicionarAoCardapio(item);
	}
	
	public void addDesconto(String cnpj, String identificador, double desconto, TipoDesconto porcentagem) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.addDescontoNoItem(identificador, desconto, porcentagem);
	}
	
	public void imprimirCardapio(String cnpj) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.imprimirCardapio();
	}

	public void tirarDesconto(String cnpj, String identificador) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.tirarDescontoNoItem(identificador);
	}

	public void incluirEntregador(String cnpj, Entregador entregador) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.addEntregador(entregador);		
	}

	public void avaliarRestaurante(String cnpj, Cliente cliente, Nota nota, String comentario) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.addAvaliacao(cliente, nota, comentario);		
	}
	
	public void avaliarRestaurante(String cnpj, Cliente cliente, Nota nota) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.addAvaliacao(cliente, nota);		
	}
	
	public void imprimirAvaliacoes(String cnpj) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.imprimirAvaliacoes();
	}

	public void criarPedido(String cnpj, Cliente cliente, boolean entrega) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.fazerPedido(cliente, entrega);
	}

	public void inserirItemNoPedido(String cnpj, int i, String item) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.adicionarItem(i, item);
	}

	public void concluirPedido(String cnpj, int i) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.concluirPedido(i);
	}

	public void avaliarItem(String cnpj, String identificador, Cliente cliente, Nota nota) {
		Restaurante restaurante = this.pegarRestaurantePorCNPJ(cnpj);
		restaurante.addAvaliacaoDoItem(cliente, identificador, nota);
	}


}
