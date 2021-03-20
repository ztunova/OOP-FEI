package sk.stuba.fei.uim.oop;

public class RohovePolicko extends Policko{
    double suma;

    @Override
    public void akciaPolicka() {

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
