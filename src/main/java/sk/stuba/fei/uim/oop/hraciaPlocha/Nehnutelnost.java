package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Zklavesnice;

public class Nehnutelnost extends Policko {
    private boolean kupena;
    private Hrac majitel;
    private double kupnaCena;
    private double stojne;

    @Override
    public void akciaPolicka() {
        if (!kupena){
            System.out.println("Tato nehnutelnost je na predaj. Jej cena je " + this.kupnaCena +" korun. " +
                                "Stojne na nej je "+ stojne + " korun. Chces ju kupit? ");
            if(kupnaCena > stojiTam.getUcet()){
                System.out.println("NA TUTO NEHNUTELNOST NEMAS DOSTATOK FINANCII!");
                return;
            }

            //Zklavesnice vstup= new Zklavesnice();
            char volba= Zklavesnice.readChar("Stlac A ak nehnutelnost chces kupit, ak nie, stlac N");
            volba= Character.toUpperCase(volba);
            //System.out.println("zvolil si: "+ volba);

            while(volba != 'A' && volba != 'N'){
                System.out.println("Neplatny vstup.");
                volba= Zklavesnice.readChar("Stlac A ak nehnutelnost chces kupit, ak nie, stlac N");
                volba= Character.toUpperCase(volba);
            }

            switch (volba){
                case 'A':
                    this.majitel= stojiTam;
                    this.majitel.zaplatCenu(kupnaCena);
                    System.out.println("Prave si kupil nehnutelnost");
                    this.kupena= true;
                    break;
                case 'N':
                    System.out.println("Rozhodol si sa nekupit nehnutelnost.");
                    break;
                default:
                    System.out.println("Neplatny vstup, zadaj A alebo N");
            }
        }
        else{
            System.out.println("Tato nehnutelnost nie je na predaj. ");
            System.out.println("Majitel: "+ majitel.getMeno());
            if(stojiTam.isStojneZdarma()){
                System.out.println("Minas sancu na stojne zdarma. ");
                this.stojiTam.setStojneZdarma(false);
            }
            else {
                System.out.println("Musis mu zaplatit stojne " + this.stojne);
                //na tahu. zaplat stojne, majitel. pripis na ucet
                if (stojne > stojiTam.getUcet()) {
                    System.out.println("Nemas na zaplatenie stojneho. Zbankrotoval si, vypadavas z hry.");
                    stojiTam.setBankrot(true);
                    return;
                }
                stojiTam.zaplatCenu(this.stojne);
                majitel.pripisNaUcet(this.stojne);
            }
        }

    }

    public Nehnutelnost(int poradoveCislo, String meno, double cena, double stojne) {
        this.poradoveCislo= poradoveCislo;
        this.meno= meno;
        this.kupnaCena= cena;
        this.stojne= stojne;
    }

   /* public Nehnutelnost(int poradoveCislo, String meno, String popis, double cena, double stojne) {
        super(poradoveCislo, meno, popis);
        this.kupnaCena= cena;
        this.stojne= stojne;
    }*/

    /*public Nehnutelnost(double kupnaCena, double stojne) {
        this.kupnaCena = kupnaCena;
        this.stojne= stojne;
        this.kupena= false;
        this.majitel= null;
    }*/

    public Nehnutelnost(){
        this.kupena= false;
        this.majitel= null;
    }
}
