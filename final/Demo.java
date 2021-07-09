/*
 * Algoritma ve Programlama-II | Final Odevi
 * Umut Hökelek
 */
package finalodeviumuthokelek;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    
    public static void main(String[] args) {
        CustomerInfo musteri = null;
        DoublyLinkedList<String> liste = new DoublyLinkedList<>();
        int islem = 0;

        do {
            System.out.println();
            System.out.println("Umut Hökelek | Algoritma ve Programlama-II Final Odevi");
            System.out.println("Lutfen yapmak istediginiz islemi tuslayiniz: ");
            System.out.println("(1) \"customer.txt\" Dosyasindaki Musterileri Goruntule (Cift Bagli Listede)");
            System.out.println("(2) Yeni Musteri Ekle (Alfabetik Sirasina Gore)");
            System.out.println("(3) Musteri Arama");
            System.out.println("(4) Musteri Silme");
            System.out.println("(5) Artan Sirada (A-Z) Musterileri Listeleme");
            System.out.println("(6) Azalan Sirada (Z-A) Musterileri Listeleme");
            System.out.println("(7) Programdan cikis yap");

            Scanner keyboard = new Scanner(System.in);
            islem = keyboard.nextInt();

            switch (islem) {
                case 1:  

                    System.out.println();
                    Scanner dosya = null; 
                    try {
                        dosya = new Scanner(new FileInputStream("customer.txt"));

                        System.out.println("\"customer.txt\" Dosyasindaki Musteriler");
                        while (dosya.hasNextLine()) {
                            String bilgiler = dosya.nextLine();
                            String[] bilgiDizi = bilgiler.split(",");
                            String adSoyad = bilgiDizi[0];
                            String adres = bilgiDizi[1];
                            ArrayList<String> numaralar = new ArrayList<>();
                            for (int i = 2; i < bilgiDizi.length; i++) {
                                numaralar.add(bilgiDizi[i]);
                            }    
                            musteri = new CustomerInfo(adSoyad, adres, numaralar);
                            liste.soyadaGoreSiraliEkle(musteri);
                        }
                        liste.listeyiYazdir();
                    } 
                    catch (Exception e) {
                        System.out.println("Dosya bulunamadi");
                        System.exit(0);
                    }

                    break;
                case 2:
                    
                    System.out.println();
                    Scanner musteriGir = new Scanner(System.in);
                    System.out.println("Yeni Musteri Ekleme");
                    System.out.print("Musterinin adini soyadini giriniz: ");
                    String adSoyad = musteriGir.nextLine();
                    System.out.print("Musterinin adresini giriniz: ");
                    String adres = musteriGir.nextLine();
                    System.out.print("Musterinin tum numaralarini, numaralarin arasina yalnizca virgul koyarak giriniz: ");
                    String numaraSatiri = musteriGir.nextLine();
                    String[] numaraDizisi = numaraSatiri.split(",");
                    ArrayList<String> numaralar = new ArrayList<>();
                    for (String s : numaraDizisi) {
                        numaralar.add(s);
                    }
                    musteri = new CustomerInfo(adSoyad, adres, numaralar);
                    liste.soyadaGoreSiraliEkle(musteri);

                    System.out.println();
                    System.out.println("Musteri basariyla eklendi, guncel musteri listesi: ");
                    liste.listeyiYazdir();

                    break;
                case 3:
                    
                    System.out.println();
                    Scanner musteriAra = new Scanner(System.in);
                    System.out.println("Musteri Arama");
                    System.out.print("Aramak istediginiz musterinin adini soyadini giriniz: ");
                    String araAdSoyad = musteriAra.nextLine();
                    System.out.println();
                    liste.adSoyadaGoreArama(araAdSoyad);

                    break;
                case 4:
                    System.out.println();
                    Scanner musteriSil = new Scanner(System.in);
                    System.out.println("Musteri Silme");
                    System.out.print("Silmek istediginiz musterinin adini soyadini giriniz: ");
                    String silAdSoyad = musteriSil.nextLine();
                    liste.adSoyadaGoreMusteriSil(silAdSoyad);

                    break;
                case 5:

                    System.out.println();

                    System.out.println("Musteri Listesi (Soyada Gore A'dan Z'ye)");
                    liste.AZyazdir();

                    break;
                case 6:

                    System.out.println();

                    System.out.println("Musteri Listesi (Soyada Gore Z'den A'ya)");
                    liste.ZAyazdir();

                    break;
                case 7:
                    
                    System.out.println();
                    System.out.println("Program kapatildi");
                    break;
                default:
                    System.out.println();

                    System.out.println("\nHatali islem numarasi girdiniz\n");
                    break;
            }
        } while (islem != 7);
    }


}

