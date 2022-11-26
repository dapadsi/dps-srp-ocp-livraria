import java.util.Collection;

public class TerminalVendedor {

    public <T extends Produto> Collection<T> listar(EstoqueConsulta<T> estoque){
        System.out.println("======================= Listando Estoque =========================");
        estoque.listar().forEach(p -> System.out.println(p.toString()));
        System.out.println("==================================================================\n\n");

        return estoque.listar();
    }

    public <T extends Produto> T ver(EstoqueConsulta<T> estoque, Produto produto){
        System.out.println("======================= Detalhe Produto =========================");
        System.out.println(estoque.ver(produto.getId()).toString());
        System.out.println("=================================================================\n\n");

        return estoque.ver(produto.getId());
    }

    public <T extends Produto> Integer quantidade(EstoqueConsulta<T> estoque){
        System.out.println("======================= Quantidade em Estoque =====================");
        System.out.println(estoque.quantidade().toString());
        System.out.println("===================================================================\n\n");

        return estoque.quantidade();
    }

}
