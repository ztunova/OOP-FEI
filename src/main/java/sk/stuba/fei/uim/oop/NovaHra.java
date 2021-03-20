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
        this.zoznamHracov= new ArrayList<Hrac>(pocetHracov);

        System.out.println("bude hrat "+pocetHracov+ " hracov");

        String meno;
        int suma= 0;

        for(int i= 0; i< pocetHracov; i++){
            Hrac novyHrac= new Hrac();
            meno= vstup.readString("zadaj meno " +(i+1) + ". hraca: ");
            novyHrac.setMeno(meno);
            novyHrac.setSuma(suma);

            zoznamHracov.add(novyHrac);
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
