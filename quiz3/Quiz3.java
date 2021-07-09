/*
 * Algoritma ve Programlama II | Quiz 3
 * Umut Hökelek
 */
package quiz3umuthokelek;

import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n ve k degerlerini giriniz: ");
        int n = scan.nextInt();
        int k = scan.nextInt();
        balonPozisyonuBul(n, k);

    }

    static void balonPozisyonuBul(int n, int k) {
        CircularLinkedList list = new CircularLinkedList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.print("Listedeki elemanlar: ");
        list.print();
        System.out.println();

        int atla = k - 2;
        do {
            if (k > list.size())
                k = k - list.size();
            list.delete(k);
            k += atla;
            list.print();
            System.out.println();
            if (list.size() == 1) {
                System.out.print("Patlamayan balon: ");
                list.print();
            }
        } while (list.size() > 1);
    }
}
