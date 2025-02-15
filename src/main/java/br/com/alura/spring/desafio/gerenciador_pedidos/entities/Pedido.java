package br.com.alura.spring.desafio.gerenciador_pedidos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pedido {
    @Id
    private Long id;

    private LocalDate data;
}
