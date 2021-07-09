/*
 * Algoritma ve Programlama II | Quiz 4
 * Umut Hökelek
 */
package quiz4umuthokelek;

public class Stack {
    Object arr[];
    public int index;
    public int size;

    public Stack(int size) {
        this.size = size;
        arr = new Object[size];
        index = -1;
    }

    public boolean push(Object data) {
        if (isFull()) {
            System.out.println("Stack dolu, \"" + data + "\" verisi push edilemez.");
            return false;
        }
        else {
            arr[++index] = data;
            return true;
        }
    }

    public boolean pop() {
        if(isEmpty()) {
            System.out.println("Stack bos, pop edilemez.");
            return false;
        }
        else {
            System.out.println("Bu musteri pop edildi: " + arr[index--]);
            return true;
        }
    }

    public boolean isEmpty() {
        return (index == -1);
    }

    public boolean isFull() {
        return (size - 1 == index);
    }



}
