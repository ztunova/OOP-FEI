package sk.stuba.fei.uim.oop.karty;

public class Bitka extends Karty{

/*
    Karta Bitka: hrac sa pobije, musi zaplatit pokutu s fixnou cenou 500 korun a kedze sa v bitke zranil nasledujuce
    3 kola moze prejst len polovicnu vzdialenost ako by normalne presiel. Okrem 1 - ked padne 1, posunie sa o 1 policko
    (neostane stat)
 */
    @Override
    public void akciaKarty() {
        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Niekto sa tu tusim pobil. Nabuduce chod do ringu, tam je to legalne. No a pre tento raz zaplat pokutu 500 korun a");
        System.out.println("nasledujuce 3 kola mozes prejst max polovicnu vzdialenost (okrem 1). To zranenie je lepsie setrit.");

        this.ktoVytiahol.zaplatCenu(500);
        this.ktoVytiahol.setZranenychKol(3);
    }

    public Bitka(String meno){
        this.druh= meno;
    }

    public Bitka(){}
}
