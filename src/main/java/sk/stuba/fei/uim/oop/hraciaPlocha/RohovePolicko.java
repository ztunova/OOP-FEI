package sk.stuba.fei.uim.oop.hraciaPlocha;

import sk.stuba.fei.uim.oop.hraciaPlocha.Policko;

public class RohovePolicko extends Policko {
    double suma;

    @Override
    public void akciaPolicka() {
        double povodnaSuma= this.stojiTam.getUcet();
        if(this.meno.equals("Start")){
            povodnaSuma= povodnaSuma + this.suma;
            this.stojiTam.setSuma(povodnaSuma);
        }
        else if (this.meno.equals("Platba dane")){
            this.stojiTam.zaplatCenu(this.suma);
        }
        else{
            System.out.println("Ani start ani dan");
        }
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
