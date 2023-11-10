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
public class ListADT<E> implements Iterable<E> {
    
    //some kind of list of obbjects
    private Object[] elements;
    //size of list
    private int size;
    
    
    public ListADT(){
        // what to add here?
    }
    
    public void add(E item){
        //add the item to elements list
        elements[size++] = item;
    }
    
    public void addAll(ListADT<E> items){
        for(E item: items){
            add(item);
        }
    }
    
    
    public E get(int index){
        
        return (E) elements[index];
    }
    
    
    public E remove(int index){
        E removeElement = get(index);
        //remove element
        
        return removeElement;
    }
    
    
    public void set(int index, E item){
        
        elements[index] = item;
    }
    
    
    public int size(){
        return size;
    }
    
    
    public boolean isEmpty(){
        return size ==0;
    }
    
    
    public Object[] toArray(){
        // turn the objects into array elements?
        
        Object[] arrayObjs;
        
        return arrayObjs
    }
    
    
    public void clear(){
        // make all elements in the array null
        for(int i=0; i<size; i++){
            elements[i] = null;
        }
        
        size = 0;
    }
    
    
}
