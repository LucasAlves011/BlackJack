package beans;

public enum Escolhas {

    HIT(1),STOP(2);

    private int esc;

    Escolhas(int esc){
        this.esc = esc;
    }

    public int getEsc() {
        return esc;
    }
}
