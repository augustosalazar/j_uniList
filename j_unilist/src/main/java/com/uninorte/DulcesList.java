package com.uninorte;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ExampleList implements List{

    public ExampleList(){
        Node head = new Node(0, null);
        Node tail = new Node(0, null);
        head.setNextNode(tail);
        tail.setPrevNode(head);
    }

    @Override
    public int size() {
        Node node = new Node(0, getClass())
        if (head == null) {
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {

    }

    @Override
    public boolean contains(Object o) {

    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {

    }

    @Override
    public Object[] toArray(Object[] a) {

    }

    @Override
    public boolean add(Object e) {

    }

    @Override
    public boolean remove(Object o) {
        
    }

    @Override
    public boolean containsAll(Collection c) {
        
    }

    @Override
    public boolean addAll(Collection c) {
        
    }

    @Override
    public boolean addAll(int index, Collection c) {

    }

    @Override
    public boolean removeAll(Collection c) {

    }

    @Override
    public boolean retainAll(Collection c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {

    }

    @Override
    public Object set(int index, Object element) {

    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

    }

    @Override
    public int indexOf(Object o) {

    }

    @Override
    public int lastIndexOf(Object o) {
        
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {

    }
    
}
