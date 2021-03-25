package sk.stuba.fei.uim.oop.hraciaPlocha;

public class PlatbaDane extends Policko{
    private double suma;

    @Override
    public void akciaPolicka() {
        System.out.println("Platba dane "+ suma + " korun");
        if(suma > stojiTam.getUcet()){
            System.out.println("Nemas na zaplatenie dane. Zbankrotoval si, vypadavas z hry.");
            stojiTam.setBankrot(true);
            return;
        }
        this.stojiTam.zaplatCenu(this.suma);
    }

    public PlatbaDane(double cena, int poradie, String meno){
        this.suma= cena;
        this.poradoveCislo= poradie;
        this.meno= meno;
    }

    public PlatbaDane(){}
}
