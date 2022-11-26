import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livraria {

    private static Estoque<Produto> estoqueGeral = new Estoque<>();
    private static Estoque<Livro> estoqueLivro = new Estoque<>();
    private static Estoque<Filme> estoqueFilme = new Estoque<>();
    private static Estoque<AlbumMusica> estoqueMusica = new Estoque<>();
    private static Estoque<Jogo> estoqueJogos = new Estoque<>();
    private static Estoque<Brinquedo> estoqueBrinquedos = new Estoque<>();

    private static TerminalEstoque terminalEstoque = new TerminalEstoque(estoqueGeral);
    private static TerminalVendedor  terminalVendedor = new TerminalVendedor();
    private static TerminalCaixa terminalCaixa = new TerminalCaixa();

    public static void main(String[] args) {

        Livro implementandoDDD = new Livro("Implementando Domain Driven Design",120.50d, "Vaughn Vernon", "Alta Books", new ArrayList<>());
        implementandoDDD.getGeneros().add(Livro.GeneroLiterario.Informatica);

        Livro padroesJavaScript = new Livro("Padrões JavaScript",80.00d, "Stoyan Stefanov", "novatec", new ArrayList<>());
        padroesJavaScript.getGeneros().add(Livro.GeneroLiterario.Informatica);

        Livro javaScriptAltoDesempenho = new Livro("JavaScript de Alto Desempenho",100.00d, "Nicholas C. Zakas", "novatec", new ArrayList<>());
        javaScriptAltoDesempenho.getGeneros().add(Livro.GeneroLiterario.Informatica);

        AlbumMusica hybridTheory = new AlbumMusica("Hybrid Theory",30.00d, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        hybridTheory.getMusicosBandas().add("Linkin Park");
        hybridTheory.getSelos().add("Warner Music");
        hybridTheory.getGeneros().add(AlbumMusica.GeneroMusical.Rock);
        hybridTheory.getGeneros().add(AlbumMusica.GeneroMusical.RockAlternativo);

        AlbumMusica revelations = new AlbumMusica("Revelations", 40.00d, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        revelations.getMusicosBandas().add("Audioslave");
        revelations.getSelos().add("SonyBMG");
        revelations.getSelos().add("Epic");
        revelations.getGeneros().add(AlbumMusica.GeneroMusical.RockAlternativo);

        Filme psicose = new Filme("Psicose", 20.00d, "Universal Pictures", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        psicose.getDiretores().add("Alfred Hitchcock");
        psicose.getProdutores().add("Alfred Hitchcock");
        psicose.getGeneros().add(Filme.GeneroAudioVisual.Suspense);
        psicose.setConteudoAdulto(true);

        terminalEstoque.adicionar(implementandoDDD,estoqueLivro);
        terminalEstoque.adicionar(padroesJavaScript,estoqueLivro);
        terminalEstoque.adicionar(javaScriptAltoDesempenho, estoqueLivro);
        terminalEstoque.adicionar(hybridTheory,estoqueMusica);
        terminalEstoque.adicionar(revelations,estoqueMusica);
        terminalEstoque.adicionar(psicose,estoqueFilme);

        terminalVendedor.listar(estoqueGeral);
        terminalVendedor.quantidade(estoqueLivro);
        terminalVendedor.ver(estoqueMusica, hybridTheory);

        Carrinho carrinhoAnonimo = new Carrinho();
        carrinhoAnonimo.adicionar(implementandoDDD);
        carrinhoAnonimo.adicionar(psicose);

        terminalCaixa.iniciarCompra(new Compra(Comprador.NAO_IDENTIFICADO));

        for (Produto produto: carrinhoAnonimo.pegarProdutos()) {
            terminalCaixa.passarProduto(produto);
        }

        boolean finalizouCompraAnonima = terminalCaixa.finalizarCompra();

        if(finalizouCompraAnonima){
           retirarItensEstoque(carrinhoAnonimo.pegarProdutos());
        }

        Carrinho carrinhoJoao = new Carrinho();
        carrinhoJoao.adicionar(implementandoDDD);
        carrinhoJoao.adicionar(psicose);

        Comprador joao = new Comprador("Joao", "11.111.111-1", "222.222.222-22", LocalDate.parse("2004-12-22"));

        terminalCaixa.iniciarCompra(new Compra(joao));

        for (Produto produto: carrinhoJoao.pegarProdutos()) {
            terminalCaixa.passarProduto(produto);
        }

        boolean finalizouCompraJoao = terminalCaixa.finalizarCompra();

        if(finalizouCompraJoao){
            retirarItensEstoque(carrinhoJoao.pegarProdutos());
        }

        Carrinho carrinhoJose = new Carrinho();
        carrinhoJose.adicionar(implementandoDDD);
        carrinhoJose.adicionar(padroesJavaScript);
        carrinhoJose.adicionar(javaScriptAltoDesempenho);
        carrinhoJose.adicionar(revelations);
        carrinhoJose.adicionar(psicose);

        Comprador jose = new Comprador("Jose", "55.555.555-5", "333.333.333-33", LocalDate.parse("2003-12-22"));

        terminalCaixa.iniciarCompra(new Compra(jose));

        for (Produto produto: carrinhoJose.pegarProdutos()) {
            terminalCaixa.passarProduto(produto);
        }

        boolean finalizouCompraJose = terminalCaixa.finalizarCompra();

        if(finalizouCompraJose){
            retirarItensEstoque(carrinhoJose.pegarProdutos());

            terminalVendedor.listar(estoqueGeral);
            terminalVendedor.quantidade(estoqueGeral);
        }

    }

    private static void retirarItensEstoque(List<Produto> produtos){
        for (Produto produto: produtos) {

            if(produto instanceof Livro) {
                terminalEstoque.remover((Livro)produto, estoqueLivro);
            } else if (produto instanceof Filme) {
                terminalEstoque.remover((Filme)produto, estoqueFilme);
            } else if (produto instanceof AlbumMusica) {
                terminalEstoque.remover((AlbumMusica)produto, estoqueMusica);
            } else if (produto instanceof Jogo) {
                terminalEstoque.remover((Jogo)produto, estoqueJogos);
            } else if (produto instanceof Brinquedo) {
                terminalEstoque.remover((Brinquedo)produto, estoqueBrinquedos);
            }
        }
    }
}