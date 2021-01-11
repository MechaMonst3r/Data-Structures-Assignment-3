/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */
public class MyStack<T> implements StackADT<T> {

    private int capacity;
    private MyArrayList a;
    private int top;

    public MyStack() {
        this.a = new MyArrayList();
        this.top = 0;
        capacity = 10;
    }
    
    @Override
    public void push(T ele) {
        if(top < capacity){
            a.add(top, ele);
            top++;
        }
        // throw exception
    }

    @Override
    public T pop() {
        T data = null;
        if(!isEmpty()){
            top--;
            data = (T) a.remove(top);
        }
        return data;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public T peek() {
        if(!isEmpty())
            return (T)a.get(top-1);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }
    
    
    
}
