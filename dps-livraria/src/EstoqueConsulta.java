import java.util.Collection;

public interface EstoqueConsulta<T extends Produto> {

    public Integer quantidade();

    public Collection<T> listar();

    public T ver(Long id);
}
