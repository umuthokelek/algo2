/*
 * Algoritma ve Programlama-II | Quiz 2 
 * Umut Hökelek
 * 16-04-2021
 */
public class Student {

    private int ogrNo;
    private String adSoyad;
    private double ortalama;
    private Adres ogrAdres;

    private static int sayac;

    public Student() {
        this(0, "", 0.0, null);
    }

    public Student(int ogrNo, String adSoyad, double ortalama, Adres ogrAdres) {
        this.ogrNo = ogrNo;
        this.adSoyad = adSoyad;
        this.ortalama = ortalama;
        this.ogrAdres = ogrAdres;
        sayac++;
    }

    public String toString() {
        return getOgrNo() + " "
                + getAdSoyad() + " "
                + getOrtalama() + " "
                + ogrAdres.getSokak() + " "
                + ogrAdres.getBinaNo() + " "
                + ogrAdres.getDaireNo() + " "
                + ogrAdres.getSehir();
    }

    public boolean equals(Student digerOgrenci) {
        return ((ogrNo == digerOgrenci.ogrNo)
                && (adSoyad == digerOgrenci.adSoyad)
                && (ortalama == digerOgrenci.ortalama)
                && (ogrAdres == digerOgrenci.ogrAdres));
    }

    public int getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(int ogrNo) {
        this.ogrNo = ogrNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public double getOrtalama() {
        return ortalama;
    }

    public void setOrtalama(double ortalama) {
        this.ortalama = ortalama;
    }

    public static int getSayac() {
        return sayac;
    }

    public Adres getOgrAdres() {
        return ogrAdres;
    }

    public void setOgrAdres(Adres ogrAdres) {
        this.ogrAdres = ogrAdres;
    }

}
