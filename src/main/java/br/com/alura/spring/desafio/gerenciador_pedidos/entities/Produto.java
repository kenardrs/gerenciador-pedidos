package br.com.alura.spring.desafio.gerenciador_pedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter
@RequiredArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "valor")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    @OneToMany
    private List<Fornecedor> fornecedores;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "preco = " + preco + ", " +
                "categoria = " + fornecedor + ", " +
                "fornecedor = " + fornecedor + ")";
    }
}
