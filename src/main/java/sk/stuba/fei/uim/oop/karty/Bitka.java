package sk.stuba.fei.uim.oop.karty;

public class Bitka extends Karty{

    @Override
    public void akciaKarty() {
        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Niekto sa tu tusim pobil. Nabuduce chod do ringu, tam je to legalne. No a pre tento raz zaplat pokutu 500 korun a");
        System.out.println("nasledujuce 3 kola mozes prejst max polovicnu vzdialenost (okrem 1)");

        this.ktoVytiahol.zaplatCenu(500);
        this.ktoVytiahol.setZranenychKol(3);
    }

    public Bitka(String meno){
        this.druh= meno;
    }

    public Bitka(){}
}
