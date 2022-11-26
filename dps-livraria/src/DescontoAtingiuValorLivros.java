import java.util.List;

public class DescontoAtingiuValorLivros extends Desconto{

    public DescontoAtingiuValorLivros(Integer porcentagem) {
        super(porcentagem);
    }

    @Override
    public boolean validar(List<Produto> produtos) {
        double valorEmLivros = 0d;

        for (Produto produto: produtos) {
            if(produto instanceof Livro) {
                valorEmLivros += produto.getPreco();
            }
        };

        return valorEmLivros > 200d;
    }
}
