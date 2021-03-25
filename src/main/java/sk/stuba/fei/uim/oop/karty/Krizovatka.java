package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Zklavesnice;

public class Krizovatka extends Karty{
    private boolean prava;
    private boolean lava;

    @Override
    public void akciaKarty() {
        generKrizovatku();
        //System.out.println(this.popisAkcie);

        System.out.println("Efekt vytiahnutej karty: ");
        System.out.println("Stojis pred dolezitym rozhodnutim. Pred tebou je krizovatka. Mozes pokracovat bud lavou alebo pravou cestou.");
        //System.out.println("Mozes pokracovat bud lavou alebo pravou cestou. Volba je na tebe ale vyberaj pozorne.");
        System.out.println("Volba je na tebe ale vyberaj pozorne. Jedna cesta ta zavedie dalej ale ta druha je slepa a budes sa musiet vratit.");
        System.out.println("Kolko padne na kocke, o tolko policok sa posunies bud dopredu alebo dozadu.");

        char volba= Zklavesnice.readChar("Zadaj L ak chces pokracovat lavou cestou, P ak si si vybral pravu cestu");
        volba= Character.toUpperCase(volba);
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

    /*public Krizovatka(String popis, String meno){
        this.popisAkcie= popis;
        this.druh= meno;
    }*/

    public Krizovatka(String meno){
        this.druh= meno;
    }

    public Krizovatka(){}
}
