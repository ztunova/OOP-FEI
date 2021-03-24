package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.NovaHra;
import sk.stuba.fei.uim.oop.hra.Zklavesnice;

import java.util.Random;

public class Krizovatka extends Karty{
    private boolean prava;
    private boolean lava;

    @Override
    public void akciaKarty() {
        generKrizovatku();
        System.out.println(this.popisAkcie);
        //Zklavesnice vstup= new Zklavesnice();
        char volba= Zklavesnice.readChar("Zadaj L ak chces pokracovat lavou cestou, P ak si si vybral pravu cestu");
        volba= Character.toUpperCase(volba);
        System.out.println("Hadz kockou o kolko policok sa posunies bud dopredu alebo dozadu.");
        int kocka= random.nextInt(5)+1;
        System.out.println("Na kocke padlo: "+ kocka);
        switch (volba){
            case 'L':
                if(lava){
                    //posun sa dalej
                    this.ktoVytiahol.posunSa(kocka);
                }
                else{
                    //vrat sa naspat
                    this.ktoVytiahol.posunSa(-kocka);
                }
                break;
            case 'P':
                if(prava){
                    //posun sa dalej
                    this.ktoVytiahol.posunSa(kocka);
                }
                else{
                    //vrat sa naspat
                    this.ktoVytiahol.posunSa(-kocka);
                }
                break;
            default:
                System.out.println("Neplatny vstup, zadaj L alebo P");
        }
    }

    private void generKrizovatku(){
        this.prava= random.nextBoolean();
        this.lava= !prava;
    }
}
