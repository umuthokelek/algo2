/*
 * Algoritma ve Programlama-II | Quiz 2 
 * Umut Hökelek
 * 16-04-2021
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {

        String maxAdSoyad = "", maxSokak = "", maxSehir = "";
        int maxOgrNo = 0, maxBinaNo = 0, maxDaireNo = 0;
        double maxOrt = 0.0;
        Adres ogrAdres = null;
        Student ogrenci = null;
        Scanner dosya = null;

        try {
            dosya = new Scanner(new FileInputStream("girdiQuiz2.txt"));

            while (dosya.hasNext()) {
                int ogrNo = Integer.parseInt(dosya.next());
                String ogrAdSoyad = dosya.next() + " " + dosya.next();
                double ortalama = Double.parseDouble(dosya.next());
                String sokak = dosya.next() + " " + dosya.next();
                int binaNo = Integer.parseInt(dosya.next());
                int daireNo = Integer.parseInt(dosya.next());
                String sehir = dosya.next();

                ogrAdres = new Adres(sokak, binaNo, daireNo, sehir);
                ogrenci = new Student(ogrNo, ogrAdSoyad, ortalama, ogrAdres);

                System.out.println(
                        ogrenci.getOgrNo() + " "
                        + ogrenci.getAdSoyad() + " "
                        + ogrenci.getOrtalama() + " "
                        + ogrAdres.getSokak() + " "
                        + ogrAdres.getBinaNo() + " "
                        + ogrAdres.getDaireNo() + " "
                        + ogrAdres.getSehir()
                );
                if (ogrenci.getOrtalama() > maxOrt) {
                    maxAdSoyad = ogrenci.getAdSoyad();
                    maxSokak = ogrAdres.getSokak();
                    maxSehir = ogrAdres.getSehir();
                    maxOgrNo = ogrenci.getOgrNo();
                    maxBinaNo = ogrAdres.getBinaNo();
                    maxDaireNo = ogrAdres.getDaireNo();
                    maxOrt = ogrenci.getOrtalama();
                }
            }

            System.out.println("\nEn yüksek not ortalamasına sahip öğrencinin bilgileri: "
                    + maxOgrNo + " "
                    + maxAdSoyad + " "
                    + maxOrt + " "
                    + maxSokak + " "
                    + maxBinaNo + " "
                    + maxDaireNo + " "
                    + maxSehir
            );
            System.out.println("Oluşturulan toplam Student nesnesi sayısı: " + Student.getSayac());
            dosya.close();
        } catch (FileNotFoundException e) {
            System.out.print("Dosya bulunamadı");
            System.exit(0);
        }

    }
}
