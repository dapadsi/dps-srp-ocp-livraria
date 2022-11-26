import java.util.List;

public abstract class Desconto {
    private double porcentagem;

    public Desconto(Integer porcentagem){
        this.porcentagem = porcentagem * 0.01;
    }

    public abstract boolean validar(List<Produto> produtos);

    public double aplicar(double valor){
        return valor * this.porcentagem;
    }
}
