package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.*;
import sk.stuba.fei.uim.oop.karty.*;

import java.util.ArrayList;
import java.util.Random;

public class NovaHra {
    public Random random;
    int pocetHracov;
    int hracovVHre;
    ArrayList<Hrac> zoznamHracov;
    ArrayList<Policko> sachovnica;


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

    private void generSachovnicu(){
        ArrayList<Karty> balicek= generKarty();
        this.sachovnica= new ArrayList<Policko>(24);
       // String[] mena = {"Start", "Vazenie", "Policia", "Platba dane"};
        //String[] popisy = {"Presiel si startom, dostanes ", "Stojis 1 kolo", "Stojis ", "Musis zaplatit dan "};
        int ktory= 0;

        double suma, stojne;
        Policko novePolicko;
        ArrayList<Karty> tahaci= new ArrayList<Karty>();

        for(int i= 0; i< 24; i++){
            if(i== 0){
                //cena pri prechode startom
                suma= 2000;
                //novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                //novePolicko= new RohovePolicko(i, mena[ktory], suma);
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
                // novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                novePolicko= new PlatbaDane(suma, 18,"Platba dane");
            }
            /*else {
                //policia
                novePolicko = new Uvaznenie(i, mena[ktory], popisy[ktory]);
            }
            //ktory++;*/

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

    private ArrayList<Karty> generKarty(){
        ArrayList<Karty> balicek= new ArrayList<Karty>(3);
        /*String popisNarodeniny= "Vsetko najlepsie k narodeninam! Ako darcek dostanes 400 kroun od kazdeho hraca, " +
                                "ktory ma na ucte viac ako 400 korun";
        String popisKrizovatka= "Stojis pred dolezitym rozhodnutim. Pred tebou je krizovatka. Mozes pokracovat" +
                " bud lavou alebo pravou cestou. Volba je na tebe ale vyberaj pozorne. Jedna cesta ta zavedie dalej" +
                "ale ta druha je slepa a budes sa musiet vratit. ";
        String poisBitka= "Niekto sa tu tusim pobil. Nabuduce chod do ringu, tam je to legalne. No a pre tento raz" +
                "zaplat pokutu 500 korun";

        Karty narode= new Narodeniny(this.zoznamHracov, popisNarodeniny, "Narodeniny");
        Karty bitka= new Bitka(poisBitka, "Bitka");
        Karty krizovatka= new Krizovatka(popisKrizovatka, "Krizovatka");*/

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

    private void zrusMajetky(Hrac vypadnuty){
        for (Policko policko : sachovnica){
            if(policko instanceof Nehnutelnost && ((Nehnutelnost) policko).getMajitel() == vypadnuty){
                ((Nehnutelnost) policko).setKupena(false);
                ((Nehnutelnost) policko).setMajitel(null);
            }
        }
    }

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
                    //naTahu.informuj(hodKockou);
                    naTahu.posunSa(hodKockou);
                    novaPoz = naTahu.getPozicia();

                    stojiNa = sachovnica.get(novaPoz);
                    stojiNa.setStojiTam(naTahu);

                    //System.out.println("Policko " + stojiNa.getMeno());

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
            //System.out.println(vitaz.getMeno());
            if(vitaz.isvHre()) {
                System.out.println("Gratulujem, vyhral hrac: " + vitaz.getMeno());
            }
        }
    }

    public NovaHra(){
        this.random= new Random();
    }
}
