/*
 * Algoritma ve Programlama II | Quiz 3
 * Umut Hökelek
 */
package quiz3umuthokelek;

public class CircularLinkedList {
    public Node head = null;
    public Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void delete(int x) {

        Node prev, current;
        if (isEmpty()) {
            System.out.println("Liste bos oldugu icin silme islemi gerceklestirilemiyor.");
            return;
        } 
        else {
            if (head != tail) {
                current = head;
                prev = null;
                
                for (int i = 0; i < x - 1; i++) {
                    prev = current;
                    current = current.next;
                }

                if (prev != null) {
                    prev.next = current.next;
                    current = null;
                }
                else {
                    head = current.next;
                    tail = current.next;
                    tail.next = head;
                    current = null;
                }
            }
        }

    }

    public void print() {
        Node current = head;

        if (isEmpty()) {
            System.out.println("Liste bos");
            return;
        } else {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
        }
    }

    public int size() {
        int s = 0;
        Node current = head;
        
        if (isEmpty()) {
            System.out.println("Listenin eleman sayisi: 0");
            System.exit(0);
        }
        else {
            do {
                s++;
                current = current.next;
            } while (current != head);
        }
        return s;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

