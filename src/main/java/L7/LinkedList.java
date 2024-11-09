package L7;

import L7.Exceptions.NotFoundException;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<Node<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value){
        size++;
        Node<T> node = new Node<T>();
        node.setNext(null);
        node.setPrevious(null);
        node.setValue(value);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        Node<T> cur = head;
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        node.setPrevious(cur);
        cur.setNext(node);
        tail = node;
    }

    public Node<T> delete(){
        if(head == null){
            return null;
        }
        size--;
        Node<T> cur = head;
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        if (size == 0){
            head = null;
            tail = null;
            return cur;
        }
        tail = cur.getPrevious();
        cur.getPrevious().setNext(null);
        return cur;
    }

    public Node<T> delete(T value){
        //удалить элемент по значению
        // использовать equals()
        if(head == null){
            return null;
        }
        Node<T> cur = head;
        Node<T> previous = null;
        while (cur != null){
            if (cur.getValue().equals(value)){
                if(cur != head){
                    previous.setNext(cur.getNext());
                } else {
                    head = cur.getNext();
                }
                if(cur.getNext() != null){
                    cur.getNext().setPrevious(previous);
                }
                if (tail == cur){
                    tail = previous;
                }
                size--;
                return cur;
            }
            previous = cur;
            cur = cur.getNext();
        }
        throw new NotFoundException("элемент не найден");
    }

    public Node<T> findByValue(T value){
        //найти элемент по значению
        //использовать next() и hasNext()
        for (Iterator<Node<T>> node = iterator(); node.hasNext();) {
            Node<T> elem = node.next();
            if (elem.getValue().equals(value)){
                return elem;
            }
        }
        throw new NotFoundException("элемент не найден");
    }

    public int size(){
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<Node<T>> iterator() {
       return new Iterator<Node<T>>() {

           private Node<T> curr = head;

           @Override
           public boolean hasNext() {
               return curr.getNext() != null;
           }

           @Override
           public Node<T> next() {
               curr = curr.getNext();
               return curr;
           }
       };
    }

}
