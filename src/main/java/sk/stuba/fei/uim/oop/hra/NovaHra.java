package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.*;
import sk.stuba.fei.uim.oop.karty.Bitka;
import sk.stuba.fei.uim.oop.karty.Karty;
import sk.stuba.fei.uim.oop.karty.Krizovatka;
import sk.stuba.fei.uim.oop.karty.Narodeniny;

import java.util.ArrayList;
import java.util.Random;

public class NovaHra {
    public Zklavesnice vstup;
    public Random random;
    int pocetHracov;
    int hracovVHre;
    ArrayList<Hrac> zoznamHracov;
    ArrayList<Policko> sachovnica;
    //ArrayList<Sance> tahaciBalicek;
    //ArrayList<Sance> odhadzovaciBalicek;
    //kocka?

    private void nacitajHracov(){
        this.pocetHracov= vstup.readInt("zadaj pocet hracov: ");
        this.zoznamHracov= new ArrayList<Hrac>(pocetHracov);

        System.out.println("bude hrat "+pocetHracov+ " hracov");

        String meno;
        int suma= 5000;

        for(int i= 0; i< pocetHracov; i++){
            Hrac novyHrac= new Hrac();
            meno= vstup.readString("zadaj meno " +(i+1) + ". hraca: ");
            novyHrac.setMeno(meno);
            novyHrac.setSuma(suma);

            zoznamHracov.add(novyHrac);
        }

    }

    private void generSachovnicu(){
        ArrayList<Karty> balicek= generKarty();
        this.sachovnica= new ArrayList<Policko>(24);
        String[] mena = {"Start", "Vazenie", "Policia", "Platba dane"};
        String[] popisy = {"Presiel si startom, dostanes ", "Stojis 1 kolo", "Stojis ", "Musis zaplatit dan "};
        int ktory= 0;

        double suma, stojne;
        Policko novePolicko;
        ArrayList<Karty> tahaci= new ArrayList<Karty>();

        for(int i= 0; i< 24; i++){
            if(i% 6 == 0){
                if(i== 0){
                    //cena pri prechode startom
                    suma= 2000;
                    novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                }
                else if (i == 18){
                    //platba dane
                    suma= 900;
                    novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                }
                else {
                    //policia
                    novePolicko = new Uvaznenie(i, mena[ktory], popisy[ktory]);
                }
                ktory++;
            }
            else if (i% 6 == 3){
                novePolicko= new Sance(i, "Sanca", "Tahas si kartu", balicek, tahaci);
            }
            else{
                suma= random.nextInt(5000)+1000;
                stojne= random.nextInt(2000)+500;
                novePolicko= new Nehnutelnost(i, "Nehnutelnost", "Policko nehnutelnosti", suma, stojne);
            }

            sachovnica.add(novePolicko);
        }
    }

    private ArrayList<Karty> generKarty(){
        ArrayList<Karty> balicek= new ArrayList<Karty>(3);
        String popisNarodeniny= "Vsetko najlepsie k narodeninam! Ako darcek dostanes 400 kroun od kazdeho hraca, " +
                                "ktory ma na ucte viac ako 400 korun";
        String popisKrizovatka= "Stojis pred dolezitym rozhodnutim. Pred tebou je krizovatka. Mozes pokracovat" +
                " bud lavou alebo pravou cestou. Volba je na tebe ale vyberaj pozorne. Jedna cesta ta zavedie dalej" +
                "ale ta druha je slepa a budes sa musiet vratit. ";
        String poisBitka= "Niekto sa tu tusim pobil. Nabuduce chod do ringu, tam je to legalne. No a pre tento raz" +
                "zaplat pokutu 500 korun";

        Karty narode= new Narodeniny(this.zoznamHracov, popisNarodeniny, "Narodeniny");
        Karty bitka= new Bitka(poisBitka, "Bitka");
        Karty krizovatka= new Krizovatka(popisKrizovatka, "Krizovatka");

        balicek.add(narode);
        balicek.add(bitka);
        balicek.add(krizovatka);

        return balicek;
    }

    public void zacniHru(){
        //generSachovnicu();
        nacitajHracov();
        generSachovnicu();
        this.hracovVHre= pocetHracov;

        int i, hodKockou, novaPoz;
        int pocitadlo= 0;
        //Hrac naTahu;
        Policko stojiNa;

        //for (i= 0; i< 3; i++){
        while(hracovVHre != 1){

            for (Hrac naTahu : zoznamHracov) {
                if(naTahu.isvHre()) {
                    //naTahu= zoznamHracov.get(pocitadlo%(zoznamHracov.size()));
                /*System.out.println("Na tahu je hrac: " + naTahu.getMeno());
                System.out.println("Zostatok na ucte: " + naTahu.getUcet());
                System.out.println("Aktualna pozicia: " + naTahu.getPozicia());*/

                    hodKockou = random.nextInt(5) + 1;
                    //System.out.println("Na kocke padlo: " + hodKockou);

                    //novaPoz = naTahu.posunSa(hodKockou);
                    naTahu.posunSa(hodKockou);
                    novaPoz = naTahu.getPozicia();

                    stojiNa = sachovnica.get(novaPoz);
                    stojiNa.setStojiTam(naTahu);
                    //naTahu.setPolicko(stojiNa);

                    //System.out.println("Nova pozicia: " + naTahu.getPozicia());
                    System.out.println("Policko " + stojiNa.getMeno());

                    /*if (stojiNa instanceof Uvaznenie) {
                        int pocetKol = random.nextInt(5) + 1;
                        ((Uvaznenie) stojiNa).setPocetKol(pocetKol);
                    }*/

                    if(naTahu.getKolVoVazeni() == 0) {
                        stojiNa.akciaPolicka();
                    }

                    if (naTahu.isBankrot()) {
                        //zoznamHracov.remove(naTahu);
                        naTahu.setvHre(false);
                        hracovVHre = hracovVHre - 1;
                        //System.out.println("Hrac odstraneny");
                    } else {
                        //pocitadlo++;
                        System.out.println("Zostatok na ucte: " + naTahu.getUcet());
                    }
                    System.out.println("-----------------------------------------");
                }
            }
        }

        System.out.println("---------------KONIEC HRY----------------");
        for (Hrac vitaz : zoznamHracov) {
            if(vitaz.isvHre()) {
                System.out.println("Gratulujem, vyhral hrac: " + zoznamHracov.get(0).getMeno());
            }
        }
    }

    public NovaHra(){
        this.vstup= new Zklavesnice();
        this.random= new Random();
    }
}
