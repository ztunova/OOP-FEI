package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public class Narodeniny extends Karty{
    private ArrayList<Hrac> zoznamHracov;

/*
Karta Narodeniny: Hrac ma narodeniny a ako darcek dostane od kazdeho hraca darcek 400 korun.
Ak niektory z hracov nema na ucte viac ako 400 korun, na darcek neprispieva.
Metoda prejde zoznam vsetkych hrajucich hracov, skontroluje ci maju na to, aby zaplatili - ak ano tak im odpise z uctu
a tomu, kto kartu vytiahol na ucet pripise fixnu sumu 400 korun
 */
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
