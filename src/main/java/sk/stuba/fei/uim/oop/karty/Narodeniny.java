package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public class Narodeniny extends Karty{
    private ArrayList<Hrac> zoznamHracov;

    @Override
    public void akciaKarty() {
        System.out.println(this.popisAkcie);

        for (Hrac hrac : zoznamHracov){
            if (hrac.isvHre() && hrac.getUcet() > 400){
                hrac.zaplatCenu(400);
                this.ktoVytiahol.pripisNaUcet(400);
            }
        }
    }

    public Narodeniny(ArrayList<Hrac> hraci, String popis, String meno){
        this.popisAkcie= popis;
        this.druh= meno;
        this.zoznamHracov= hraci;
    }

    public Narodeniny(){}
}
