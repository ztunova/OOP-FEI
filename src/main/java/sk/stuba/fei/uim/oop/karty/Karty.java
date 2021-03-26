package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.Random;

public abstract class Karty {
    protected String druh;
    protected Hrac ktoVytiahol;
    protected Random random;

    public abstract void akciaKarty();

    public void setKtoVytiahol(Hrac ktoVytiahol) {
        this.ktoVytiahol = ktoVytiahol;
    }

    public Karty(){
        this.random= new Random();
    }

}
