import java.util.ArrayList;
import java.util.List;

public class Compra {
    private Comprador comprador;
    private double valorTotal;
    private List<Produto> produtos;

    public double getValorTotal() {
        return valorTotal;
    }

    public Compra(Comprador comprador){
        this.produtos = new ArrayList<>();
        this.valorTotal = 0d;
        this.comprador = comprador;
    }

    public void AdicionarProduto(Produto produto){
        this.produtos.add(produto);
        this.valorTotal+=produto.getPreco();
    }

    public boolean isBloqueada(){
        boolean menor18Anos = comprador.getIdade() < 18;

        for (Produto produto: produtos) {
            if(produto.isConteudoAdulto() && menor18Anos){
                return true;
            }
        };

        return  false;
    }

    public boolean possuir(Desconto desconto) {
        return desconto.validar(this.produtos);
    }

    public void aplicar(Desconto desconto) {
        double valorDesconto = desconto.aplicar(this.valorTotal);

        this.valorTotal -= valorDesconto;
    }

    @Override
    public String toString() {
        return "Compra { comprador: " + this.comprador.toString() + ", valorTotal: " + this.valorTotal + ", produtos: " + this.produtos.size() + "}";
    }

}
