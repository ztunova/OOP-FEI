package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public abstract class Karty {
    protected String druh;
    protected String popisAkcie;
    protected Hrac ktoVytiahol;

    public abstract void akciaKarty();

    public void setKtoVytiahol(Hrac ktoVytiahol) {
        this.ktoVytiahol = ktoVytiahol;
    }

    public Karty(String meno, String popis){
        this.druh= meno;
        this.popisAkcie= popis;
    }

    public Karty(){}

    /*public void akciaSance(ArrayList<Hrac> zoznamHracov){
        System.out.println("");
    }*/
    //public void akcia2(){/* musi zaplatit poplatok 500 korun ako pokutu*/}
   // public void akcia3(){/*vrati sa o 2 policka naspat*/}
   // public void akcia4(){/*posunie sa o 2 policka dopredu*/}
   // public void akcia5(){/*prepustenie z vazenia na kauciu*/}
}
