package beans;

public enum Ordem {

    DOIS(2),TRES(3),QUATRO(4),CINCO(5),SEIS(6),SETE(7),OITO(8),NOVE(9),DEZ(10),VALETE(11),DAMA(12),REI(13),AS(1);

    private int numero;

    Ordem(int numero){
        numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
       switch (numero){
           case 1:
               return "Ás";
           case 11:
               return "Valete ";
           case 12:
               return "Dama ";
           case 13:
               return "Rei ";
           default:
               return String.valueOf(numero);
       }

    }
}
