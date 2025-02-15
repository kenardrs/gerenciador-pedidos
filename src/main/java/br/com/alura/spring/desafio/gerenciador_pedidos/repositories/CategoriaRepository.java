package br.com.alura.spring.desafio.gerenciador_pedidos.repositories;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
