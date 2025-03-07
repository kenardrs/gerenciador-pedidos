package br.com.alura.spring.desafio.gerenciador_pedidos.principal;

import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Categoria;
import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Pedido;
import br.com.alura.spring.desafio.gerenciador_pedidos.entities.Produto;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.PedidoRepository;
import br.com.alura.spring.desafio.gerenciador_pedidos.repositories.ProdutoRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private ProdutoRepository produtoRepository;

    private PedidoRepository pedidoRepository;

    public Principal(
            ProdutoRepository produtoRepository,
            PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 0) {

            var menu = """
                    1 - Retorne todos os produtos com o nome exato fornecido.
                    2 - Retorne todos os produtos associados a uma categoria específica.
                    3 - Retorne produtos com preço maior que o valor fornecido.
                    4 - Retorne produtos com preço menor que o valor fornecido.
                    5 - Retorne produtos cujo nome contenha o termo especificado.
                    6 - Retorne pedidos que ainda não possuem uma data de entrega.
                    7 - Retorne pedidos com data de entrega preenchida.
                    8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.
                    9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.
                    10 - Retorne a contagem de produtos em uma categoria específica.
                    11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.
                    12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.
                    13 - Retorne pedidos feitos após uma data específica.
                    14 - Retorne pedidos feitos antes de uma data específica.
                    15 - Retorne pedidos feitos em um intervalo de datas.
                    16 - Retorne os três produtos mais caros.
                    17 - Retorne os cinco produtos mais baratos de uma categoria.
                    18 - Retorne os produtos com preço maior que um valor
                    19 - Retorne os produtos ordenados pelo preço crescente.
                    20 - Retorne os produtos ordenados pelo preço decrescente.
                    21 - Retorne os produtos que comecem com uma letra específica.
                    22 - Retorne os pedidos feitos entre duas datas.
                    23 - Retorne a média de preços dos produtos.
                    24 - Retorne o preço máximo de um produto em uma categoria
                    25 - Retorne o número de produtos por categoria.
                    26 - Retorne as categorias com mais de 3 produtos.
                    27 - Retorne os produtos filtrados por nome ou por categoria.
                    28 - Retorne os cinco produtos mais caros

                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscaProdutosPorNome();
                    break;
                case 2:
                //Retorne todos os produtos associados a uma categoria específica.
                    buscaProdutosPorCategoria();
                    break;
                case 3:
                //Retorne produtos com preço maior que o valor fornecido.
                    buscaProdutosComPrecoMaior();
                    break;
                case 4:
                //Retorne produtos com preços menor que o valor fornecido.
                    buscaProdutosComPrecoMenor();
                    break;
                case 5:
                //Retorne produtos cujo nome contenha o termo especificado.
                    buscaProdutoNomeContem();
                    break;
                case 6:
                //Retorne pedidos que ainda não possuem uma data de entrega.
                    buscaPedidosSemData();
                    break;
                case 7:
                //Retorne pedidos com data de entrega preenchida.
                    buscaPedidosComData();
                    break;
                case 8:
                //Retorne produtos de uma categoria ordenados pelo preço de forma crescente.
                    ListaProdutosCategoriaPrecosOrdemCrescente();
                    break;
                case 9:
                //Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.
                    ListaProdutosCategoriaPrecosOrdemDecrescente();
                    break;
                case 10:
                //Retorne a contagem de produtos em uma categoria específica.
                    TotalDeProdutosDaCategoria();
                    break;
                case 11:
                //Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.
                    TotalDeProdutosDaCategoriaComPrecoMínimo();
                    break;
                case 12:
                    //Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.
                    ListaDeProdutosComPrecoMaximoOuNomeContem();
                    break;
                case 13:
                    //Retorne pedidos feitos após uma data específica.
                    ListaDePedidosAposDataEspecífica();
                    break;
                case 14:
                    //Retorne pedidos feitos antes de uma data específica.
                    ListaDePedidosAntesDataEspecifica();
                    break;
                case 15:
                    //Retorne pedidos feitos em um intervalo de datas.
                    ListaDePedidoEntreDatas();
                    break;
                case 16:
                    //Retorne os três produtos mais caros.
                    ListaDeProdutosTopTresMaiorPreco();
                    break;
                case 17:
                    //Retorne os cinco produtos mais baratos de uma categoria.
                    ListaDeProdutosTopCincoMenorPrecoCategoria();
                    break;
                case 18:
//                1 - Crie uma consulta que retorne os produtos com preço maior que um valor
                    ListaProdutosPrecoMaior();
                    break;
                case 19:
//                2 - Crie uma consulta que retorne os produtos ordenados pelo preço crescente.
                    ListaProdutosPrecoOrdemCrescente();
                    break;
                case 20:
//                3 - Crie uma consulta que retorne os produtos ordenados pelo preço decrescente.
                    ListaProdutosPrecoOrdemDecrescente();
                    break;
                case 21:
//                4 - Crie uma consulta que retorne os produtos que comecem com uma letra específica.
                    ListaProdutosLetraInicial();
                    break;
                case 22:
//                5 - Crie uma consulta que retorne os pedidos feitos entre duas datas.
                    ListaPedidosEntreDatas();
                    break;
                case 23:
//                6 - Crie uma consulta que retorne a média de preços dos produtos.
                    ConsultaMediaPrecosProdutos();
                    break;
                case 24:
//                7 - Crie uma consulta que retorne o preço máximo de um produto em uma categoria
                    ConsultaPrecoMaxProdutoCategoria();
                    break;
                case 25:
//                8 - Crie uma consulta para contar o número de produtos por categoria.
                    ConsultaQuantidadeProdutosPorCategoria();
                    break;
                case 26:
//                9 - Crie uma consulta para filtrar categorias com mais de 10 produtos.
                    ListaCategoriaComMaisTresProdutos();
                    break;
                case 27:
//                10 - Crie uma consulta para retornar os produtos filtrados por nome ou por categoria.
                    ListaProdutosNomeCategoria();
                    break;
                case 28:
//                11 - Crie uma consulta nativa para buscar os cinco produtos mais caros
                    ListaCincoProdutosMaisCaros();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void ListaProdutosPrecoMaior() {
        System.out.println("Informe o preço mínimo:");
        Double precoMinimo = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.listaProdutosComPrecoMinimo(precoMinimo);
        produtos.forEach(System.out::println);
    }

    private void ListaProdutosPrecoOrdemCrescente() {
        List<Produto> produtos = produtoRepository.listaProdutosPrecoOrdemCrescente();
        produtos.forEach(System.out::println);
    }

    private void ListaProdutosPrecoOrdemDecrescente() {
        List<Produto> produtos = produtoRepository.listaProdutosPrecoOrdemDecrescente();
        produtos.forEach(System.out::println);
    }

    private void ListaProdutosLetraInicial() {
        System.out.println("Informe a peimeira letra do nome do produto:");
        var primeiraLetra = leitura.nextLine();
        List<Produto> produtos = produtoRepository.listaProdutosComPrimeiraLetra(primeiraLetra);
        if (!produtos.isEmpty()) {
            produtos.forEach(System.out::println);
        } else {
            System.out.println("Produto não localizado");
        }

    }

    private void ListaPedidosEntreDatas() {
        System.out.println("Informe a data de início:");
        var inputInicio = leitura.nextLine();
        System.out.println("Informe a data fim:");
        var inputFim = leitura.nextLine();
        var dataInicio = LocalDate.parse(inputInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var dataFim = LocalDate.parse(inputFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Pedido> pedidos = pedidoRepository.listaPedidosEntreDatas(dataInicio, dataFim);
        pedidos.forEach(System.out::println);
    }

    private void ConsultaMediaPrecosProdutos() {
        var precoMedioProdutos = produtoRepository.consultaMediaPrecoProdutos();
        System.out.println("O preço médio dos produtos é: " + precoMedioProdutos);
    }

    private void ConsultaPrecoMaxProdutoCategoria() {
        System.out.println("Informe a categoria desejada:");
        var nomeCategoria = leitura.nextLine();
        var preco = produtoRepository.consultaPrecoMaxProdutoCategoria(nomeCategoria);
        System.out.println("O preço máximo: " + preco);

    }

    private void ConsultaQuantidadeProdutosPorCategoria() {
        List<Object[]> totalPorCategoria = produtoRepository.quantidadeProdutosPorCategoria();
        System.out.println("Total por categoria:");
        totalPorCategoria.forEach(o -> {
            System.out.println(o[0] + " - " + o[1]);
        });

    }

    private void ListaCategoriaComMaisTresProdutos() {
        List<Categoria> categorias = produtoRepository.listaCategoriasComMaisDeTresProdutos();
        categorias.forEach(System.out::println);
    }

    private void ListaProdutosNomeCategoria() {
        System.out.println("Informe a categoria desejada:");
        var nomeCategoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.listaProdutosCategoria(nomeCategoria);
        produtos.forEach(System.out::println);
    }

    private void ListaCincoProdutosMaisCaros() {
        List<Produto> produtos = produtoRepository.listaCincoProdutosMaisCaros();
        produtos.forEach(System.out::println);
    }

    private void TotalDeProdutosDaCategoriaComPrecoMínimo() {
        System.out.println("Informe a categoria desejada:");
        var categoria = leitura.nextLine();
        System.out.println("Informe o preço mínimo:");
        var preco = leitura.nextDouble();
        Long totalProdutos = produtoRepository.countByCategoriaNomeAndPrecoGreaterThan(categoria, preco);
        System.out.println("Total de produtos da categoria " + categoria + " com valor inferior a "+ preco +": " + totalProdutos);
    }

    private void ListaDeProdutosComPrecoMaximoOuNomeContem() {
        System.out.println("Informe parte do nome do produto:");
        var nome = leitura.nextLine();
        System.out.println("Informe o preço máximo:");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoLessThanOrNomeContaining(preco, nome);
        produtos.forEach(System.out::println);
    }

    private void ListaDePedidosAposDataEspecífica() {
        System.out.println("Informe a data mínima desejada:");
        var input = leitura.nextLine();
        var data = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Pedido> pedidos = pedidoRepository.findByDataGreaterThan(data);
        pedidos.forEach(System.out::println);
    }

    private void ListaDePedidosAntesDataEspecifica() {
        System.out.println("Informe a data máxima desejada:");
        var input = leitura.nextLine();
        var data = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Pedido> pedidos = pedidoRepository.findByDataLessThan(data);
        pedidos.forEach(System.out::println);

    }

    private void ListaDePedidoEntreDatas() {
        System.out.println("Informe a data de início:");
        var inputInicio = leitura.nextLine();
        System.out.println("Informe a data fim:");
        var inputFim = leitura.nextLine();
        var dataInicio = LocalDate.parse(inputInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var dataFim = LocalDate.parse(inputFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Pedido> pedidos = pedidoRepository.findByDataBetween(dataInicio, dataFim);
        pedidos.forEach(System.out::println);

    }

    private void ListaDeProdutosTopTresMaiorPreco() {
        List<Produto> produtos = produtoRepository.findTop3ByOrderByPrecoDesc();
        produtos.forEach(System.out::println);
    }

    private void ListaDeProdutosTopCincoMenorPrecoCategoria() {
        List<Produto> produtos = produtoRepository.findTop5ByOrderByPrecoAsc();
        produtos.forEach(System.out::println);
    }

    private void TotalDeProdutosDaCategoria() {
        System.out.println("Qual a categoria desejada?");
        var nomeCategoria = leitura.nextLine();
        var totalProdutos = produtoRepository.countByCategoriaNome(nomeCategoria);
        System.out.println("Total de produtos da categoria " + nomeCategoria + ": " + totalProdutos);
    }

    private void ListaProdutosCategoriaPrecosOrdemCrescente() {
        System.out.println("Qual a categoria desejada?");
        var nomeCategoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNomeOrderByPrecoAsc(nomeCategoria);
        produtos.forEach(System.out::println);
    }

    private void ListaProdutosCategoriaPrecosOrdemDecrescente() {
        System.out.println("Qual a categoria desejada?");
        var nomeCategoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNomeOrderByPrecoDesc(nomeCategoria);
        produtos.forEach(System.out::println);
    }

    private void buscaPedidosComData() {
        System.out.println("Peedidos com data de entrega:");
        List<Pedido> pedidos = pedidoRepository.findByDataNotNull();
        pedidos.forEach(System.out::println);
    }

    private void buscaPedidosSemData() {
        System.out.println("Pedidos sem data de entrega:");
        List<Pedido> pedidos = pedidoRepository.findByDataIsNull();
        pedidos.forEach(System.out::println);
    }

    private void buscaProdutoNomeContem() {
        System.out.println("Qual o termo contido no nome?");
        var nome = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByNomeContaining(nome);
        produtos.forEach(System.out::println);
    }

    private void buscaProdutosComPrecoMenor() {
        System.out.println("Qual o valor máximo?");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoLessThan(preco);
        produtos.forEach(System.out::println);
    }

    private void buscaProdutosPorNome() {
        System.out.println("Qual o nome do produto a buscar?");
        var nomeProduto = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByNome(nomeProduto);
        produtos.forEach(System.out::println);
    }

    private void buscaProdutosPorCategoria() {
        System.out.println("Qual a categoria desejada?");
        var nomeCategoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNome(nomeCategoria);
        produtos.forEach(System.out::println);
    }

    private void buscaProdutosComPrecoMaior() {
        System.out.println("Qual o valor mínimo?");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoGreaterThan(preco);
        produtos.forEach(System.out::println);
    }

}
