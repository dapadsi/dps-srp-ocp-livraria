import java.util.Collection;

public class TerminalEstoque {
    private EstoqueGerenciavel<Produto> estoqueGeral = new Estoque<>();

    public TerminalEstoque(EstoqueGerenciavel<Produto> estoqueGeral){
        this.estoqueGeral = estoqueGeral;
    }

    public <T extends  Produto> void adicionar (T item, EstoqueGerenciavel<T> estoque){
         estoque.adicionar(item);
        this.estoqueGeral.adicionar(item);

        System.out.println("================= Adicionou ao Estoque  =========================");
        System.out.println(item.toString());
        System.out.println("=================================================================\n\n");
    }

    public <T extends  Produto> void alterar (T item, EstoqueGerenciavel<T> estoque){
        estoque.alterar(item);
        this.estoqueGeral.alterar(item);

        System.out.println("================= Alterou no Estoque  ==========================");
        System.out.println(item.toString());
        System.out.println("================================================================\n\n");
    }

    public <T extends  Produto> void remover (T item, EstoqueGerenciavel<T> estoque){
        estoque.remover(item);
        this.estoqueGeral.remover(item);

        System.out.println("================= Retirou do Estoque  ==========================");
        System.out.println(item.toString());
        System.out.println("================================================================\n\n");
    }

}
