package beans;

public enum Naipes {

    OUROS("Ouros \u2666\ufe0f"),COPAS("Copas \u2665\ufe0f"),ESPADAS("Espadas \u2660\ufe0f"),PAUS("Paus \u2663\ufe0f");

    private String descri;

    Naipes(String descri){
        this.descri = descri;
    }

    public String getDescri() {
        return this.descri;
    }

}