package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class NovaHra {
    Zklavesnice vstup;
    int pocetHracov;
    ArrayList<Hrac> zoznamHracov;
    //zoznam kariet
    //sachovnica
    //kocka?

    public void nacitajHracov(){
        this.pocetHracov= vstup.readInt("zadaj pocet hracov: ");
        zoznamHracov= new ArrayList<Hrac>(pocetHracov);

        System.out.println("bude hrat "+pocetHracov+ " hracov");

        for(int i= 0; i< pocetHracov; i++){

        }
    }

    public void generSachovnicu(){}

    public void generKarty(){}

    public void hodKockou(){}

    public void zacniHru(){}

    public NovaHra(){
        this.vstup= new Zklavesnice();
    }
}
