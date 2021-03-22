package sk.stuba.fei.uim.oop.hra;

public class Hrac {
    private String meno;
    private double ucet;
    private int pozicia;

    public void hodKockou(){}

    public void zaplatCenu(double cena){
        this.ucet= this.ucet- cena;
    }

    public void pripisNaUcet(double suma){
        this.ucet= this.ucet + suma;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setSuma(double sUcet) {
        this.ucet = sUcet;
    }

    public String getMeno() {
        return meno;
    }

    public double getUcet() {
        return ucet;
    }
}
