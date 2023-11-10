/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearlists;

/**
 *
 * @author izalu
 */
public class Node<E> {
    
    E data;
    Node<E> prev;
    Node<E> next;
    
    
    public Node(E item, Node<E> prev, Node<E> next){
        this.data = item;
        this.prev = prev;
        this.next = next;
    }
    
}
