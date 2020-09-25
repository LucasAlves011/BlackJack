package beans;

public class Carta {

    private int ordem;
    private int valor;
    private	Naipes naipe;

    public Carta(int numero, int valor, Naipes naipe) {
        this.ordem = numero;
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getNumero() {
        return ordem;
    }

    public void setNumero(int numero) {
        this.ordem = numero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Naipes getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipes naipe) {
        this.naipe = naipe;
    }

    public String tString() {
        return " Ordem = " + ordem + ", Valor = " + valor + ", Naipe = " + naipe.getDescri() + "\n";
    }

    @Override
    public String toString(){
       switch (ordem){
           case 1:
               return "| As de " + naipe.getDescri();
           case 11:
               return "| Valete de " + naipe.getDescri();
           case 12:
               return "| Dama de " + naipe.getDescri();
           case 13:
               return "| Rei de " + naipe.getDescri();
           default:
               return "| "+valor+ " de "+naipe.getDescri();
       }
    }


}