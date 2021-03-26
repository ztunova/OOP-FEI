package sk.stuba.fei.uim.oop.karty;

public class Kaucia extends Karty{

/*
Karta Kaucia: hracovi sa v jeho atributoch nastavi moznost zaplatit za seba kauciu ked sa dostane do vazenia
Kartu je mozne vyuzit az od prveho kola po tom, co bude uvazneny.
Po vyuziti tejto moznosti, zaplati stanovenu sumu a moze pokracovat vo svojom tahu.
 */
    @Override
    public void akciaKarty() {
        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Ked budes nabuduce vo vazeni, mozes namiesto statia zaplatit za seba kauciu");
        System.out.println("Plati az od 1. kola po uvazneni.");
        this.ktoVytiahol.setKaucia(true);
    }

    public Kaucia(String meno){
        this.druh= meno;
    }

    public Kaucia(){}
}
