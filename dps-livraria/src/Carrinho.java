import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrinho {
    private Map<String, Double> valorPorTipo;
    private List<Produto> produtos;

    public Carrinho(){
        this.produtos = new ArrayList<>();
    }

    public void adicionar(Produto produto) {
        this.produtos.add(produto);

        System.out.println("================ Adicionou ao Carrinho  =========================");
        System.out.println(produto.toString());
        System.out.println("=================================================================\n\n");
    }

    public List<Produto> pegarProdutos() {
        System.out.println("================ Pegou os items do Carrinho  ====================");
        this.produtos.forEach(p ->  System.out.println(p.toString()));
        System.out.println("=================================================================\n\n");

        return this.produtos;
    }
}
