/*
 * Algoritma ve Programlama-II | Vize Projesi
 * Umut Hökelek
 */

public class Daire extends GeometrikNesne {
    private double yaricap;
    
    public Daire() {
        super();
        yaricap = 1.0;
    }
    
    public Daire(String etiket, Date tarih, double yaricap) {
        super(etiket, tarih);
        setYaricap(yaricap);
    }

    public Daire(Daire d) {
        if (d == null) {
            System.out.println("Daire nesnesi bos olamaz.");
            System.exit(0);
        }
        super.setEtiket(d.getEtiket());
        super.setTarih(d.getTarih());
        setYaricap(d.getYaricap());
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        if(yaricap < 0) {
            System.out.println("Yaricap degeri sifirdan kucuk olamaz.");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    @Override
    public String toString() {
        return super.toString() + " Yaricap: " + getYaricap();
    }

    @Override
    public double alanHesapla() {
        return Math.PI*yaricap*yaricap; 
    }

    @Override
    public double cevreHesapla() {
        return 2*Math.PI*yaricap;
    }

    @Override 
    public int compareTo(Object o) {

        Daire d = (Daire)o;
        if (getYaricap() > d.getYaricap()) {
            return 1;
        }
        else if(getYaricap() < d.getYaricap()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

