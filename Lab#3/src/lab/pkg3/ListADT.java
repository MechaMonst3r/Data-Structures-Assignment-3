package lab.pkg3;


import java.util.Iterator;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */

public interface ListADT<E> extends Iterable<E> {
    
    
    public int size(); 
       
    
    public boolean isEmpty();
    
    
    public boolean contains(E element);

    
    @Override
    public Iterator<E> iterator();
    
    
    public boolean add(E element);

    
    public boolean remove(E element);
        

    
    public void clear();

    
    public E get(int index);
        

    
    public E set(int index, E element);
        

    
    public void add(int index, E element);
        

    
    public E remove(int index);
    
   
        

    
    public int indexOf(E element);
        

    
    
        

    
    
            
}
