/*
 * Algoritma ve Programlama-II | Final Odevi
 * Umut Hökelek
 */
package finalodeviumuthokelek;

import java.util.ArrayList;

public class CustomerInfo {

    private String adSoyad;
    private String adres;
    private ArrayList<String> telefon;

    public CustomerInfo() {
        telefon = new ArrayList<String>();
    }
    public CustomerInfo(String adSoyad, String adres, ArrayList<String> telefon) {
        this();
        setAdSoyad(adSoyad);
        setAdres(adres);
        setTelefon(telefon);
    }
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }
    public String getAdSoyad() {
        return adSoyad;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public String getAdres() {
        return adres;
    }
    public void setTelefon(ArrayList<String> telefon) {
        for (String tel : telefon) {
            this.telefon.add(tel);
        }
    }
    public ArrayList<String> getTelefon() {
        return new ArrayList<String>(telefon);
    }
    @Override
    public String toString() {

        String returnString = getAdSoyad() + "," + getAdres();

        for (String tel : telefon) {
            returnString += "," + tel;
        }
        return returnString;
    }
    
    public String getAd() {
        String[] ad = getAdSoyad().toLowerCase().split(" ");
        return ad[0];
    }
    
    public String getSoyad() {
        String[] soyad = getAdSoyad().toLowerCase().split(" ");
        return soyad[soyad.length-1];
    }


}
