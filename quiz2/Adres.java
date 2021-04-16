/*
 * Algoritma ve Programlama-II | Quiz 2 
 * Umut Hökelek
 * 16-04-2021
 */
public class Adres {

    private String sokak, sehir;
    private int binaNo, daireNo;

    public Adres() {
        this("", 0, 0, "");
    }

    public Adres(String sokak, int binaNo, int daireNo, String sehir) {
        this.sokak = sokak;
        this.binaNo = binaNo;
        this.daireNo = daireNo;
        this.sehir = sehir;
    }

    @Override
    public String toString() {
        return getSokak() + " " + getBinaNo() + " " + getDaireNo() + " " + getSehir();
    }

    public boolean equals(Adres digerAdres) {
        return ((sokak == digerAdres.sokak)
                && (binaNo == digerAdres.binaNo)
                && (daireNo == digerAdres.daireNo)
                && (sehir == digerAdres.sehir));
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public int getBinaNo() {
        return binaNo;
    }

    public void setBinaNo(int binaNo) {
        this.binaNo = binaNo;
    }

    public int getDaireNo() {
        return daireNo;
    }

    public void setDaireNo(int daireNo) {
        this.daireNo = daireNo;
    }

}
