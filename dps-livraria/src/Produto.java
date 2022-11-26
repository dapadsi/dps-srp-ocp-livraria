import java.util.Date;
import java.util.Random;

public abstract class Produto {
    private Long id;
    private String nome;
    private double preco;

    private boolean conteudoAdulto;

    public Long getId(){
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteudoAdulto(boolean conteudoAdulto) {
        this.conteudoAdulto = conteudoAdulto;
    }

    public boolean isConteudoAdulto() {
        return conteudoAdulto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(String nome, double preco) {
        this.id = System.currentTimeMillis() + new Random().nextLong();
        this.nome = nome;
        this.preco = preco;
        this.conteudoAdulto = false;
    }

    @Override
    public String toString() {
        return "Produto { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + "}";
    }
}
