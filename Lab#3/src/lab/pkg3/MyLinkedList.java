package lab.pkg3;

import java.util.Iterator;

public class MyLinkedList<T> implements ListADT<T> {
    private int len;

    private LinkedNode<T> head;

    public MyLinkedList() {
        this.len = 0;
        head = null;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public boolean isEmpty() {
        return (len==0);
    }

    @Override
    public boolean contains(T element) {
        return (indexOf(element) > -1);

        
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
        
    }
    
    private class MyIterator implements Iterator<T>{

        private LinkedNode<T> cur;

        public MyIterator() {
            cur = head;
        }
        
        @Override
        public boolean hasNext() {
            if(cur != null)
                return true;
            return false;
        }

        @Override
        public T next() {
          T data = cur.getData();
          cur = cur.getNext();
          return data;
        }
        
    }  

    @Override
    public boolean add(T element) {
        LinkedNode<T> nn = new LinkedNode<>(element);
        if(head == null)
            head = nn;
        else
        {
            nn.setNext(head);
            head = nn;
        }
        len++;
        return true;
    }
    
    @SuppressWarnings({"unchecked", "unchecked"})
    public void addLast(T element)
    {
     LinkedNode node = new LinkedNode(element);
     LinkedNode temp = head;
     while(temp.getNext() != null)
        {
         temp = temp.getNext();
        }
    
     temp.setNext(node);
     len++;
    }

    @Override
    public boolean remove(T element) {
       int index = indexOf(element);
       if(index>-1){
           remove(index);
           return true;
       }
       return false;
    }

    @Override
    public void clear() {
        head = null;
        len = 0;

    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index < 0 || index > len)
            return null;
        int i=0;
        Iterator it = iterator();
        T data = null;
        while(it.hasNext() && i<=index)
        {
            data = (T)it.next();
            i++;
        }
        return data;
        
        
            
    }

    @Override
    public T set(int index, T element) {
        if(index<0 || index>len)
            return null;
        
        int i=0;
        LinkedNode<T> cur = head;
        while(cur != null && i<=index)
        {
            cur = cur.getNext();
            i++;
        }
        T data = cur.getData();
        cur.setData(element);
        
        return data;
        
    }
    
    @Override
    public void add(int index, T element) {

        if(index <0 || index > len)
            return;

        LinkedNode<T> nn = new LinkedNode<>(element);
        if(index==0){
            add(element);
            return;
        }else if(index == len-1){
            //append(element);
        }else{
            LinkedNode<T> cur = head;
            for(int i=0; i<index-1; i++)
                cur = cur.getNext();
            nn.setNext(cur.getNext());
            cur.setNext(nn);
        }
        len++;

    }
    
    @Override
    public T remove(int index) {
        T data = null;
        if(index < 0 || index > len)
            return null;
        if(head == null)
            return null;
        
        if(index == 0){
            data = head.getData();
            head = head.getNext();
            len--;
        }else{
            LinkedNode<T> cur = head, prev = null;
            int i = 0;
            while(i<index && cur!=null){
                prev = cur;
                cur = cur.getNext();
                i++;
            }
            
            if(cur!=null){
                data = cur.getData();
                prev.setNext(cur.getNext());
                len--;
            }
        }
        return data;
    }
    
   
    @Override
    public int indexOf(T element) {
        
        int i=0;
        
        for(T e:this){
            if(e.equals(element))
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        LinkedNode<T> cur = head;
        while(cur != null){
            T d = cur.getData();
            sb.append(d +" ");
            cur = cur.getNext();
        }
        sb.append("}");
        return sb.toString();
    }
}
