import beans.Deck;
import beans.Escolhas;
import beans.Mao;

import java.util.Collections;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        int jogo =0;
        Scanner ler = new Scanner(System.in);
        Escolhas escolha ;
        int rodadas = 0;


        Mao mao = new Mao();
        Mao banca = new Mao();
        int quantiDecks ;
        boolean controlDeFluxo = true;

        System.out.println("Vamos jogar \n Com quantos deck's deseja jogar ?!");
            quantiDecks = ler.nextInt();
        Deck deck = new Deck(quantiDecks);
        while(jogo == 0){
            if (controlDeFluxo){
                mao.receber(deck);
                mao.receber(deck);
                banca.receber(deck);
                controlDeFluxo=false;
            }
            System.out.println("***************************************************************************");
            System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
            System.out.println("Número de cartas no baralho: " + deck.getArray().size());
            System.out.println("Cartas da banca:");
            System.out.println(banca.toString());
            banca.imprimirPontos();
            System.out.println("---------------------------------------x---------------------------------------");
            System.out.println("Suas cartas:");
            System.out.println(mao.toString());
            mao.imprimirPontos();
            System.out.println("\nOque deseja fazer ?\n 1- Receber Carta | 2 - Parar ");
            if (ler.nextInt() == 1) escolha = Escolhas.HIT;
            else escolha = Escolhas.STOP;



            switch (escolha){

                case HIT:
                    mao.receber(deck);
                    break;
                case STOP:
                    do {
                        banca.receber(deck);
                    }while (banca.getPontos() <= 21 && banca.getPontos2() <=21);
                    break;

                default:
                    System.out.println("invalido");
                    break;
            }

            ler.nextLine();
            if (banca.isEspecial()){
                if (banca.getPontos() == 21 || banca.getPontos2() == 21){
                    jogo =1;
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
                }
                else if (banca.getPontos2() > 21 && banca.getPontos2() > 21){
                    jogo = 2;
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
                }
            }
            else {
                if (banca.getPontos() == 21) {
                    jogo =1;
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
                }
                else if (banca.getPontos() > 21) {
                    jogo=2;
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
            }

            if (mao.isEspecial()){
                if (mao.getPontos() > 21 && mao.getPontos2()>21){
                    jogo = 1;
//                    mao.receber(deck);
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
//                    jogo = 2;
                }
                else if (mao.getPontos2() == 21 || mao.getPontos() == 21){
//                    mao.receber(deck);
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
                    jogo = 2;
                }
            }else {
                if (mao.getPontos() > 21) {
                    jogo = 1;
//                    mao.receber(deck);
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
//                    jogo = 2;
                } else if (mao.getPontos() == 21) {
//                    mao.receber(deck);
                    System.out.println("***************************************************************************");
                    System.out.println("\t\t\t\t Rodada : "+ (rodadas+1));
                    System.out.println("Número de cartas no baralho: " + deck.getArray().size());
                    System.out.println("Cartas da banca:");
                    System.out.println(banca.toString());
                    banca.imprimirPontos();
                    System.out.println("---------------------------------------x---------------------------------------");
                    System.out.println("Suas cartas:");
                    System.out.println(mao.toString());
                    mao.imprimirPontos();
                    jogo = 2;
                }
            }

            if (jogo == 1){
                System.out.println("\n\n ----------> Você perdeu <----------\n\nPressione enter para iniciar a próxima rodada");
                ler.nextLine();
            }
            else if (jogo == 2){
                System.out.println("\n\n ----------> Você ganhou , O deus do BlackJack<----------\n\n");
                ler.nextLine();
            }
            if (jogo == 1 || jogo == 2){
                mao = new Mao();
                banca = new Mao();
                controlDeFluxo = true;
                jogo = 0;
                rodadas++;
            }

            if (deck.getArray().size() == 1){
                deck = new Deck(quantiDecks);
            }

        }



    }

}
}

