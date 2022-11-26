import java.time.LocalDate;
import java.time.Period;

public class Comprador {
    private String nome;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        LocalDate dataAtual = LocalDate.now();
        return Period.between(this.dataNascimento, dataAtual).getYears();
    }

    public static Comprador NAO_IDENTIFICADO =  new Comprador("Não Identificado", "", "", LocalDate.now());

    public Comprador(String nome, String rg, String cpf, LocalDate dataNascimento){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Comprador { nome: " + this.nome + ", rg: " + this.rg + ", cpf: " + this.cpf + ", dataNascimento: " + this.dataNascimento.toString() + ", idade: " + this.getIdade() + "}";
    }

}
