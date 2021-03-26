package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.*;
import sk.stuba.fei.uim.oop.karty.*;

import java.util.ArrayList;
import java.util.Random;

public class NovaHra {
    private Random random;
    private int pocetHracov;
    private int hracovVHre;
    private ArrayList<Hrac> zoznamHracov;
    private ArrayList<Policko> sachovnica;

/*
nacitanie daneho poctu hracov a ich mien. Zoznam hracov je atributom hry. Kazdy hrac zacina so sumou 5000
 */
    private void nacitajHracov(){
        this.pocetHracov= Zklavesnice.readInt("zadaj pocet hracov: ");
        this.zoznamHracov= new ArrayList<Hrac>(pocetHracov);

        System.out.println("bude hrat "+pocetHracov+ " hracov");

        String meno;
        int suma= 5000;

        for(int i= 0; i< pocetHracov; i++){
            Hrac novyHrac= new Hrac();
            meno= Zklavesnice.readString("zadaj meno " +(i+1) + ". hraca: ");
            novyHrac.setMeno(meno);
            novyHrac.setSuma(suma);

            zoznamHracov.add(novyHrac);
        }

    }

/*
vytvorenie sachovnice: 24 policok
Rohove policka su v poradi Start, Vazenie, Policia, Platba dane (v smere hodinovych ruciciek)
Policka sance su vzdy v strede medzi rohovymi polickami (3. v poradi od rohu)
Ostatne su nehnutelnosti
Pri prechode startom sa pripisuje hracovi fixna cena 2000
Vyska dane je tiez fixna 900
Cena nehnutelnosti a stojneho na nej sa generuje nahodne pre kazdu nehnutelnost
Zoznam vsetkych policok = sachovnica je atributom hry
 */
    private void generSachovnicu(){
        ArrayList<Karty> balicek= generKarty();
        this.sachovnica= new ArrayList<Policko>(24);

        double suma, stojne;
        Policko novePolicko;
        ArrayList<Karty> tahaci= new ArrayList<Karty>();

        for(int i= 0; i< 24; i++){
            if(i== 0){
                //cena pri prechode startom
                suma= 2000;
                novePolicko= new Start("Start", 0, suma);
            }
            else if(i == 6){
                novePolicko= new Vazenie("Vazenie", 6);
            }
            else if(i == 12){
                novePolicko= new Policia("Policia", 12);
            }
            else if (i == 18){
                //platba dane
                suma= 900;
                novePolicko= new PlatbaDane(suma, 18,"Platba dane");
            }
            else if (i% 6 == 3){
                novePolicko= new Sance(i, "Sanca", balicek, tahaci);
            }
            else{
                suma= random.nextInt(5000)+1000;
                stojne= random.nextInt((int) (suma/2))+400;
                novePolicko= new Nehnutelnost(i, "Nehnutelnost", suma, stojne);
            }

            sachovnica.add(novePolicko);
        }
    }

/*
Vytvorenie zoznamu kariet
Zoznam kariet je atributom policka Sanca - kazde policko sanca obsahuje pointer na rovnaky zoznam kariet
Vytvori sa "odhadzovaci" balicek - obsahuje 5 ks kariet, kazda karta samostatneho druhu
Vymenu odhadzovacieho balicka s tahacim (ked je prazdny) riesi policko Sanca
 */
    private ArrayList<Karty> generKarty(){
        ArrayList<Karty> balicek= new ArrayList<Karty>(3);

        Karty narode= new Narodeniny(this.zoznamHracov, "Narodeniny");
        Karty bitka= new Bitka("Bitka");
        Karty krizovatka= new Krizovatka("Krizovatka");
        Karty kaucia= new Kaucia("Kaucia");
        Karty zlava= new StojneZdarma("Stojne zdarma");

        balicek.add(narode);
        balicek.add(bitka);
        balicek.add(krizovatka);
        balicek.add(kaucia);
        balicek.add(zlava);

        return balicek;
    }

/*
metoda, ktora v pripade, ze je nejaky hrac vyhodeny z hry, prejde celu sachovnicu, pohlada nehnutelnosti
ktore vyradeny hrac vlastnil a oznaci, ze su volne, na predaj
 */
    private void zrusMajetky(Hrac vypadnuty){
        for (Policko policko : sachovnica){
            if(policko instanceof Nehnutelnost && ((Nehnutelnost) policko).getMajitel() == vypadnuty){
                ((Nehnutelnost) policko).setKupena(false);
                ((Nehnutelnost) policko).setMajitel(null);
            }
        }
    }

/*
metoda ktora simuluje samotnu hru - urcenie hracov, vytvorenie sachovnice, hraci sa striedaju na tahu, pricom sa
vykonava akcia policka na ktore stupili, pripadne sa nevykonava, pokial hrac stoji vo vazeni.
Zaroven kontroluje, ci hrac vypadol z hry alebo nie. Na konci vypise vitaza
 */
    public void zacniHru(){
        nacitajHracov();
        generSachovnicu();
        this.hracovVHre= pocetHracov;

        int hodKockou, novaPoz;
        Policko stojiNa;

        while(hracovVHre != 1){

            for (Hrac naTahu : zoznamHracov) {
                if(naTahu.isvHre()) {
                    hodKockou = random.nextInt(5) + 1;
                    naTahu.posunSa(hodKockou);
                    novaPoz = naTahu.getPozicia();

                    stojiNa = sachovnica.get(novaPoz);
                    stojiNa.setStojiTam(naTahu);

                    if(naTahu.getKolVoVazeni() == 0) {
                        System.out.println("Policko " + stojiNa.getMeno());
                        stojiNa.akciaPolicka();
                    }

                    if (naTahu.isBankrot()) {
                        zrusMajetky(naTahu);
                        naTahu.setvHre(false);
                        hracovVHre = hracovVHre - 1;
                        if(hracovVHre == 1){
                            break;
                        }
                    }
                    else {
                        System.out.println("Zostatok na ucte: " + naTahu.getUcet());
                    }
                    System.out.println("-----------------------------------------");
                }
            }
        }

        System.out.println("---------------KONIEC HRY----------------");
        for (Hrac vitaz : zoznamHracov) {
            if(vitaz.isvHre()) {
                System.out.println("Gratulujem, vyhral hrac: " + vitaz.getMeno());
            }
        }
    }

    public NovaHra(){
        this.random= new Random();
    }
}
