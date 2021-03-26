package sk.stuba.fei.uim.oop.hra;

import java.util.Random;

public class Hrac {
    private String meno;
    private double ucet;
    private int pozicia;
    private int kolVoVazeni;
    private boolean bankrot;
    private boolean vHre;
    private boolean kaucia;
    private boolean stojneZdarma;
    private int zranenychKol;

/*
    Metoda, ktora posuva hraca po hracom poli, pokial sa nenachadza vo vazeni. Najskor sa skontroluje, ci je vo vazeni,
    vtedy hrac stravi kolo vo vazeni - skontroluje sa mu ci ma moznost vyplatit sa kauciou.
    Ak ma tuto moznost vygeneruje sa nahodna suma ktoru musi zaplatit. Ak nema na to, aby ju zaplatil, nic sa nedeje,
    tato moznost mu ostane do buducna a znizi sa mu pocet kol ktore musi este stravit vo vazeni.
    Ak ma na kauciu a rozhodne sa ju zaplatit, moze pokracovat vo svojom tahu - hadze kockou, hybe sa.
    Ak hrac nie je vo vazeni, prepocita sa mu nova pozicia, podla toho kolko hodil na kocke.
    Ak si hrac predtym vytiahol kartu Bitka, hybe sa len o polovicny pocet policok (vid trieda Bitka).
    Ked prejde startom (ale nezastane na nom), pripocita sa mu na ucet odmena za prechod startom - fixna cena 2000
 */
    public void posunSa(int oKolko){
        if(kolVoVazeni > 1){
            stravKoloVoVazeni();
        }
        else{
            if(kolVoVazeni== 1){
                kolVoVazeni--;
            }
            this.informuj(oKolko);
            if(zranenychKol > 0 && oKolko > 1){
                oKolko= oKolko/2;
                zranenychKol--;
                System.out.println("Hybes sa o "+oKolko + " policka. Polovicna vzdialenost este "+ zranenychKol + " kola" );
            }
            this.pozicia = this.pozicia + oKolko;
            if(pozicia == 24){
                this.pozicia = 0;
            }
            if (pozicia > 24) {
                System.out.println("Pripisujem na ucet za prechod startom");
                this.pripisNaUcet(2000);
                this.pozicia = this.pozicia % 24;
            }
            System.out.println("Nova pozicia: " + pozicia);
        }
    }

    private void posunSa(){
        Random random= new Random();
        int oKolko= random.nextInt(5)+1;
        this.informuj(oKolko);
        if(zranenychKol > 0 && oKolko > 1){
            oKolko= oKolko/2;
            zranenychKol--;
            System.out.println("Hybes sa o "+oKolko + " policka. Polovicna vzdialenost este "+ zranenychKol + " kola" );
        }
        this.pozicia = this.pozicia + oKolko;
        if(pozicia == 24){
            this.pozicia = 0;
        }
        if (pozicia > 24) {
            System.out.println("Pripisujem na ucet za prechod startom");
            this.pripisNaUcet(2000);
            this.pozicia = this.pozicia % 24;
        }
        System.out.println("Nova pozicia: " + pozicia);
    }

    private void stravKoloVoVazeni(){
        informuj();
        if (kaucia){
            Random random= new Random();
            double cena= random.nextInt(2100)+400;
            System.out.println("Zaplat kauciu "+ cena + " korun a si volny.");
            if(cena > ucet){
                System.out.println("Momentalne nemas na zaplatenie kaucie. Mozno nabuduce.");
            }
            else {
                char volba= Zklavesnice.readChar("Ak chces zaplatit kauciu stlac A, inak N. ");
                volba= Character.toUpperCase(volba);
                while(volba != 'A' && volba != 'N'){
                    System.out.println("Neplatny vstup.");
                    volba= Zklavesnice.readChar("Ak chces zaplatit kauciu stlac A, inak N. ");
                    volba= Character.toUpperCase(volba);
                }
                if(volba == 'A'){
                    this.kaucia= false;
                    this.kolVoVazeni= 1;
                    zaplatCenu(cena);
                    posunSa();
                }
            }
        }
        this.kolVoVazeni--;
        System.out.println("Vo vazeni este na "+ kolVoVazeni + " kola.");
    }

/*
Pomocne funkcie pre vypis
 */
    public void informuj(int kocka){
        System.out.println("Na tahu je hrac: " + meno);
        System.out.println("Zostatok na ucte: " + ucet);
        System.out.println("Aktualna pozicia: " + pozicia);
        System.out.println("Na kocke padlo: "+ Math.abs(kocka));
    }

    private void informuj(){
        System.out.println("Na tahu je hrac: " + meno);
        System.out.println("Zostatok na ucte: " + ucet);
        System.out.println("Policko Vazenie");
    }

    public void zaplatCenu(double cena){
        this.ucet= this.ucet- cena;
    }

    public void pripisNaUcet(double suma){
        this.ucet= this.ucet + suma;
    }

    public void setZranenychKol(int zranenychKol) {
        this.zranenychKol = zranenychKol;
    }

    public void setStojneZdarma(boolean stojneZdarma) {
        this.stojneZdarma = stojneZdarma;
    }

    public void setKaucia(boolean kaucia) {
        this.kaucia = kaucia;
    }

    public boolean isStojneZdarma() {
        return stojneZdarma;
    }

    public boolean isvHre() {
        return vHre;
    }

    public void setvHre(boolean vHre) {
        this.vHre = vHre;
    }

    public boolean isBankrot() {
        return bankrot;
    }

    public void setBankrot(boolean bankrot) {
        this.bankrot = bankrot;
    }

    public void setKolVoVazeni(int kolVoVazeni) {
        this.kolVoVazeni = kolVoVazeni;
    }

    public int getKolVoVazeni() {
        return kolVoVazeni;
    }

    public void setSuma(double sUcet) {
        this.ucet = sUcet;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public double getUcet() {
        return ucet;
    }

    public void setPozicia(int pozicia) {
        this.pozicia = pozicia;
    }

    public int getPozicia() {
        return pozicia;
    }

    public Hrac(){
        this.kolVoVazeni= 0;
        this.bankrot= false;
        this.vHre= true;
    }
}
