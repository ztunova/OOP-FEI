package sk.stuba.fei.uim.oop.karty;

public class Bitka extends Karty{

    @Override
    public void akciaKarty() {
        //System.out.println(this.popisAkcie);

        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Niekto sa tu tusim pobil. Nabuduce chod do ringu, tam je to legalne. No a pre tento raz zaplat pokutu 500 korun");

        this.ktoVytiahol.zaplatCenu(500);
        this.ktoVytiahol.setKolVoVazeni(1);
    }

   /* public Bitka(String popis, String meno){
        this.popisAkcie= popis;
        this.druh= meno;
    }*/

    public Bitka(String meno){
        this.druh= meno;
    }

    public Bitka(){}
}
