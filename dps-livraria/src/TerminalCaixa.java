public class TerminalCaixa {
    private Compra compra;
    private double valorEmCaixa;

    public TerminalCaixa() {
        this.valorEmCaixa = 0d;
    }

    public void iniciarCompra(Compra compra){

        System.out.println("================= Iniciou Compra  =================================");
        System.out.println(compra.toString());
        System.out.println("================================================================\n\n");

        this.compra = compra;
    }

    public void passarProduto(Produto produto){
         if(compra != null){

             System.out.println("================= Passou Produto  =================================");
             System.out.println(produto.toString());
             System.out.println("================================================================\n\n");

             compra.AdicionarProduto(produto);
         }
    }

    public boolean finalizarCompra(){
        Desconto descontoLivro = new DescontoAtingiuValorLivros(15);

        boolean bloqueada = this.compra.isBloqueada();

        System.out.println("================= Compra Bloqueada?  ============================");
        System.out.println(bloqueada);
        System.out.println("================================================================\n\n");

        if(!bloqueada){

            System.out.println("================= Compra Possui Desconto?  =========================");
            System.out.println(this.compra.possuir(descontoLivro));
            System.out.println("================================================================\n\n");

            System.out.println("================= Valor Inicial  ===================================");
            System.out.println(this.compra.getValorTotal());
            System.out.println("================================================================\n\n");

            if(this.compra.possuir(descontoLivro)){
                this.compra.aplicar(descontoLivro);

                System.out.println("================= Valor com Desconto  ==========================");
                System.out.println(this.compra.getValorTotal());
                System.out.println("================================================================\n\n");
            }

            this.valorEmCaixa += this.compra.getValorTotal();

            System.out.println("================= Finalizou Compra  ============================");
            System.out.println(this.compra.getValorTotal());
            System.out.println("================================================================\n\n");
        }

        System.out.println("================= Valor em Caixa  ============================");
        System.out.println(this.valorEmCaixa);
        System.out.println("================================================================\n\n");

        return !bloqueada;
    }

}
