package br.com.alura.spring.desafio.gerenciador_pedidos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;

}
