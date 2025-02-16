package br.com.alura.spring.desafio.gerenciador_pedidos;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Categoria;
import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Pedido;
import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Produto;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.CategoriaRepository;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.PedidoRepository;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import(TestcontainersConfiguration.class)
class RepositoriesTestContainersTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Test
    public void testSalvarCategoria() {
        // Cria uma nova categoria
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Eletrônico");

        // Salva a categoria no banco de dados
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        // Verifica se a categoria foi salva corretamente
        assertThat(categoriaSalva).isNotNull();
        assertThat(categoriaSalva.getId()).isNotNull();
        assertThat(categoriaSalva.getNome()).isEqualTo("Eletrônico");

        // Busca o categoria no banco de dados para confirmar que foi salvo
        Categoria categoriaEncontrada = categoriaRepository.findById(categoriaSalva.getId()).orElse(null);
        System.out.println(categoriaEncontrada);
        assertThat(categoriaEncontrada).isNotNull();
        assertThat(categoriaEncontrada.getId()).isEqualTo(1L);
        assertThat(categoriaEncontrada.getNome()).isEqualTo("Eletrônico");
    }

    @Test
    public void testSalvarProduto() {
        // Cria um novo produto
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(4500.00);

        // Salva o produto no banco de dados
        Produto produtoSalvo = produtoRepository.save(produto);

        // Verifica se o produto foi salvo corretamente
        assertThat(produtoSalvo).isNotNull();
        assertThat(produtoSalvo.getId()).isNotNull();
        assertThat(produtoSalvo.getNome()).isEqualTo("Notebook");
        assertThat(produtoSalvo.getPreco()).isEqualTo(4500.00);

        // Busca o produto no banco de dados para confirmar que foi salvo
        Produto produtoEncontrado = produtoRepository.findById(produtoSalvo.getId()).orElse(null);
        System.out.println(produtoEncontrado);
        assertThat(produtoEncontrado).isNotNull();
        assertThat(produtoEncontrado.getNome()).isEqualTo("Notebook");
        assertThat(produtoEncontrado.getPreco()).isEqualTo(4500.00);
    }

    @Test
    public void testSalvarPedido() {
        // Cria um novo pedido
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        var dataTest = LocalDate.now();
        pedido.setData(dataTest);

        // Salva o pedido no banco de dados
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        // Verifica se o pedido foi salvo corretamente
        assertThat(pedidoSalvo).isNotNull();
        assertThat(pedidoSalvo.getId()).isNotNull();
        assertThat(pedidoSalvo.getData()).isEqualTo(dataTest);

        // Busca o pedido no banco de dados para confirmar que foi salvo
        Pedido pedidoEncontrado = pedidoRepository.findById(pedidoSalvo.getId()).orElse(null);
        System.out.println(pedidoEncontrado);
        assertThat(pedidoEncontrado).isNotNull();
        assertThat(pedidoEncontrado.getId()).isEqualTo(1L);
        assertThat(pedidoEncontrado.getData()).isEqualTo(dataTest);
    }
}