package sk.stuba.fei.uim.oop.hra;

public class Hrac {
    private String meno;
    private double ucet;
    private int pozicia;
    private int kolVoVazeni;
    boolean bankrot;

    public int posunSa(int oKolko){
        if(kolVoVazeni > 0){
            this.kolVoVazeni= kolVoVazeni -1;
        }
        if(kolVoVazeni == 0) {
            this.pozicia = this.pozicia + oKolko;
            if (pozicia >= 24) {
                System.out.println("prechadzam startom");
                this.pozicia = this.pozicia % 24;
            }
        }
            return pozicia;
    }

    public void zaplatCenu(double cena){
        this.ucet= this.ucet- cena;
    }

    public void pripisNaUcet(double suma){
        this.ucet= this.ucet + suma;
    }

    public boolean isBankrot() {
        return bankrot;
    }

    public void setBankrot(boolean bankrot) {
        this.bankrot = bankrot;
    }

    public void setKolVoVazeni(int kolVoVazeni) {
        this.kolVoVazeni = kolVoVazeni;
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

    public void setPozicia(int pozicia) {
        this.pozicia = pozicia;
    }

    public int getPozicia() {
        return pozicia;
    }

    public Hrac(){
        this.kolVoVazeni= 0;
        this.bankrot= false;
    }
}
