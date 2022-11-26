public interface EstoqueGerenciavel<T extends Produto> {

    public void adicionar(T item);

    public void alterar(T item);

    public void remover(T item);
}
