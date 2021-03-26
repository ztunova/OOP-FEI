package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Zklavesnice;

public class Nehnutelnost extends Policko {
    private boolean kupena;
    private Hrac majitel;
    private double kupnaCena;
    private double stojne;

/*
kontroluje ci je dana nehnutelnost na predaj.
Ak este nie je kupena, ponukne hracovi ci si ju chce kupit (pokial na to ma). Ak ju chce kupit tak za nu zaplati a stane
sa jej majitelom, ak ju nechce kupit nic sa nedeje.
Ak je nehnutelnost uz predana inemu hracovi, metoda kontroluje ci je hrac, ktory tu stoji zaroven jej majitelom -> potom
neplati stojne. Pripadne ci ma hrac sancu stojneho zdarma - vtedy stojne neplati ale tato moznost sa mu zrusi => dalsie
stojne uz bude musiet paltit.
Ak hrac nie je ani majitel ani nema stojne zdarma tak zaplati za stojne, pricom sa este kontroluje, ci ma na ucte dost
aby stojne zaplatil - ak nie, vypadava z hry
 */
    @Override
    public void akciaPolicka() {
        if (!kupena){
            System.out.println("Tato nehnutelnost je na predaj. Jej cena je " + this.kupnaCena +" korun. " +
                                "Stojne na nej je "+ stojne + " korun. Chces ju kupit? ");
            if(kupnaCena > stojiTam.getUcet()){
                System.out.println("NA TUTO NEHNUTELNOST NEMAS DOSTATOK FINANCII!");
                return;
            }

            char volba= Zklavesnice.readChar("Stlac A ak nehnutelnost chces kupit, ak nie, stlac N");
            volba= Character.toUpperCase(volba);

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
            if(stojiTam.isStojneZdarma() && this.majitel != this.stojiTam){
                System.out.println("Minas sancu na stojne zdarma. ");
                this.stojiTam.setStojneZdarma(false);
            }
            else {
                if(this.majitel != this.stojiTam) {
                    System.out.println("Musis mu zaplatit stojne " + this.stojne);
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

    }

    public Hrac getMajitel() {
        return majitel;
    }

    public void setMajitel(Hrac majitel) {
        this.majitel = majitel;
    }

    public void setKupena(boolean kupena) {
        this.kupena = kupena;
    }

    public Nehnutelnost(int poradoveCislo, String meno, double cena, double stojne) {
        this.poradoveCislo= poradoveCislo;
        this.meno= meno;
        this.kupnaCena= cena;
        this.stojne= stojne;
    }

    public Nehnutelnost(){
        this.kupena= false;
        this.majitel= null;
    }
}
