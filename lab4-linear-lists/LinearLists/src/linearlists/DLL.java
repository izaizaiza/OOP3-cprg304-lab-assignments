/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author izalu
 */
public class DLL<E> implements Iterable<E> {

    
    //fields
    private Node<E> head;
    private Node<E> tail;
    private int size;

    //constructor
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E item) {
        //create a node that takes the item and add it to the first of dll
        Node<E> newNode = new Node(item);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<E>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return removedItem;
    }

    public void addAll(ListADT<? extends E> items) {
        for (E item : items) {
            addLast(item);
        }
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return removedItem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        DLL<String> dll = new DLL<>();
        dll.addFirst("First");
        dll.addLast("Last");
        dll.addFirst("New First");

        System.out.println("Doubly Linked List:");
        for (String item : dll) {
            System.out.println(item);
        }

        System.out.println("\nRemoved First: " + dll.removeFirst());
        System.out.println("Removed Last: " + dll.removeLast());

        System.out.println("\nUpdated Doubly Linked List:");
        for (String item : dll) {
            System.out.println(item);
        }
    }


    
}
