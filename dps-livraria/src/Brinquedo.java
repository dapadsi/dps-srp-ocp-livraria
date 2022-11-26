public class Brinquedo extends Produto{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Brinquedo(String nome, double preco, String tipo) {
        super(nome, preco);

        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Brinquedo { id: " + this.getId() + ", nome: " + this.getNome() + ", preço: " + this.getPreco() + ", conteudo adulto: " + this.isConteudoAdulto() + ", tipo: " + this.getTipo()+"}";
    }
}
