package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hraciaPlocha.RohovePolicko;

public class Uvaznenie extends RohovePolicko {
    int pocetKol;

    @Override
    public void akciaPolicka() {
        if(meno.equals("Policia")){
            System.out.println("Ides do vazenia na "+ pocetKol + " kol.");

            stojiTam.setPozicia(6);
            stojiTam.setKolVoVazeni(pocetKol);
        }
        else{
            System.out.println("Navsteva vazenia na 1 kolo");
            stojiTam.setKolVoVazeni(1);
        }
    }

   public int getPocetKol() {
        return pocetKol;
    }

    public void setPocetKol(int pocetKol) {
        this.pocetKol = pocetKol;
    }

   /* public Uvaznenie(int poradoveCislo, String meno, String popis, double suma, int pocetKol) {
        super(poradoveCislo, meno, popis);
        this.suma= suma;
        this.pocetKol= pocetKol;
    }

    public Uvaznenie(int poradoveCislo, String meno, String popis, int pocetKol) {
        super(poradoveCislo, meno, popis);
        this.pocetKol= pocetKol;
    }*/

    public Uvaznenie(int poradoveCislo, String meno, String popis){
        super(poradoveCislo, meno, popis);
    }

    public Uvaznenie(){}
}
