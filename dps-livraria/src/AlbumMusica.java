import java.util.List;

public class AlbumMusica extends Produto{
    private List<String> musicosBandas;
    private List<String> selos;
    private List<GeneroMusical> generos;

    public List<String> getMusicosBandas() {
        return musicosBandas;
    }

    public List<String> getSelos() {
        return selos;
    }

    public List<GeneroMusical> getGeneros() {
        return generos;
    }

    public static enum GeneroMusical {
        RockPop,
        RockAlternativo,
        Rock,
        Metal,
        Samba,
        Eletronico
    }

    public AlbumMusica(String nome, double preco, List<String> musicosBandas, List<String> selos, List<GeneroMusical> generos) {
        super(nome, preco);

        this.musicosBandas = musicosBandas;
        this.selos = selos;
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "AlbumMusica { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + ", generos: " + this.getGeneros().get(0).toString() + ", musicosBandas: "+ this.getMusicosBandas().get(0) + ", selos: "+ this.getSelos().get(0) +"}";
    }
}
