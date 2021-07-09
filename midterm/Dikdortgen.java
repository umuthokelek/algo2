/*
 * Algoritma ve Programlama-II | Vize Projesi
 * Umut Hökelek
 */

public class Dikdortgen extends GeometrikNesne {
    private double en;
    private double boy;

    public Dikdortgen() {
        super();
        en = 1.0;
        boy = 1.0;
    }
    
    public Dikdortgen(String etiket, Date tarih, double en, double boy) {
        super(etiket, tarih);
        setEn(en);
        setBoy(boy);
    }

    public Dikdortgen(Dikdortgen d) {
        if (d == null) {
            System.out.println("Dikdortgen nesnesi bos olamaz.");
            System.exit(0);
        }
        super.setEtiket(d.getEtiket());
        super.setTarih(d.getTarih());
        setEn(d.getEn());
        setBoy(d.getBoy());
    }
    public double getEn() {
        return en;
    }
    public void setEn(double en) {
        if(en < 0) {
            System.out.println("En degeri sifirdan kucuk olamaz.");
            System.exit(0);
        }
        this.en = en;
    }
    public double getBoy() {
        return boy;
    }
    public void setBoy(double boy) {
        if(boy < 0) {
            System.out.println("Boy degeri sifidan kucuk olamaz.");
            System.exit(0);
        }
        this.boy = boy;
    }
    
    public String toString() {
        return super.toString() + " En: " + getEn() + " Boy: " + getBoy();
    }
    
    @Override
    public double alanHesapla() {
        return en*boy;
    }
    
    @Override
    public double cevreHesapla() {
        return 2*(en+boy);
    }
    
    @Override 
    public int compareTo(Object o) {
        Dikdortgen d = (Dikdortgen)o;

        if (alanHesapla() > d.alanHesapla()) {
            return 1;
        }
        else if(alanHesapla() < d.alanHesapla()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

