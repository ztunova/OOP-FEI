package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.Policko;

public class Hrac {
    private String meno;
    private double ucet;
    private int pozicia;
    private int kolVoVazeni;
    boolean bankrot;
    boolean vHre;
   // private Policko policko;

    public void posunSa(int oKolko){
        if(kolVoVazeni > 0){
            this.informuj();
            this.kolVoVazeni--;
            System.out.println("Vo vazeni este na "+ kolVoVazeni + " kol.");
        }
        if(kolVoVazeni == 0) {
            this.informuj(oKolko);
            this.pozicia = this.pozicia + oKolko;
            if (pozicia >= 24) {
                System.out.println("Presiel si startom. ");
                //this.ucet= ucet+
                this.pozicia = this.pozicia % 24;
            }
            System.out.println("Nova pozicia: " + pozicia);
        }
        //return pozicia;
    }

    public void informuj(int kocka){
        System.out.println("Na tahu je hrac: " + meno);
        System.out.println("Zostatok na ucte: " + ucet);
        System.out.println("Aktualna pozicia: " + pozicia);
        System.out.println("Na kocke padlo: "+ kocka);
    }

    public void informuj(){
        System.out.println("Na tahu je hrac: " + meno);
        System.out.println("Zostatok na ucte: " + ucet);
    }

    public void zaplatCenu(double cena){
        this.ucet= this.ucet- cena;
    }

    public void pripisNaUcet(double suma){
        this.ucet= this.ucet + suma;
    }

   /* public void setPolicko(Policko policko) {
        this.policko = policko;
    }*/

    public boolean isvHre() {
        return vHre;
    }

    public void setvHre(boolean vHre) {
        this.vHre = vHre;
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

    public int getKolVoVazeni() {
        return kolVoVazeni;
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
        this.vHre= true;
    }
}
