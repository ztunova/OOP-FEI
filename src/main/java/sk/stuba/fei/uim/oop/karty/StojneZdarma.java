package sk.stuba.fei.uim.oop.karty;

public class StojneZdarma extends Karty{
    @Override
    public void akciaKarty() {
        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Najblizsie stojne mas zdarma.");
        this.ktoVytiahol.setStojneZdarma(true);
    }

    public StojneZdarma(String meno){
        this.druh= meno;
    }

    public StojneZdarma(){}
}
