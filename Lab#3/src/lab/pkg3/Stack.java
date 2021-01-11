/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

/**
 *
 * @author work
 * @param <T>
 */
public class Stack<T> implements StackADT<T>{
    
    MyLinkedList li = new MyLinkedList();

    @Override
    @SuppressWarnings("unchecked")
    public void push(T ele) {
       
        li.add(ele);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
         
        T data = (T) li.get(0);
        li.remove(0);
        return data;
    }

    @Override
    public int size() {
        
        return li.size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek(){
        
        return (T) li.get(0);
    }

    @Override
    public boolean isEmpty() {
        
        return li.size() == 0;
    }
    
    @Override
    public String toString()
    {
      return li.toString();  
    }
    
}
