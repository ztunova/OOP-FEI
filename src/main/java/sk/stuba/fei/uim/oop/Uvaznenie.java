package sk.stuba.fei.uim.oop;

public class Uvaznenie extends RohovePolicko{
    int pocetKol;

    @Override
    public void akciaPolicka() {}

    public int getPocetKol() {
        return pocetKol;
    }

    public void setPocetKol(int pocetKol) {
        this.pocetKol = pocetKol;
    }

    public Uvaznenie(int poradoveCislo, String meno, String popis, double suma, int pocetKol) {
        super(poradoveCislo, meno, popis);
        this.suma= suma;
        this.pocetKol= pocetKol;
    }

    public Uvaznenie(int poradoveCislo, String meno, String popis, int pocetKol) {
        super(poradoveCislo, meno, popis);
        this.pocetKol= pocetKol;
    }

    public Uvaznenie(){}
}
