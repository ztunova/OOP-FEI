package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.Random;

/*
vseobecna abstraktna trieda Karta z ktorej dedia ostatne karty sance - tie ktore uz aj maju nejaky efekt
 */
public abstract class Karty {
    protected String druh;
    protected Hrac ktoVytiahol;
    protected Random random;

/*
metoda akciakarty musi byt prekonana v kazdej odvodenej triede - kazda karta ma svoju akciu ale vzdy nejaku inu
 */
    public abstract void akciaKarty();

    public void setKtoVytiahol(Hrac ktoVytiahol) {
        this.ktoVytiahol = ktoVytiahol;
    }

    public Karty(){
        this.random= new Random();
    }

}
