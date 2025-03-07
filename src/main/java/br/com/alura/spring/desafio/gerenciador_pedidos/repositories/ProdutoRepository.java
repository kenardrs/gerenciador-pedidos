package br.com.alura.spring.desafio.gerenciador_pedidos.repositories;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Categoria;
import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nomeProduto);

    List<Produto> findByCategoriaNome(String categoriaNome);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByPrecoLessThan(double preco);

    List<Produto> findByNomeContaining(String nome);

    List<Produto> findByCategoriaNomeOrderByPrecoAsc(String nomeCategoria);

    List<Produto> findByCategoriaNomeOrderByPrecoDesc(String nomeCategoria);

    Long countByCategoriaNome(String nomeCategoria);

    Long countByCategoriaNomeAndPrecoGreaterThan(String categoria, Double preco);

    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String nome);

    List<Produto> findTop3ByOrderByPrecoDesc();

    List<Produto> findTop5ByOrderByPrecoAsc();

    @Query("SELECT AVG(preco) FROM Produto p")
    Object consultaMediaPrecoProdutos();

    @Query("SELECT MAX(preco) FROM Produto p WHERE p.categoria.nome = :nomeCategoria")
    Double consultaPrecoMaxProdutoCategoria(String nomeCategoria);

    @Query("SELECT p.categoria.nome, COUNT(p) FROM Produto p GROUP BY p.categoria")
    List<Object[]> quantidadeProdutosPorCategoria();

    @Query("SELECT p.categoria FROM Produto p " +
            "GROUP BY p.categoria " +
            "HAVING COUNT(p) > 3")
    List<Categoria> listaCategoriasComMaisDeTresProdutos();

    @Query("SELECT p, c FROM Produto p JOIN p.categoria c WHERE p.categoria.nome = :nomeCategoria")
    List<Produto> listaProdutosCategoria(String nomeCategoria);

    @Query(value = "SELECT * FROM produto ORDER BY valor DESC LIMIT 5", nativeQuery = true)
    List<Produto> listaCincoProdutosMaisCaros();

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :primeiraLetra%")
    List<Produto> listaProdutosComPrimeiraLetra(String primeiraLetra);

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> listaProdutosPrecoOrdemDecrescente();

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> listaProdutosPrecoOrdemCrescente();

    @Query("SELECT p FROM Produto p WHERE p.preco > :precoMinimo")
    List<Produto> listaProdutosComPrecoMinimo(Double precoMinimo);
}
