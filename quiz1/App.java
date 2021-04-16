/*
 * Algoritma ve Programlama-II | Quiz 1 
 * Umut Hökelek
 * 02-04-2021
 */
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String nesne = "";
        String kontrol = "";
        int sayac = 0;
        int puan = 0;
        double ort = 0.0;
        System.out.println("Let's go fishing!");
        do {
            Random rastgele = new Random();
            int sayi = rastgele.nextInt(6) + 1;

            switch (sayi) {
                case 1:
                    nesne = "an old shoe";
                    puan += 1;
                    break;
                case 2:
                    nesne = "a huge fish";
                    puan += 100;
                    break;
                case 3:
                    nesne = "a leaf";
                    puan += 2;
                    break;
                case 4:
                    nesne = "a small fish";
                    puan += 50;
                    break;
                case 5:
                    nesne = "a rock";
                    puan += 3;
                    break;
                case 6:
                    nesne = "garbage";
                    puan += 0;
                    break;
            }

            sayac++;
            System.out.println("You caught [" + nesne + "].");
            System.out.print("Try fishing again? (Y or N): ");
            Scanner girdi = new Scanner(System.in);
            kontrol = girdi.next();

        } while (kontrol.equals("Y") || kontrol.equals("y"));

            ort = (double) puan / sayac;
            System.out.println("You got a total of " + puan + " fishing points.");
            System.out.println("You casted your fishing line " + sayac + " times.");
            System.out.printf("Average=%6.2f\n", ort);
            if(ort >= 20.0) {
                System.out.println("Great Job");
            }
            else if (ort >= 10.0) {
                System.out.println("That is some fine fishing");
            }
            else {
                System.out.println("Try again in future");
            }
    }
    
}
