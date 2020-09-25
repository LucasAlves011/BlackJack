import beans.Deck;
import beans.Mesa;

import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int quantiDecks;

        do {
            System.out.println("Com quantos deck's deseja jogar ?< Mínimo de 2 >");
            quantiDecks = ler.nextInt();
        }while (quantiDecks <= 1 );

        Mesa mesa = new Mesa(quantiDecks);

    do {
        mesa.inicioDeJogo();
    do {
        mesa.imprimirJogo();
        mesa.escolha();

    }while (mesa.verificarBanca() == 0 && mesa.verificarJogador() == 0);

    if (mesa.verificarJogador() < 0){
        mesa.imprimirJogo();

        System.out.println("\n\n---------------> Você estourou <---------------\n\n");

    }
    else if(mesa.verificarJogador() > 0){
        mesa.imprimirJogo();

        System.out.println("\n\n--------------->Você ganhou <---------------\n\n");

        }
    else if (mesa.verificarBanca() < 0){
        mesa.imprimirJogo();

        System.out.println("\n\n--------------->A banca estorou <---------------\n\n");


    }
    else if (mesa.verificarBanca() > 0){
        mesa.imprimirJogo();

        System.out.println("\n\n--------------->A banca ganhou <---------------\n\n");
    }
        ler.nextLine();
        System.out.println("Pressione enter para continuar");
        ler.nextLine();

    mesa.resetarMaos();
    mesa.setRodadas(mesa.getRodadas()+1);

    if (mesa.getDeck().getArray().size() == 2) mesa.embaralharCartas(quantiDecks);

    }while (mesa.getDeck().getArray().size() > 1);

    }
}
