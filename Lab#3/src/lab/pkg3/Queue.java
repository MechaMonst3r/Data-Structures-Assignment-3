/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

/**
 *
 * @author work
 */
public class Queue<T> implements QueueADT<T>{
    
    MyLinkedList li = new MyLinkedList();
    int fr = 0;
    int la = 0;
    T temp;

    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public void enQueue(T element) 
    {
     if(li.isEmpty() == true)
       {
        li.add(fr, element);
        la++;
       }
     else li.addLast(element);
     la++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deQueue()
    {
      temp = (T)li.remove(fr);
      fr++;
      return temp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll()
    {
     temp =(T)li.get(fr);
     return temp;
    }

    @Override
    public boolean isEmpty()
    {
     return li.size() == 0;
    }

    @Override
    public int size()
    {
      return li.size();
    }
    
    @Override
    public String toString()
    {
      return li.toString();
    }
    
}