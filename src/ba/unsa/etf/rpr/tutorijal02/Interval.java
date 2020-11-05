package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;
    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada) throws IllegalArgumentException {
  if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("pocetna tacka veca od krajnje");
     pocetna = pocetnaTacka;
     krajnja = krajnjaTacka;
     this.pocetnaPripada = pocetnaPripada;
     this.krajnjaPripada = krajnjaPripada;
    }

    public Interval() {
        pocetna = 0;
        krajnja = 0;
    pocetnaPripada = false;
    krajnjaPripada = false;
    }

    public boolean f(double x, double y) {
        if(Math.abs(x-y) < 10e-16) return true;
return false;
    }

public boolean isNull() {
        return (pocetna == 0 && krajnja == 0 && pocetnaPripada == false && pocetnaPripada == false);
}

public boolean isIn(double tacka) {   // napravit funkciju koja poredi double sa nekim eps
        if(tacka < pocetna && tacka > krajnja) return false;
        if(tacka > pocetna && tacka < krajnja) return true;
         else if(pocetnaPripada== true && tacka == pocetna) return true;
    else if(krajnjaPripada == true && tacka == krajnja) return true;
    return false;
    }
    public Interval intersect(Interval drugiInterval) {
        Interval prvaPoRedu = drugiInterval;
        if(pocetna <= drugiInterval.pocetna) prvaPoRedu = this;
        Interval drugaPoRedu = this;
        if(prvaPoRedu == this) drugaPoRedu = drugiInterval;

        if(drugaPoRedu.pocetna > prvaPoRedu.krajnja) return new Interval();
        double novaPocetnaTacka;
        boolean novaPrvaPripada = false;
        if(drugaPoRedu.isIn(prvaPoRedu.pocetna)) {
            novaPocetnaTacka = prvaPoRedu.pocetna;
        }
        else novaPocetnaTacka = drugaPoRedu.pocetna;

        if(drugaPoRedu.isIn(novaPocetnaTacka) && prvaPoRedu.isIn(novaPocetnaTacka)) novaPrvaPripada = true;

        double novaKrajnjaTacka;
        boolean novaDrugaPripada = false;
            if(drugaPoRedu.isIn(prvaPoRedu.krajnja)) {

                novaKrajnjaTacka = prvaPoRedu.krajnja;
            }
            else novaKrajnjaTacka = drugaPoRedu.krajnja;
        if(drugaPoRedu.isIn(novaKrajnjaTacka) && prvaPoRedu.isIn(novaKrajnjaTacka)) novaDrugaPripada = true;


        return new Interval(novaPocetnaTacka, novaKrajnjaTacka, novaPrvaPripada, novaDrugaPripada);
    }


    public static Interval intersect(Interval prviInterval, Interval drugiInterval) {
        return prviInterval.intersect(drugiInterval);
    }


@Override
    public String toString() {
        String rez = "";
   if(pocetnaPripada == true) rez+="[";
   else rez+="(";
  if(pocetna != 0 && krajnja != 0) rez = rez + pocetna + "," + krajnja;
   if(krajnjaPripada == true)  rez+="]";
   else rez+=")";
return rez;
}

@Override
public boolean equals(Object o) { // mogu ovo implementirat preko intersect
        Interval tmp = (Interval)o;
        return(pocetnaPripada == tmp.pocetnaPripada && krajnjaPripada == tmp.krajnjaPripada && pocetna == tmp.pocetna && krajnja == tmp.krajnja);
    }





}
