package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public class Narodeniny extends Karty{
    private ArrayList<Hrac> zoznamHracov;

    @Override
    public void akciaKarty() {
        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Vsetko najlepsie k narodeninam! Ako darcek dostanes 400 kroun od kazdeho hraca, ktory ma na ucte viac ako 400 korun");

        for (Hrac hrac : zoznamHracov){
            if (hrac.isvHre() && hrac.getUcet() > 400){
                hrac.zaplatCenu(400);
                this.ktoVytiahol.pripisNaUcet(400);
            }
        }
    }

    public Narodeniny(ArrayList<Hrac> hraci, String meno){
        this.druh= meno;
        this.zoznamHracov= hraci;
    }

    public Narodeniny(){}
}
