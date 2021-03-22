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
            System.out.println("Tato nehnutelnost je na predaj. Jej cena je " + this.kupnaCena +" korun. Chces ju kupit? ");

            Zklavesnice vstup= new Zklavesnice();
            char volba= vstup.readChar("Stlac A ak nehnutelnost chces kupit, ak nie, stlac N");
            volba= Character.toUpperCase(volba);
            System.out.println("zvolil si: "+ volba);
            switch (volba){
                case 'A':
                    System.out.println("Prave si kupil nehnutelnost");
                    //this.stojiTam.zaplatCenu(this.kupnaCena);
                    this.kupena= true;
                   // this.majitel= this.stojiTam;
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
            System.out.println("Majitel: ");
            System.out.println("Musis mu zaplatit stojne "+ this.stojne);
            //na tahu. zaplat stojne
        }

    }

    public Nehnutelnost(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public Nehnutelnost(double kupnaCena, double stojne) {
        this.kupnaCena = kupnaCena;
        this.stojne= stojne;
        this.kupena= false;
        this.majitel= null;
    }

    public Nehnutelnost(){
        this.kupena= false;
        this.majitel= null;
    }
}
