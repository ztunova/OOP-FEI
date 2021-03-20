package sk.stuba.fei.uim.oop;

public class Nehnutelnost extends Policko{
    boolean kupena;
    Hrac majitel;
    double kupnaCena;
    double stojne;

    @Override
    public void akciaPolicka() {

    }

    public Nehnutelnost(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public Nehnutelnost(double kupnaCena, double stojne) {
        this.kupnaCena = kupnaCena;
        this.stojne= stojne;
        this.kupena= false;
        this.majitel= null;
    }

    public Nehnutelnost(){
        this.kupena= false;
        this.majitel= null;
    }
}
