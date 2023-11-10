/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author izalu
 */
package linearlists;


public class Node<E> {
    
    private E data;
    private Node<E> prev;
    private Node<E> next;
    
    /**
     * @param data - the value that the node holds
     */
    public Node(E data){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    
    
    public E getData(){
        return this.data;
    }
    
    public void setData(E data){
        this.data = data;
    }
    
    
    public Node<E> getPrev(){
        return this.prev;
    }
    
    public void setPrev(Node<E> prev){
        this.prev = prev;
    }
    
    
    public Node<E> getNext(){
        return this.prev;
    }
    
    public void setNext(Node<E> prev){
        this.prev = prev;
    }
    
    
    @Override
    public String toString(){
        
        String nodeAsString = String.format("Node value: %s", this.data);
        return nodeAsString;
    }
    
    
    
}
