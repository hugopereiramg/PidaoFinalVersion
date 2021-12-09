package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.pidao.cliente.Cliente;
import com.unicamp.mc322.lab10.pidao.servico.enuns.Nota;
import com.unicamp.mc322.lab10.pidao.servico.enuns.TipoDesconto;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Entregador;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Item;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Pedido;
import com.unicamp.mc322.lab10.pidao.servico.produtos.Restaurante;

public class Execucao {
	
	public static void start() {
		
		Pidao pidaoApp = Pidao.getInstance();
			
		
		pidaoApp.addRestaurante("Restaurante Mineiro", "25.333.333", 2, 5);
		
		pidaoApp.addRestaurante("Restaurante Gaucho", "27.444.444", 8, 2);
		
		Cliente cliente1 = new Cliente("Joao da Silva", "111.333.222-22", 1, 3);
		Cliente cliente2 = new Cliente("Thiago Alves", "222.444.333-22", 10, 11);
		Cliente cliente3 = new Cliente("Jose Ricardo", "333.444.888-66", 6, 1);

		Entregador jose = new Entregador("Jose", "444.666.888-00");
		Entregador francisco = new Entregador("Francisco", "888.999.000-22");
		Entregador otavio = new Entregador("Otavio", "777.000.555-11");
		
		pidaoApp.incluirEntregador("25.333.333", jose);
		pidaoApp.incluirEntregador("25.333.333", francisco);
		pidaoApp.incluirEntregador("27.444.444", otavio);
		
		pidaoApp.addItem("25.333.333", "Tropeiro", "01", 30.00);
		pidaoApp.addItem("25.333.333", "Escondidinho", "02", 34.00);
		pidaoApp.addItem("25.333.333", "Frango com quiabo", "03", 30.00);
		
		pidaoApp.addDesconto("25.333.333", "02", 20, TipoDesconto.PORCENTAGEM);
		
		pidaoApp.addItem("27.444.444", "Picanha", "01", 55.00);
		pidaoApp.addItem("27.444.444", "Xis gaucho", "02", 35.00);
		pidaoApp.addItem("27.444.444", "Tainha assada", "03", 40.00);
		
		pidaoApp.imprimirCardapio("25.333.333");
		pidaoApp.imprimirCardapio("27.444.444");
		
		pidaoApp.criarPedido("25.333.333", cliente1, true);
		
		pidaoApp.inserirItemNoPedido("25.333.333", 1, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 1, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 1, "02");
		
		pidaoApp.concluirPedido("25.333.333", 1);
		
		pidaoApp.criarPedido("25.333.333", cliente2, true);
		pidaoApp.inserirItemNoPedido("25.333.333", 2, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 2, "02");
		pidaoApp.inserirItemNoPedido("25.333.333", 2, "02");
		pidaoApp.inserirItemNoPedido("25.333.333", 2, "03");
		
		pidaoApp.concluirPedido("25.333.333", 2);
		
		
		pidaoApp.avaliarRestaurante("25.333.333", cliente1, Nota.Três);
		pidaoApp.avaliarItem("25.333.333", "01", cliente1, Nota.Três);
		pidaoApp.avaliarItem("25.333.333", "01", cliente1, Nota.Quatro);
		jose.addAvaliacao(cliente1, Nota.Cinco);
		
		pidaoApp.criarPedido("27.444.444", cliente3, true);
		
		pidaoApp.inserirItemNoPedido("27.444.444", 1, "01");
		pidaoApp.inserirItemNoPedido("27.444.444", 1, "02");
		pidaoApp.inserirItemNoPedido("27.444.444", 1, "03");
		
		pidaoApp.concluirPedido("27.444.444", 1);
		
		pidaoApp.criarPedido("25.333.333", cliente3, true);
		
		pidaoApp.inserirItemNoPedido("25.333.333", 3, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 3, "02");
		pidaoApp.inserirItemNoPedido("25.333.333", 3, "03");
		
		pidaoApp.concluirPedido("25.333.333", 3);
		
		pidaoApp.criarPedido("25.333.333", cliente2, true);
		
		pidaoApp.inserirItemNoPedido("25.333.333", 4, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 4, "02");
		pidaoApp.inserirItemNoPedido("25.333.333", 4, "03");
		pidaoApp.concluirPedido("25.333.333", 4);
		
		pidaoApp.incluirEntregador("25.333.333", otavio);
		
		pidaoApp.criarPedido("25.333.333", cliente1, true);
		
		pidaoApp.inserirItemNoPedido("25.333.333", 5, "01");
		pidaoApp.inserirItemNoPedido("25.333.333", 5, "02");
		pidaoApp.inserirItemNoPedido("25.333.333", 5, "03");
		pidaoApp.concluirPedido("25.333.333", 5);
		
		pidaoApp.imprimirPedidos();
		
		pidaoApp.avaliarRestaurante("25.333.333", cliente2, Nota.Cinco);
		pidaoApp.avaliarRestaurante("25.333.333", cliente3, Nota.Três);
		
		pidaoApp.imprimirAvaliacoes("25.333.333");
		
			
	
	}
}
