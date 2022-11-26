import java.util.ArrayList;
import java.util.List;

public class Jogo  extends Produto{

    private GeneroJogo genero;

    private String estudio;

    private String distribuidora;

    public GeneroJogo getGenero() {
        return genero;
    }

    public void setGenero(GeneroJogo genero) {
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public static enum GeneroJogo {
        Corrida,
        Arcade,
        Aventura
    }

    public Jogo(String nome, double preco, String estudio, String distribuidora, GeneroJogo genero){
        super(nome, preco);

        this.genero = genero;
        this.estudio = estudio;
        this.distribuidora = distribuidora;
    }

    @Override
    public String toString() {
        return "Jogo { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + ", genero: " + this.getGenero() + ", estudio: "+ this.estudio + ", distribuidora: "+ this.distribuidora +"}";
    }
}
