package sk.stuba.fei.uim.oop.karty;

public class StojneZdarma extends Karty{
/*
Karta Stojne zdarma: nastavi hracovi, ktory kartu vytiahol moznost stojneho zdarma. To znamena, ze ked bude musiet
najblizsie platit stojne, tak to robit nebude. Plati to pre najblizsie stojne - hrac nema moznost si vybrat kedy
chce stojne platit a kedy nie.
Tato metoda hracovi len nastavi priznak, ze stojne platit nemusi - to ze ho realne neplati je osetrene v triede Nehnutelnost
 */
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
