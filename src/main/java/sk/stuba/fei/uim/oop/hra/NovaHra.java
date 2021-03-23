package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.*;

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
        this.sachovnica= new ArrayList<Policko>(24);
        String[] mena = {"Start", "Vazenie", "Policia", "Platba dane"};
        String[] popisy = {"Presiel si startom, dostanes ", "Stojis 1 kolo", "Stojis ", "Musis zaplatit dan "};
        int ktory= 0;

        double suma, stojne;
        Policko novePolicko;

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
                novePolicko= new Sance(i, "Sanca", "Tahas si kartu");
            }
            else{
                suma= random.nextInt(5000)+1000;
                stojne= random.nextInt(2000)+500;
                novePolicko= new Nehnutelnost(i, "Nehnutelnost", "Policko nehnutelnosti", suma, stojne);
            }

            sachovnica.add(novePolicko);
        }
    }

    public void generKarty(){}

    public void zacniHru(){
        generSachovnicu();
        nacitajHracov();
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

                    if (stojiNa instanceof Uvaznenie) {
                        int pocetKol = random.nextInt(5) + 1;
                        ((Uvaznenie) stojiNa).setPocetKol(pocetKol);
                    }

                    stojiNa.akciaPolicka();

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
