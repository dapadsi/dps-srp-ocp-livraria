import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Estoque<T extends  Produto> implements EstoqueGerenciavel<T>, EstoqueConsulta<T> {

    private Map<Long, T> items;

    public  Estoque(){
        this.items = new HashMap<>();
    }

    public void adicionar(T item){
        this.items.put(item.getId(), item);
    }

    public Integer quantidade() {
        return this.items.size();
    }

    public Collection<T> listar(){
        return this.items.values();
    }

    public T ver(Long id) {
        return this.items.get(id);
    }

    public void alterar(T item){
        this.items.replace(item.getId(), item);
    }

    public void remover(T item) {
        this.items.remove(item.getId());
    }

}
