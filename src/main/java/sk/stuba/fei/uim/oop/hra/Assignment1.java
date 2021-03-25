package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hraciaPlocha.Nehnutelnost;
import sk.stuba.fei.uim.oop.hraciaPlocha.Policko;
//import sk.stuba.fei.uim.oop.hraciaPlocha.RohovePolicko;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Assignment1 {
    public static void main(String[] args) {
        /*
        Zklavesnice vstup= new Zklavesnice();
        int pokus= vstup.readInt("ciselny vstup: ");
        System.out.println(pokus);*/

        NovaHra hra= new NovaHra();
        hra.zacniHru();
       // hra.nacitajHracov();
       // Random rand= new Random();

        /*for(int i= 0; i<5; i++){
            System.out.println(rand.nextInt(10));
        }

        for(int i= 0; i<5; i++){
            System.out.println(rand.nextDouble());
        }*/

       /* RohovePolicko roh= new RohovePolicko(1, "Prve", "pokusne", 22.0);
        Uvaznenie vazenie= new Uvaznenie(2, "Druhe","pokusne 2" ,30.0, 3);*/
        //System.out.println("pomoc");

        /*Policko policko= new RohovePolicko(1, "Start", "Popis1", 500);
        Policko dan= new RohovePolicko(1, "Platba dane", "Popis2", 200);
        Policko dom= new Nehnutelnost(250, 50);
        Hrac hrac= new Hrac();
        System.out.println(hrac.getUcet());

        policko.setStojiTam(hrac);
        dan.setStojiTam(hrac);
        policko.akciaPolicka();
        System.out.println(hrac.getUcet());
        dan.akciaPolicka();
        System.out.println(hrac.getUcet());
        dom.akciaPolicka();*/

        /*double num = 1.34567;
        System.out.println(num);
        System.out.format("%.2f", num);*/

    }
}
