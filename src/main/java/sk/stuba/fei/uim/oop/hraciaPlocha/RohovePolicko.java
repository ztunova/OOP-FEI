package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hraciaPlocha.Policko;

public class RohovePolicko extends Policko {
    double suma;

    @Override
    public void akciaPolicka() {
        double povodnaSuma= this.stojiTam.getUcet();
        if(this.meno.equals("Start")){
            System.out.println("Presiel si startom");
            //this.stojiTam.pripisNaUcet(suma);
        }
        else /*if (this.meno.equals("Platba dane"))*/{
            System.out.println("Platba dane "+ suma + " korun");
            if(suma > stojiTam.getUcet()){
                System.out.println("Nemas na zaplatenie dane. Zbankrotoval si, vypadavas z hry.");
                stojiTam.setBankrot(true);
                return;
            }
            this.stojiTam.zaplatCenu(this.suma);
        }
        /*else{
            System.out.println("Ani start ani dan");
        }*/
        //this.stojiTam.setSuma(povodnaSuma);
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public RohovePolicko(int poradoveCislo, String meno, String popis, double suma) {
        super(poradoveCislo, meno, popis);
        this.suma= suma;
    }

    public RohovePolicko(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public RohovePolicko(){}
}
