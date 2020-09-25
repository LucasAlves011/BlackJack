package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Carta> array;

    public Deck(int quantidade) {
        array = new ArrayList<Carta>();
        array = construir(quantidade);
        Collections.shuffle(array);
        Collections.shuffle(array);
        Collections.shuffle(array);
        Collections.shuffle(array);
    }

    public List<Carta> getArray() {
        return array;
    }

    public void setArray(List<Carta> array) {
        this.array = array;
    }


    private List<Carta> construir(int quantidade){
        Carta x1;
        List<Carta> temp = new ArrayList<Carta>();

        for(int x = 0; x < quantidade; x++) {
            //OUROS
            for(int i = 0 ; i < 13; i++) {
                if(i+1 < 10) x1 = new Carta(i+1,i+1,Naipes.OUROS);
                else {x1 = new Carta(i+1,10,Naipes.OUROS);}
                temp.add(x1);
            }
            //ESPADAS
            for(int i = 0 ; i < 13; i++) {
                if(i+1 < 10) x1 = new Carta(i+1,i+1,Naipes.ESPADAS);

                else {x1 = new Carta(i+1,10,Naipes.ESPADAS);}
                temp.add(x1);
            }
            //COPAS
            for(int i = 0 ; i < 13; i++) {
                if(i+1 < 10) x1 = new Carta(i+1,i+1,Naipes.COPAS);

                else {x1 = new Carta(i+1,10,Naipes.COPAS);}
                temp.add(x1);
            }
            //PAUS
            for(int i = 0 ; i < 13; i++) {
                if(i+1 < 10) x1 = new Carta(i+1,i+1,Naipes.PAUS);

                else { x1 = new Carta(i+1,10,Naipes.PAUS);}

                temp.add(x1);
            }
        }

        return temp;
    }

    @Override
    public String toString() {
        return "Deck array=" + array + "\n";
    }

    public Carta escolher() {
        Carta temp;
        temp = array.get(0);
        array.remove(0);
        return temp;
    }
}