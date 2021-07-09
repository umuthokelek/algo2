/*
 * Algoritma ve Programlama-II | Final Odevi
 * Umut Hökelek
 */
package finalodeviumuthokelek;

public class DoublyLinkedList<T> {
    private class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private CustomerInfo musteri;

        public Node(CustomerInfo musteri) {
            next = null;
            previous = null;
            this.musteri = musteri;
        }
    }
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }
    
    public void soyadaGoreSiraliEkle(CustomerInfo musteri) {
        Node<T> newCustomer = new Node<>(musteri);
        Node<T> current = head;

        if(isEmpty()) {
            head = newCustomer;
            tail = newCustomer;
        }
        else {
            while(current.next != null && newCustomer.musteri.getSoyad().compareTo(current.musteri.getSoyad()) > 0)
                current = current.next;
            
            if(newCustomer.musteri.getSoyad().compareTo(current.musteri.getSoyad()) == 0) {      
                
                while(current.next != null && newCustomer.musteri.getAd().compareTo(current.musteri.getAd()) > 0 && current.next.musteri.getSoyad().compareTo(newCustomer.musteri.getSoyad()) == 0)
                    current = current.next;

                if(newCustomer.musteri.getAd().compareTo(current.musteri.getAd()) <= 0) {
                    
                    if(current.previous != null) {
                        newCustomer.previous = current.previous;
                        newCustomer.next = current;
                        current.previous.next = newCustomer;
                        current.previous = newCustomer;
                    }
                    else {
                        current.previous = newCustomer;
                        newCustomer.next = current;
                        head = newCustomer;
                    }                                         
                }
                else {
                
                     if(current.next != null) {
                       newCustomer.next = current.next;
                       newCustomer.previous = current;
                       current.next.previous = newCustomer;
                       current.next = newCustomer;
                    }
                    else {
                       current.next = newCustomer;
                       newCustomer.previous = current;
                       tail = newCustomer;
                    }                     
                    
                }               
            }
            else {
               
                if(newCustomer.musteri.getSoyad().compareTo(current.musteri.getSoyad()) <= 0) {
                    if(current.previous != null) {
                       newCustomer.previous = current.previous;
                       newCustomer.next = current;
                       current.previous.next = newCustomer;
                       current.previous = newCustomer;
                    }
                    else {
                       current.previous = newCustomer;
                       newCustomer.next = current;
                       head = newCustomer;
                    }               
                }
                
                else {
                     if(current.next != null) {
                       newCustomer.next = current.next;
                       newCustomer.previous = current;
                       current.next.previous = newCustomer;
                       current.next = newCustomer;
                    }
                    else {
                       current.next = newCustomer;
                       newCustomer.previous = current;
                       tail = newCustomer;
                    }                               
                    
                }
            
            }
        
 
        }
        

    } 

    public void adSoyadaGoreArama(String adSoyad) {
        if (isEmpty()) {
            System.out.println("Liste bos oldugu icin arama yapilamadi.");
        }
        else {
            Node<T> current = head;
            while (current != null) {
                if (current.musteri.getAdSoyad().equalsIgnoreCase(adSoyad)) {
                    System.out.println("\"" + adSoyad + "\" isimli musteri bulundu: ");
                    System.out.println(current.musteri);
                    return;
                }
                current = current.next;
            }
            System.out.println("\"" + adSoyad + "\" isimli musteri bulunamadi.");
        }   
    }

    public void adSoyadaGoreMusteriSil(String adSoyad) {
        if (isEmpty()) {
            System.out.println("Liste bos oldugu icin silinecek musteri bulunamadi.");
        }
        else {
            Node<T> current = head;
            while (current != null) {
                if (current.musteri.getAdSoyad().equalsIgnoreCase(adSoyad)) {
                    if(current == head && current == tail) {
                        head = null;
                        tail = null;
                    }
                    else if(current == head) {
                        current.next.previous = null;
                        head = current.next;
                    }
                    else if(current == tail) {
                        current.previous.next = null;
                        tail = current.previous;
                    }
                    else {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                    }
                    System.out.println();
                    System.out.println("\"" + adSoyad + "\" isimli musteri basariyla silindi, guncel musteri listesi: ");
                    listeyiYazdir();
                    return;                
                }
                current = current.next;
            }
            System.out.println("Girmis oldugunuz ad soyada sahip bir musteri bulunumadigi icin silme islemi gerceklestirilemedi.");
        }       
    }

    public void AZyazdir() {        
        Node<T> current = head;
        Node<T> index = null;
        CustomerInfo temp;
        
        while(current != null) {
            index = current.next;
            while(index != null) {
                if(current.musteri.getSoyad().compareTo(index.musteri.getSoyad()) > 0) {
                   temp = current.musteri;
                   current.musteri = index.musteri;
                   index.musteri = temp;
                }
                else if(current.musteri.getSoyad().compareTo(index.musteri.getSoyad()) == 0) {
                   if(current.musteri.getAd().compareTo(index.musteri.getAd()) > 0) {
                       temp = current.musteri;
                       current.musteri = index.musteri;
                       index.musteri = temp;                    
                   }
                }
                index = index.next;

            }
            current = current.next;                   
        }
        listeyiYazdir();
    }
    
    public void ZAyazdir() {
        Node<T> current = head;
        Node<T> index = null;
        CustomerInfo temp;
        
        while(current != null) {
            index = current.next;
            while(index != null) {
                if(current.musteri.getSoyad().compareTo(index.musteri.getSoyad()) < 0) {
                   temp = current.musteri;
                   current.musteri = index.musteri;
                   index.musteri = temp;
                }

                else if(current.musteri.getSoyad().compareTo(index.musteri.getSoyad()) == 0) {
                   if(current.musteri.getAd().compareTo(index.musteri.getAd()) < 0) {
                       temp = current.musteri;
                       current.musteri = index.musteri;
                       index.musteri = temp;                    
                   }
                }
                index = index.next;

            }
            current = current.next;                   
        }
        listeyiYazdir();
        

    }
    public void listeyiYazdir() {
        if(isEmpty()) {
            System.out.println("Liste bos oldugu icin yazdirilamadi.");
        }
        else {
            Node<T> current = head;
            while (current != null) {
                System.out.println(current.musteri);
                current = current.next;
            }
        }
    }
    public boolean isEmpty() {
        return head == null;
    }

}

