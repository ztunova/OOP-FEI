package sk.stuba.fei.uim.oop.hraciaPlocha;

public class Start extends Policko{
    private double cena;

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
