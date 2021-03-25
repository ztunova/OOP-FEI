package sk.stuba.fei.uim.oop.karty;

public class Kaucia extends Karty{
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
