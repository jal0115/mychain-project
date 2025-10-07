package lab2;

import java.util.Scanner;
import dataStructures.Chain;
import dataStructures.ChainNode;

public class MyChain extends Chain {

    public Object[] toArray() {
        Object[] array = new Object[size];
        ChainNode current = firstNode;
        int i = 0;
        while (current != null) {
            array[i++] = current.element;
            current = current.next;
        }
        return array;
    }

    public void addRange(Object[] elements) {
        int i = 0;
        while (i < elements.length) {
            add(size, elements[i]);
            i++;
        }
    }

    public MyChain union(MyChain other) {
        MyChain result = new MyChain();
        ChainNode current = firstNode;
        while (current != null) {
            result.add(current.element);
            current = current.next;
        }
        current = other.firstNode;
        while (current != null) {
            if (result.indexOf(current.element) == -1)
                result.add(current.element);
            current = current.next;
        }
        return result;
    }

    public MyChain intersection(MyChain other) {
        MyChain result = new MyChain();
        ChainNode current = firstNode;
        while (current != null) {
            if (other.indexOf(current.element) != -1)
                result.add(current.element);
            current = current.next;
        }
        return result;
    }

    public void add(Object element) {
        add(size, element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyChain list1 = new MyChain();
        MyChain list2 = new MyChain();

        while (true) {
            System.out.println("\n1. List1-д элемент нэмэх");
            System.out.println("2. List2-д элемент нэмэх");
            System.out.println("3. Union");
            System.out.println("4. Intersection");
            System.out.println("0. Гарах");
            System.out.print("Сонголтоо оруулна уу: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 0) break;

                switch (choice) {
                    case 1:
                        System.out.print("List1-д нэмэх элемент: ");
                        list1.add(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("List2-д нэмэх элемент: ");
                        list2.add(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Union: " + list1.union(list2));
                        break;
                    case 4:
                        System.out.println("Intersection: " + list1.intersection(list2));
                        break;
                    default:
                        System.out.println("Буруу сонголт!");
                }
            } catch (Exception e) {
                System.out.println("Алдаа: буруу өгөгдөл орууллаа.");
            }
        }
        sc.close();
    }
}

