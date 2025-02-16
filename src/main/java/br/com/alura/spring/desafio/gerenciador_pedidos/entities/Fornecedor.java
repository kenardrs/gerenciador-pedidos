package br.com.alura.spring.desafio.gerenciador_pedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fornecedor")
@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}
