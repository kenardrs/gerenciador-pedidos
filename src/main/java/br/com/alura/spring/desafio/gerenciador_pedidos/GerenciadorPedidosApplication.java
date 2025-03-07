package br.com.alura.spring.desafio.gerenciador_pedidos;

import br.com.alura.spring.desafio.gerenciador_pedidos.principal.Principal;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.CategoriaRepository;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.ProdutoRepository;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(produtoRepository, pedidoRepository);
		principal.exibeMenu();
	}
}

// 112818729
