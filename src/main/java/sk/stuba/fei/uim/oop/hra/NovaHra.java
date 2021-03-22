package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.hraciaPlocha.Nehnutelnost;
import sk.stuba.fei.uim.oop.hraciaPlocha.Policko;
import sk.stuba.fei.uim.oop.hraciaPlocha.RohovePolicko;
import sk.stuba.fei.uim.oop.hraciaPlocha.Sance;

import java.util.ArrayList;

public class NovaHra {
    Zklavesnice vstup;
    int pocetHracov;
    ArrayList<Hrac> zoznamHracov;
    ArrayList<Policko> sachovnica;
    //ArrayList<Sance> tahaciBalicek;
    //ArrayList<Sance> odhadzovaciBalicek;
    //kocka?

    public void nacitajHracov(){
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

    public void generSachovnicu(){
        this.sachovnica= new ArrayList<Policko>(24);
        String[] mena = {"Start", "Vazenie", "Policia", "Platba dane"};
        String[] popisy = {"Presiel si startom, dostanes ", "Stojis 1 kolo", "Stojis ", "Musis zaplatit dan "};
        int ktory= 0;

        double suma;
        Policko novePolicko;

        for(int i= 0; i< 24; i++){
            if(i% 6 == 0){
                if(i== 0){
                    suma= 2000;
                    novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                }
                else if (i == 18){
                    suma= 900;
                    novePolicko= new RohovePolicko(i, mena[ktory], popisy[ktory], suma);
                }
                else {
                    novePolicko = new RohovePolicko(i, mena[ktory], popisy[ktory]);
                }
                ktory++;
            }
            else if (i% 6 == 3){
                novePolicko= new Sance(i, "Sanca", "Tahas si kartu");
            }
            else{
                novePolicko= new Nehnutelnost(i, "Nehnutelnost", "Policko nehnutelnosti");
            }

            sachovnica.add(novePolicko);
        }
    }

    public void generKarty(){}

    public void zacniHru(){
        generSachovnicu();
        //nacitajHracov();
    }

    public NovaHra(){
        this.vstup= new Zklavesnice();
    }
}
