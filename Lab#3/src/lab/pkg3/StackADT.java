package lab.pkg3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */
public interface StackADT<T> {
    void push(T ele);
    T pop();
    int size();
    T peek();
    boolean isEmpty();
    
            
}
