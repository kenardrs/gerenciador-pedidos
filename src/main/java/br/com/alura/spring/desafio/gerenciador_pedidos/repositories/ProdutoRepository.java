package br.com.alura.spring.desafio.gerenciador_pedidos.repositories;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
