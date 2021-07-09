/*
 * Algoritma ve Programlama II | Quiz 4
 * Umut Hökelek
 */
package quiz4umuthokelek;

public class Customer {
    private String id;
    private String adSoyad;
    public Customer(String id, String adSoyad) {
        setId(id);
        setAdSoyad(adSoyad);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
        else {
            System.out.println("id bos olamaz");
        }
    }
    public String getAdSoyad() {
        return adSoyad;
    }
    public void setAdSoyad(String adSoyad) {
        if(adSoyad != null) {
            this.adSoyad = adSoyad;
        }
        else {
            System.out.println("adSoyad bos olamaz");
        }
    }
    @Override
    public String toString() {
        return "ID: " + id + " Ad, soyad: " + adSoyad;
    }

}

