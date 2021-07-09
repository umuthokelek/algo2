/*
 * Algoritma ve Programlama-II | Vize Projesi
 * Umut Hökelek
 */

public class Silindir extends GeometrikNesne {
    private double yaricap;
    private double uzunluk;
    
    public Silindir() {
        super();
        yaricap = 1.0;
        uzunluk = 1.0;
    }

    public Silindir(String etiket, Date tarih, double yaricap, double uzunluk) {
        super(etiket, tarih);
        setYaricap(yaricap);
        setUzunluk(uzunluk);
    }
    
    public Silindir(Silindir s) {
        if (s == null) {
            System.out.println("Silindir nesnesi bos olamaz.");
            System.exit(0);
        }
        super.setEtiket(s.getEtiket());
        super.setTarih(s.getTarih());
        setYaricap(s.getYaricap());
        setUzunluk(s.getUzunluk());
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        if(yaricap < 0) {
            System.out.println("Yaricap degeri sifirdan kucuk olamaz");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        if(uzunluk < 0) {
            System.out.println("Uzunluk degeri sifirdan kucuk olamaz");
            System.exit(0);
        }
        this.uzunluk = uzunluk;
    }

    @Override
    public String toString() {
        return super.toString() + " Yaricap: " + getYaricap() + " Uzunluk: " + getUzunluk();
    }

    public double hacimHesapla() {
        return Math.PI*getYaricap()*getYaricap()*getUzunluk();
    }

    @Override
    public double alanHesapla() {
        return 2*getYaricap()*Math.PI*(getYaricap()+getUzunluk());
    }
    
    @Override
    public double cevreHesapla() {
        return (2*2*getYaricap()*Math.PI) + (2*getUzunluk());
    }
    
    @Override 
    public int compareTo(Object o) {
        Silindir s = (Silindir)o;
        if (hacimHesapla() > s.hacimHesapla()) {
            return 1;
        }
        else if(hacimHesapla() < s.hacimHesapla()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

