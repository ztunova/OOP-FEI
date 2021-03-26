package sk.stuba.fei.uim.oop.hraciaPlocha;

public class Start extends Policko{
    private double cena;

/*
pripise hracovi odmenu za prechod startom. Tato akcia sa vykonava len ak hrac priamo zastane na policku start, preto
ked cez neho len prejde a zastane niekde dalej sa pripisuje odmena v triede hrac
 */
    @Override
    public void akciaPolicka() {
        System.out.println("Bonus "+ cena +" korun za prechod startom ");
        this.stojiTam.pripisNaUcet(cena);
    }

    public Start(String meno, int poradie, double cena){
        this.cena= cena;
        this.poradoveCislo= poradie;
        this.meno= meno;
    }

    public Start(){}
}
