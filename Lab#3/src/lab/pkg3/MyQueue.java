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
public class MyQueue<T> implements QueueADT{
    
    Stack s1 = new Stack();
    Stack s2 = new Stack();
    
    @Override
    @SuppressWarnings("unchecked")
    public void enQueue(Object element)
    {
      s1.push(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object deQueue()
    {
     if(s2.size() == 0)
       {
        if(s1.size() == 0)
          {
           return null;   
          } 
        
        while(s1.size() != 0)
          {
           var p = s1.pop();
           s2.push(p);
          }
       }   
     
     return s2.pop();  
    }

    @Override
    public Object poll()
    {
     return s2.peek();
    }

    @Override
    public boolean isEmpty()
    {
     return s1.size() == 0;   
    }

    @Override
    public int size()
    {
     return s1.size();   
    }
    
}
