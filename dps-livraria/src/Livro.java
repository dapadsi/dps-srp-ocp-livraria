import java.util.ArrayList;
import java.util.List;

public class Livro extends Produto{
    private List<GeneroLiterario> generos;

    private String escritor;

    private String editora;

    public List<GeneroLiterario> getGeneros() {
        return generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public static enum GeneroLiterario {
        FiccaoCientifica,
        Suspense,
        Romance,
        Informatica,
        Culinario
    }

    public Livro(String nome, double preco,  String escritor, String editora, List<GeneroLiterario> generos){
        super(nome, preco);

        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + ", generos: " + this.getGeneros().get(0).toString() + ", escritor: "+ this.escritor + ", editora: "+ this.editora +"}";
    }
}
