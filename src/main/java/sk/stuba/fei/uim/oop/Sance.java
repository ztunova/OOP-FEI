package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Sance extends Policko{
    String akcia;

    public void akcia1(){/*od kazdeho hraca dostane 200 korun*/}
    public void akcia2(){/* musi zaplatit poplatok 500 korun ako pokutu*/}
    public void akcia3(){/*vrati sa o 2 policka naspat*/}
    public void akcia4(){/*posunie sa o 2 policka dopredu*/}
    public void akcia5(){/*prepustenie z vazenia na kauciu*/}
    public void zamiesajKarty(){}


    @Override
    public void akciaPolicka() {

    }

    public Sance(int poradoveCislo, String meno, String popis) {
        super(poradoveCislo, meno, popis);
    }

    public Sance(){}
}
