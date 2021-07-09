/*
 * Algoritma ve Programlama-II | Vize Projesi
 * Umut Hökelek
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Deneme {
    public static void main(String[] args) {
    
        Scanner dosya = null;
        int sayac = 0;

        GeometrikNesne dizi[] = new GeometrikNesne[satirSayisi()+3];

        try {
            dosya = new Scanner(new FileInputStream("input.txt"));
            while (dosya.hasNext()) {
                String sekil = dosya.next();
                String etiket = dosya.next();
                
                if(sekil.equals("daire")) {
                    double yaricap = Double.parseDouble(dosya.next());
                    dosya.next();
                    int ay = Integer.parseInt(dosya.next());
                    int gun = Integer.parseInt(dosya.next());
                    int yil = Integer.parseInt(dosya.next());
                    dizi[sayac] = new Daire(etiket, new Date(ay,gun,yil), yaricap);
                }
                else if(sekil.equals("dikdortgen")) {
                    double en = Double.parseDouble(dosya.next());
                    double boy = Double.parseDouble(dosya.next());
                    dosya.next();
                    int ay = Integer.parseInt(dosya.next());
                    int gun = Integer.parseInt(dosya.next());
                    int yil = Integer.parseInt(dosya.next());
                    dizi[sayac] = new Dikdortgen(etiket, new Date(ay,gun,yil), en, boy);
                }   
                else if(sekil.equals("silindir")) {
                    double yaricap = Double.parseDouble(dosya.next());
                    double uzunluk = Double.parseDouble(dosya.next());
                    dosya.next();
                    int ay = Integer.parseInt(dosya.next());
                    int gun = Integer.parseInt(dosya.next());
                    int yil = Integer.parseInt(dosya.next());
                    dizi[sayac] = new Silindir(etiket, new Date(ay,gun,yil), yaricap, uzunluk);
                }
                else {
                    System.out.println(sekil + " isimli bir sekil tanimli degil.");
                    System.exit(0);
                }
                sayac++;
            }

            Daire copyDaire = null;
            Dikdortgen copyDikdortgen = null;
            Silindir copySilindir = null;

            for (int i = 0; i < sayac; i++) {
                if(dizi[i] instanceof Daire) {
                    copyDaire = new Daire((Daire)dizi[i]);
                }
                if(dizi[i] instanceof Dikdortgen) {
                    copyDikdortgen = new Dikdortgen((Dikdortgen)dizi[i]);
                }
                if(dizi[i] instanceof Silindir) {
                    copySilindir = new Silindir((Silindir)dizi[i]);
                }
            }


            dizi[sayac] = new Daire(copyDaire);
            sayac++;
            dizi[sayac] = new Dikdortgen(copyDikdortgen);
            sayac++;
            dizi[sayac] = new Silindir(copySilindir);
            sayac++;

            dosya.close();
        } 
        catch (FileNotFoundException e) {
            System.out.print("Dosya bulunamadı");
            System.exit(0);
        }

        System.out.println("polymorphicYazdir:");
        for (int i = 0; i < sayac; i++) {
            System.out.println(polymorphicYazdir(dizi[i]));
        }
        
        System.out.println();
        
        int daireSayisi = 0;
        int dikdortgenSayisi = 0;
        int silindirSayisi = 0;

        for (int i = 0; i < sayac; i++) {
            if(dizi[i] instanceof Daire) {
                daireSayisi++;
            }
            if(dizi[i] instanceof Dikdortgen) {
                dikdortgenSayisi++;
            }
            if(dizi[i] instanceof Silindir) {
                silindirSayisi++;
            }
        }

        int daireIndex = 1;
        Daire ilkDaire = null;
        Daire sonDaire = null;
        Daire sondanBirOncekiDaire = null;

        int dikdortgenIndex = 1;
        Dikdortgen ilkDikdortgen = null;
        Dikdortgen sonDikdortgen = null;
        Dikdortgen sondanBirOncekiDikdortgen = null;

        int silindirIndex = 1;
        Silindir ilkSilindir = null;
        Silindir sonSilindir = null;
        Silindir sondanBirOncekiSilindir = null;

        for (int i = 0; i < sayac; i++) {
            if (dizi[i] instanceof Daire) {
                if(daireIndex == 1) {
                    ilkDaire = new Daire((Daire)dizi[i]);
                }
                else if(daireIndex == daireSayisi-1) {
                    sondanBirOncekiDaire = new Daire((Daire)dizi[i]);
                }
                else if(daireIndex == daireSayisi) {
                    sonDaire = new Daire((Daire)dizi[i]);
                }
                daireIndex++;
            }

            if (dizi[i] instanceof Dikdortgen) {
                if(dikdortgenIndex == 1) {
                    ilkDikdortgen = new Dikdortgen((Dikdortgen)dizi[i]);
                }
                else if(dikdortgenIndex == dikdortgenSayisi-1) {
                    sondanBirOncekiDikdortgen = new Dikdortgen((Dikdortgen)dizi[i]);
                }
                else if(dikdortgenIndex == dikdortgenSayisi) {
                    sonDikdortgen = new Dikdortgen((Dikdortgen)dizi[i]);
                }
                dikdortgenIndex++;
            }

            if (dizi[i] instanceof Silindir) {
                if(silindirIndex == 1) {
                    ilkSilindir = new Silindir((Silindir)dizi[i]);
                }
                else if(silindirIndex == silindirSayisi-1) {
                    sondanBirOncekiSilindir = new Silindir((Silindir)dizi[i]);
                }
                else if(silindirIndex == silindirSayisi) {
                    sonSilindir = new Silindir((Silindir)dizi[i]);
                }
                silindirIndex++;
            }
        }

        System.out.println("Karsilastirmalar:");
        System.out.println(karsilastir(ilkDaire, sonDaire));
        System.out.println(karsilastir(sonDaire, sondanBirOncekiDaire));
        System.out.println(karsilastir(ilkDikdortgen, sonDikdortgen));
        System.out.println(karsilastir(sonDikdortgen, sondanBirOncekiDikdortgen));
        System.out.println(karsilastir(ilkSilindir, sonSilindir));
        System.out.println(karsilastir(sonSilindir, sondanBirOncekiSilindir));


        double ortCevre = 0, ortAlan = 0, ortHacim = 0;
        int silindirSay = 0;
        double minCevre = 0, maxCevre = 0;
        double minAlan = 0, maxAlan = 0;
        double minHacim = 0, maxHacim = 0;

        minCevre = dizi[0].cevreHesapla();
        maxCevre = dizi[0].cevreHesapla();
        minAlan = dizi[0].alanHesapla();
        maxAlan = dizi[0].alanHesapla();

        for (int i = 0; i < sayac; i++) {
            if(dizi[i] instanceof Silindir) {
                minHacim = ((Silindir)dizi[i]).hacimHesapla();
                maxHacim = ((Silindir)dizi[i]).hacimHesapla();
                break;
            }
        }
        
        for (int j = 0; j < sayac; j++) {
            ortCevre += dizi[j].cevreHesapla();
            ortAlan += dizi[j].alanHesapla();
 
 
            if(dizi[j] instanceof Silindir) {
                Silindir sil = (Silindir) dizi[j];
                ortHacim += sil.hacimHesapla();
                silindirSay++;

                if(sil.hacimHesapla() < minHacim) {
                    minHacim = sil.hacimHesapla();
                }
                if(sil.hacimHesapla() > maxHacim) {
                    maxHacim = sil.hacimHesapla();
                }
            }
            if(dizi[j].cevreHesapla() < minCevre) {
                minCevre = dizi[j].cevreHesapla();
            }
            if(dizi[j].cevreHesapla() > maxCevre) {
                maxCevre = dizi[j].cevreHesapla();
            }
            if(dizi[j].alanHesapla() < minAlan) {
                minAlan = dizi[j].alanHesapla();
            }
            if(dizi[j].alanHesapla() > maxAlan) {
                maxAlan = dizi[j].alanHesapla();
            }
        }
        
        ortCevre /= sayac;
        ortAlan /= sayac;
        ortHacim /= silindirSay;

        double hesap[] = new double[9];
        hesap[0] = ortCevre;
        hesap[1] = ortAlan;
        hesap[2] = ortHacim;
        hesap[3] = minCevre;
        hesap[4] = maxCevre;
        hesap[5] = minAlan;
        hesap[6] = maxAlan;
        hesap[7] = minHacim;
        hesap[8] = maxHacim;
        
        System.out.println();
        System.out.println("Hesaplamalar:");
        System.out.printf("Ortalama cevre: %.2f\n", ortCevre);
        System.out.printf("Ortalama alan: %.2f\n", ortAlan);
        System.out.printf("Ortalama hacim: %.2f\n", ortHacim);
        System.out.printf("Minimum cevre: %.2f\n", minCevre);
        System.out.printf("Maksimum cevre: %.2f\n", maxCevre);
        System.out.printf("Minimum alan: %.2f\n", minAlan);
        System.out.printf("Maksimum alan: %.2f\n", maxAlan);
        System.out.printf("Minimum hacim: %.2f\n", minHacim);
        System.out.printf("Maksimum hacim: %.2f\n", maxHacim);
    }

    public static int satirSayisi() {    
        int satirSayisi = 0;
        try {
            Scanner dosya = new Scanner(new FileInputStream("input.txt"));
            while (dosya.hasNextLine()) {
                satirSayisi++;
                dosya.nextLine();
            }
            dosya.close();
        } 
        catch (FileNotFoundException e) {
            System.out.print("Dosya bulunamadı");
            System.exit(0);
        }
        return satirSayisi;
    }

    public static String polymorphicYazdir(GeometrikNesne n) {
        if(n instanceof Silindir) {
            return String.format("%s Cevre: %.2f Alan: %.2f Hacim: %.2f", n.toString(), n.cevreHesapla(), n.alanHesapla(), ((Silindir)n).hacimHesapla());
        }
        else {
            return String.format("%s Cevre: %.2f Alan: %.2f", n.toString(), n.cevreHesapla(), n.alanHesapla());
        }
    }

    public static String karsilastir(GeometrikNesne n1, GeometrikNesne n2) {
        if(n1.compareTo(n2) == 1) {
            return n1.getEtiket() + " nesnesi, " + n2.getEtiket() + " nesnesinden buyuk";
        }
        else if(n1.compareTo(n2) == -1) {
            return n1.getEtiket() + " nesnesi, " + n2.getEtiket() + " nesnesinden kucuk";
        }
        else {
            return n1.getEtiket() + " ve " + n2.getEtiket() + " nesneleri birbirine esit";
        }
    }
}

