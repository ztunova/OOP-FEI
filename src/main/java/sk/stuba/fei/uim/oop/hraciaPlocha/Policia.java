package sk.stuba.fei.uim.oop.hraciaPlocha;

import java.util.Random;

public class Policia extends Policko{
    private int pocetKol;

    @Override
    public void akciaPolicka() {
        Random random= new Random();
        this.pocetKol = random.nextInt(5) + 1;
        System.out.println("Ides do vazenia na "+ pocetKol + " kola.");

        stojiTam.setPozicia(6);
        stojiTam.setKolVoVazeni(pocetKol);
    }

    public Policia(String meno, int poradie){
        this.meno= meno;
        this.poradoveCislo= poradie;
    }

    public Policia(){}
}
