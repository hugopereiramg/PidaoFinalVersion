package com.unicamp.mc322.lab10.pidao.servico.produtos;
import java.util.ArrayList;
import java.lang.Math;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.enuns.EstadoDoPedido;


public class Pedido {
	private Cliente cliente;
	private ArrayList<Item> listaDeItens;
	private double valor;
	private double precoDaEntrega;
	private double precoFinal;
	private EstadoDoPedido estado;
	private int numero;
	private boolean entrega;
	private Entregador entregador;
	private Restaurante restaurante;
	
	public Pedido(Cliente cliente, boolean entrega) {
		this.cliente = cliente;
		this.listaDeItens = new ArrayList<Item>();
		this.valor = 0.0;
		this.precoFinal =0.0;
		this.estado = EstadoDoPedido.NOVO;
		this.numero = 0;
		this.entrega = entrega;
		this.precoDaEntrega = 0.0;
	}
	
	public void addItem(Item lanche) {
		this.listaDeItens.add(lanche);
	}
	
	public void removerItem(String identificador) {
		int i = 0;
		while(i < this.listaDeItens.size()) {
			if(this.listaDeItens.get(i).getIdentificador().equals(identificador)) {
				this.listaDeItens.remove(i);
				i = this.listaDeItens.size();
			}else {
				i = i + 1;
			}
		}
	}

	public void alteraEstadoDoPedido () {
		switch (this.estado) {
		case NOVO:
			this.estado = EstadoDoPedido.EMPREPARACAO;
			this.calculaPrecoFinal();
			break;
			
		case EMPREPARACAO:
			this.estado = EstadoDoPedido.PRONTO;
			break;
			
		case PRONTO:
			this.estado = EstadoDoPedido.SAIUPARAENTREGA;
			break;
			
		case SAIUPARAENTREGA:
			this.estado = EstadoDoPedido.ENTREGUE;
			break;
			
		default:
			break;
			
		}
	}
	
	public EstadoDoPedido getEstadoDoPedido () {
		return this.estado;
	}
	
	public void calculaPrecoFinal() {
		for(Item item: this.listaDeItens) {
			this.valor = this.valor + item.getPrecoDoLanche();
		}
		
		if(this.cliente.getNumeroDePedidos() == 1) {
			this.precoFinal = (this.valor * 0.8) + this.precoDaEntrega;
		} else {
			this.precoFinal = this.valor + this.precoDaEntrega;
		}
		
		this.precoFinal = Math.round(this.precoFinal);
	}

	public void setNumeroDoPedido(int i) {
		this.numero = i;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public boolean getEntrega() {
		return this.entrega;
	}
	
	public void adicionarValorEntrega(int x, int y) {
		int distancia = this.cliente.calcularDistancia(x, y);
		double valor = distancia*0.5;
		this.precoDaEntrega = valor;
	}
	
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
	public void imprimirPedido() {
		System.out.println("Cliente: " + this.cliente.getNome());
		double total = 0.0;
		for(Item item:this.listaDeItens) {
			System.out.println(item.getNome() + "         R$" + item.getPrecoDoLanche());
			total = total + item.getPrecoDoLanche();
		}
		System.out.println("Preço do pedido: R$ " + total);
		System.out.println("Preço da corrida: R$ " + this.precoDaEntrega);
		System.out.println("Preço Total: R$ " + this.precoFinal);
		System.out.println("Entregador: " + this.entregador.getNome());
		System.out.println(" ");
	}

	public int getNumeroDoPedido() {
		return this.numero;
	}
	
}






