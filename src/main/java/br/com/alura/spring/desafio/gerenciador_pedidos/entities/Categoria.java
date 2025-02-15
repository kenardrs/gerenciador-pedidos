package br.com.alura.spring.desafio.gerenciador_pedidos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Categoria {
    @Id
    private Long id;

    private String nome;
}
