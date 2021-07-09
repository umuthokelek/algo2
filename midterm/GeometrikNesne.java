/*
 * Algoritma ve Programlama-II | Vize Projesi
 * Umut Hökelek
 */

public abstract class GeometrikNesne implements Comparable<Object> {
    private String etiket;
    private Date tarih;
    
    public GeometrikNesne() {
       tarih = new Date(); 
    }

    public GeometrikNesne(String etiket, Date tarih) {
        setEtiket(etiket);
        setTarih(tarih);
    }

    public GeometrikNesne(GeometrikNesne n) {
        if (n == null)
        {
             System.out.println("Nesne bos olamaz.");
             System.exit(0);
        }
        setEtiket(etiket);
        setTarih(tarih);
    }

    public String getEtiket() {
        return etiket;
    }
    
    public void setEtiket(String etiket){
        if (etiket == null)
        {
             System.out.println("Etiket degeri bos birakilamaz.");
             System.exit(0);
        }
        this.etiket = etiket;
    }

    public Date getTarih() {
        return new Date(tarih); 
    }

    public void setTarih(Date tarih) {
        if (tarih == null)
        {
             System.out.println("Tarih degeri bos olamaz.");
             System.exit(0);
        }
        this.tarih = new Date(tarih);
    }
    
    @Override
    public String toString() {
        return "Etiket: " + getEtiket() + " Tarih: " + getTarih();
    }

    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    public abstract int compareTo(Object o);
}

