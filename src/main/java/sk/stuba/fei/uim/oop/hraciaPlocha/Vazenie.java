package sk.stuba.fei.uim.oop.hraciaPlocha;

public class Vazenie extends Policko{

    @Override
    public void akciaPolicka() {
        System.out.println("Navsteva vazenia na 1 kolo");
        stojiTam.setKolVoVazeni(1);
    }

    public Vazenie(String meno, int poradie){
        this.meno= meno;
        this.poradoveCislo= poradie;
    }

    public Vazenie(){}
}
