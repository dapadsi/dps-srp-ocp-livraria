import java.util.List;

public class Filme extends Produto{

    private String estudio;
    private List<String> diretores;
    private List<String> produtores;
    private List<GeneroAudioVisual> generos;

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public List<String> getProdutores() {
        return produtores;
    }

    public List<GeneroAudioVisual> getGeneros() {
        return generos;
    }

    public static enum GeneroAudioVisual {
        FiccaoCientifica,
        Suspense,
        Romance,
        Aventura,
        Acao
    }

    public Filme(String nome, double preco, String estudio, List<String> diretores, List<String> produtores, List<GeneroAudioVisual> generos) {
        super(nome, preco);

        this.generos = generos;
        this.estudio = estudio;
        this.diretores = diretores;
        this.produtores = produtores;
    }

    @Override
    public String toString() {
        return "Filme { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + ", generos: " + this.getGeneros().get(0).toString() + ", estudio: "+ this.estudio + ", diretores: "+ this.diretores.get(0) + ", diretores: "+ this.produtores.get(0) +"}";
    }
}
