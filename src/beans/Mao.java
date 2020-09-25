package beans;

import java.util.ArrayList;
import java.util.List;

public class Mao {

    private List<Carta> p = new ArrayList<>();
    private int pontos;
    private int pontos2;
    private boolean especial=false;


    public boolean isEspecial() {
        return especial;
    }

    public int getPontos2() {
        return pontos2;
    }

    public List<Carta> getP() {
        return p;
    }
    public void setP(List<Carta> p) {
        this.p = p;
    }
    public void imprimirPontos() {
        if(especial)System.out.println("Pontos: " +pontos + " ou "+ pontos2);
        else
            System.out.println("Pontos: "+pontos);
    }

    public int getPontos(){
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void receber(Deck x) {
        p.add(x.getArray().get(0));
        x.getArray().remove(0);
        contarPontos();
    }

    private void contarPontos() {
        pontos = 0;
        pontos2 = 0;

        if (!especial) {
            for (Carta iterador : p) {
                if (iterador.getNumero() == 1) {
                    especial = true;
                    break;
                }
            }
        }

        if (especial){
        for (Carta iterador :p){
            pontos += iterador.getValor();
        }

        for (Carta iterador : p){
            if ((iterador.getNumero() != 1)) {
                pontos2 += iterador.getValor();
            }
            else {
                pontos2 += 11;
            }
        }
    }
        else {
            for (Carta carta : p) {
                pontos += carta.getValor();
            }
        }
}

    public String toString(){
        return p.toString();
    }
}