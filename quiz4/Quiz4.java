/*
 * Algoritma ve Programlama II | Quiz 4
 * Umut Hökelek
 */
package quiz4umuthokelek;

public class Quiz4 {
    public static void main(String[] args) {
        Stack yigit = new Stack(5);
    
        Customer musteri1 = new Customer("1", "Ahmet Yilmaz");
        Customer musteri2 = new Customer("2", "Mehmet Ozturk");
        Customer musteri3 = new Customer("3", "Can Yildirim");
        Customer musteri4 = new Customer("4", "Hasan Demir");
        Customer musteri5 = new Customer("5", "Ozkan Aslan");
    
        yigit.push(musteri1);
        yigit.push(musteri2);
        yigit.push(musteri3);
        yigit.push(musteri4);
        yigit.push(musteri5);

        yigit.pop();
        yigit.pop();
        yigit.pop();
        yigit.pop();
        yigit.pop();
    }
}

