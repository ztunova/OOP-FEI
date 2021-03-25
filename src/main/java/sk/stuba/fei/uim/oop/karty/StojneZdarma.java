package sk.stuba.fei.uim.oop.karty;

public class StojneZdarma extends Karty{
    @Override
    public void akciaKarty() {
        this.ktoVytiahol.setStojneZdarma(true);
    }

    public StojneZdarma(String meno){
        this.druh= meno;
    }

    public StojneZdarma(){}
}
