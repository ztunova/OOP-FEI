package sk.stuba.fei.uim.oop.hra;

public class Hrac {
    private String meno;
    private double ucet;
    private int pozicia;

    public int posunSa(int oKolko){
        this.pozicia= this.pozicia + oKolko;
        if (pozicia >= 24){
            System.out.println("prechadzam startom");
            this.pozicia= this.pozicia %24;
        }
        return pozicia;
    }

    public void zaplatCenu(double cena){
        this.ucet= this.ucet- cena;
    }

    public void pripisNaUcet(double suma){
        this.ucet= this.ucet + suma;
    }

    public void setSuma(double sUcet) {
        this.ucet = sUcet;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public double getUcet() {
        return ucet;
    }

    public int getPozicia() {
        return pozicia;
    }
}
