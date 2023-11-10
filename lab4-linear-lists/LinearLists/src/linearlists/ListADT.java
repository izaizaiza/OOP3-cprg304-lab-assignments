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
 * @param <E> the type of elements in the list
 */
public class ListADT<E> implements Iterable<E> {
    
    //some kind of array to store objs
    private Object[] elements;
    //size of list or number of elements in the array
    private int size;
    
    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public ListADT(){
        // what to add here?
        // maybe set an initial capacity or default max number to elements
        // and keep the size 0 to say its empty but it can hold n;
        int n = 5;
        this.elements = new Object[n];
        this.size = 0;
    }
    
    /**
     * Adds an item to the end of the list.
     *
     * @param item The item to be added.
     */
    public void add(E item){
        
        // before adding, make sure theres enough space in the array
        // make a helper method
        resizeArray(size+1);
        
        //add the item to elements list
        elements[size++] = item;
    }
    
    public void addAll(ListADT<E> items){
        for(E item: items){
            add(item);
        }
    }
    
    /**
     * getting the value of the specified index
     * @param index - target index
     */
    public E get(int index){
        //add a check if index is within bounds
        if (index < 0 || index>= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + 
                    "; should be between 0 and the size " + this. size + ".");
        }
        return (E) elements[index];
    }
    
    /**
     * @param index - the index of the data to be removed
     * removes a data in the array via its index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index){
        //add a check if index is within bounds
        if (index < 0 || index>= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + 
                    "; should be between 0 and the size " + this. size + ".");
        }
        
        //get element to be removed
        E removeElement = get(index);
        
        //remove element:
        //1. shift all elements of the value in the array to the left
        
        for (int i=index; i< size-1; i++){
            //the elements at current index will be the elements from the right
            elements[i] = elements[i+1];
        }
        
        //2. and decrease the size of array
        // set last element to be null
        
        elements[size-1] = null;
        //decrease size
        size--;
        
        return removeElement;
    }
    
    
    
    
    /**
     * Sets the element at the specified index to a new value.
     *
     * @param index The index of the element to be updated.
     * @param item  The new value to set.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void set(int index, E item){
        
        elements[index] = item;
    }
    
    
    
    /**
     * Gets the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int getSize(){
        return size;
    }
    
    
    
    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty(){
        return size ==0;
    }
    
    /**
     * Converts the list to an array.
     *
     * @return An array containing the elements of the list.
     */
    public Object[] toArray(){
        // turn the objects into array elements?
        
        Object[] arrayObjs = new Object[size];
        // is there a built in method that turns the objects into array?
        // System.copyarray() takes 5 inputs and copys an array into another
        //inputs
        // Object src - the array we are getting the sub array or is the array we will copy from
        // int srcPos -  the start index of source array where we begin the copy
        // Object dest - the array we are copying the sub array into
        // int destPos - the start index of the des array where we copy into
        // int length - the length of subarray we are copying
        System.arraycopy(elements,0, arrayObjs,0,size);
        return arrayObjs;
    }
    
    
    
    /**
     * Clears the list by making all elements null and setting size to 0.
     */
    public void clear(){
        // make all elements in the array null
        for(int i=0; i<size; i++){
            elements[i] = null;
        }
        
        size = 0;
    }
    
    
    
    /**
     * Returns an iterator over the elements in the list.
     *
     * @return An iterator.
     */
    public Iterator<E> iterator(){
        
        return new Iterator<E>(){
            private int currentIndex=0;
            
            @Override
            public boolean hasNext(){
                return currentIndex < size;
            }
            
            @Override
            public E next(){
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                return (E) elements[currentIndex++];
            }
        };
    }
    
    
    
    
    //helper method
    /**
     * Resizes the array has so that it has enough space.
     *
     * @param minCapacity The minimum capacity to make sure it is available.
     */
    private void resizeArray(int minCapacity) {
        if (minCapacity > elements.length) {
            // Grow the array to accommodate more elements
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        //else do nothing, must be enough space/capacity
    }
    
    
}
