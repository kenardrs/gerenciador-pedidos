package br.com.alura.spring.desafio.gerenciador_pedidos.repositories;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByDataIsNull();

    List<Pedido> findByDataNotNull();

    List<Pedido> findByDataGreaterThan(LocalDate data);

    List<Pedido> findByDataLessThan(LocalDate data);

    List<Pedido> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("SELECT p FROM Pedido p WHERE p.data BETWEEN :dataInicio AND :dataFim")
    List<Pedido> listaPedidosEntreDatas(LocalDate dataInicio, LocalDate dataFim);
}
