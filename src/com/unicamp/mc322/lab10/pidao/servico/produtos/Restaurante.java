package com.unicamp.mc322.lab10.pidao.servico.produtos;
import java.util.ArrayList;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.Servico;
import com.unicamp.mc322.lab10.pidao.servico.enuns.Nota;
import com.unicamp.mc322.lab10.pidao.servico.enuns.TipoDesconto;


public class Restaurante extends Servico{
	private int[] endereco;
	private ArrayList<Item> cardapio;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Entregador> entregadores;
	
	
	public Restaurante(String nome, String cnpj, int x, int y) {
		super(nome, cnpj);
		this.endereco = new int[2];
		this.endereco[0] = x;
		this.endereco[1] = y;
		this.cardapio = new ArrayList<Item>();
		this.pedidos = new ArrayList<Pedido>();
		this.entregadores = new ArrayList<Entregador>();
	}
	
	public void adicionarAoCardapio(Item novo) {
		this.cardapio.add(novo);
	}
	
	public void removerDoCardapio(String identificador) {
		for(int i = 0; i > this.cardapio.size(); i++) {
			if(this.cardapio.get(i).getIdentificador().equals(identificador)) {
				this.cardapio.remove(i);
			}
		}
	}
	
	
	public void fazerPedido(Cliente cliente, boolean entrega) {
		Pedido pedido = new Pedido(cliente, entrega);
		pedido.setNumeroDoPedido(this.pedidos.size() + 1);
		pedido.getCliente().addPedido();
		if(pedido.getEntrega()) {
			pedido.adicionarValorEntrega(this.endereco[0], this.endereco[1]);
		}
		this.pedidos.add(pedido);
	}
	
	
	private void alocarEntregador(Pedido pedido) {
		int i = 0;
		while(!this.entregadores.get(i).getProximo()) {
			i = i+1;
		}
		pedido.setEntregador(this.entregadores.get(i));
		this.entregadores.get(i).setProximo(false);
		if(i+1 == this.entregadores.size()) {
			this.entregadores.get(0).setProximo(true);
		}else {
			this.entregadores.get(i + 1).setProximo(true);
		}
	}
	
	public void addEntregador(Entregador entregador) {
		this.entregadores.add(entregador);
	}
	
	
	public void imprimirAvaliacoes() {
		System.out.println("Avaliação do restaurante " + this.nome + " : " + this.obterMediaDasAvaliacoes());
		System.out.println("Avaliações dos itens do cardápio:");
		for(Item item:this.cardapio) {
			System.out.println(item.getNome() + " - avaliação: " + item.obterMediaDasAvaliacoes() + ";");
		}
		System.out.println("Avaliações dos entregadores: ");
		for(Entregador entregador:this.entregadores) {
			System.out.println(entregador.getNome() + " - avaliação: " + entregador.obterMediaDasAvaliacoes());
		}
		System.out.println(" ");
	}
	
	public void imprimirCardapio() {
		System.out.println("Cardápio do restaurante " + this.nome);
		for(Item  item: this.cardapio) {
			System.out.println("Item: " + item.getNome() + " Preço: " +  item.getPrecoDoLanche());
		}
		System.out.println(" ");
	}
	
	public void imprimirPedidos() {
		System.out.println("Restaurante: " + this.nome + " CNPJ: " + this.identificador);
		System.out.println("Pedidos");
		for(Pedido pedido: this.pedidos) {
			pedido.imprimirPedido();
		}
	}
	
	public String getCNPJ() {
		return this.identificador;
	}
	
	private Item pegarItemPorIdentificador(String identificador) {
		for(int i = 0; i < this.cardapio.size(); i++) {
			if (this.cardapio.get(i).getIdentificador().equals(identificador)) {
				return this.cardapio.get(i);
			}
		}
		return null;
	}
	
	public void addDescontoNoItem(String identificador, double desconto, TipoDesconto porcentagem) {
		Item item = pegarItemPorIdentificador(identificador);
		item.setPrecoComDesconto(desconto, porcentagem);
	}

	public void tirarDescontoNoItem(String identificador) {
		Item item = pegarItemPorIdentificador(identificador);
		item.removerDesconto();
	}
	
	private Pedido pegarPedidoPeloNumero(int i) {
		for (int j = 0; j < this.pedidos.size(); j++) {
			if (this.pedidos.get(j).getNumeroDoPedido() == i) {
				return this.pedidos.get(j);				
			}
		}
		return null;
	}

	public void adicionarItem(int i, String identificador) {
		Item item = pegarItemPorIdentificador(identificador);
		this.pedidos.get(i-1).addItem(item);	
	}

	public void concluirPedido(int i) {
		Pedido pedido = pegarPedidoPeloNumero(i);
		pedido.alteraEstadoDoPedido();
		if(pedido.getEntrega()) {
			alocarEntregador(pedido);
		}	
	}

	public void addAvaliacaoDoItem(Cliente cliente, String identificador, Nota nota) {
		Item item = pegarItemPorIdentificador(identificador);
		item.addAvaliacao(cliente, nota);		
	}
	
	

}

	
	
	

