package sk.stuba.fei.uim.oop.karty;

public class Bitka extends Karty{

    @Override
    public void akciaKarty() {
        System.out.println(this.popisAkcie);

        this.ktoVytiahol.zaplatCenu(500);
        this.ktoVytiahol.setKolVoVazeni(1);
    }
}
