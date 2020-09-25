package beans;

import java.util.Scanner;

public class Mesa {

    private Deck deck;
    private Mao banca;
    private Mao jogador;
    private int rodadas = 0;

    public int getRodadas() {
        return rodadas;
    }

    public void setRodadas(int rodadas) {
        this.rodadas = rodadas;
    }

    public Deck getDeck() {
        return deck;
    }

    public void embaralharCartas(int x){
        deck = new Deck(x);
    }

    public Mesa(int quantDeck){
        deck = new Deck(quantDeck);
        banca = new Mao();
        jogador = new Mao();
    }

    public void inicioDeJogo(){
       banca.receber(deck);
       jogador.receber(deck);
       jogador.receber(deck);
    }

    public void escolha(){
        Scanner ler = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("Oque deseja fazer ? \n1 - Receber carta |2 - Parar");
            x = ler.nextInt();
            if (x == 1) {
                jogador.receber(deck);
            } else if (x == 2) {
                banca.receber(deck);
                System.out.println("Invalido");
            }
        }while (x != 1&& x != 2);
    }

    //não deu tempo de terminar isso
    public boolean bancaGanha(){
        // 1 a banca ganha e 0 a banca perde
       //banca e jogador são especiais
        if (banca.getPontos2() == 21 || banca.getPontos() == 21) return true;
        if (banca.isEspecial() && jogador.isEspecial()){
            if ((banca.getPontos() > jogador.getPontos() && banca.getPontos() <= 21 ) || (banca.getPontos() > jogador.getPontos2() && banca.getPontos() <= 21)){
               return true;
            }
            else if ((banca.getPontos2() > jogador.getPontos() && banca.getPontos() <= 21) || (banca.getPontos2() > jogador.getPontos2() && banca.getPontos2() <= 21)){
                return true;
            }

        }
        //jogador especial
        else if (!banca.isEspecial() && jogador.isEspecial()){
            if (jogador.getPontos() < banca.getPontos() && banca.getPontos() <= 21){
                return true;
            }
            else if (jogador.getPontos() < banca.getPontos2() && banca.getPontos2() <= 21){
                return true;
            }
        }
        //nenhum especial
        else if (!banca.isEspecial() && !jogador.isEspecial()){
            if (banca.getPontos() > jogador.getPontos() && banca.getPontos() <= 21){
                return true;
            }
        }
        //banca especial
        else if (banca.isEspecial() && !jogador.isEspecial()){
            if (banca.getPontos() > jogador.getPontos() && banca.getPontos() <= 21 ){
                return true;
            }
            else if (banca.getPontos() > jogador.getPontos2() && banca.getPontos() <= 21){
                return true;
            }

        }
        return false;
    }

    public void resetarMaos(){
        banca = new Mao();
        jogador = new Mao();
    }

    public void imprimirJogo(){
        System.out.println("\t\t\t\tRodada "+ (rodadas+1) );
        System.out.println("***************************************************************************");
        System.out.println("Número de cartas no baralho: " + deck.getArray().size());
        System.out.println("Cartas da banca:");
        System.out.println(banca.toString());
        banca.imprimirPontos();
        System.out.println("---------------------------------------x---------------------------------------");
        System.out.println("Suas cartas:");
        System.out.println(jogador.toString());
        jogador.imprimirPontos();

    }

    public int verificarJogador(){
       // 0 continua o jogo , -1 jogador perdeu, 1 jogador ganhou
        int retorno = 0;

        if (jogador.isEspecial()){

            if (jogador.getPontos() > 21 && jogador.getPontos2() > 21){
               retorno = -1;
            }
            else if (jogador.getPontos() == 21 || jogador.getPontos2() == 21){
                retorno = 1;
            }
        }
        else {
            if (jogador.getPontos() > 21 ){
                retorno = -1;
            }
            else if (jogador.getPontos() == 21){
                retorno = 1;
            }
        }
        return retorno;
    }

    public int verificarBanca(){
        // 0 continua o jogo , -1 jogador perdeu, 1 jogador ganhou
        int retorno = 0;

        if (banca.isEspecial()){

            if (banca.getPontos() > 21 && banca.getPontos2() > 21){
                retorno = -1;
            }
            else if (banca.getPontos() == 21 || banca.getPontos2() == 21){
                retorno = 1;
            }
        }
        else {
            if (banca.getPontos() > 21 ){
                retorno = -1;
            }
            else if (banca.getPontos() == 21){
                retorno = 1;
            }
        }
        return retorno;
    }





}
