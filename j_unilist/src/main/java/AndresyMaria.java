package com.uninorte;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AndresyMaria implements List {
    
    @Override
    public int size() {
        int count = 0;
    Node current = head;
    
    while (current != null) {
        count++;
        current = current.getNextNode();
    }
    
    return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(Object e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        head = null;
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
    
        return current.getData();
    }

    @Override
    public Object set(int index, Object element) {
         if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    Node current = head;
    for (int i = 0; i < index; i++) {
        current = current.getNextNode(); 
    }

    Object oldData = current.getData(); 
    current.data = element; 
    return oldData; 
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    
        Node newNode = new Node(index, element);
    
        if (index == 0) {
            if (head != null) {
                newNode.setNextNode(head);
                head.setPrevNode(newNode);
            }
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextNode(); 
            }
    
            newNode.setNextNode(current.getNextNode());
            newNode.setPrevNode(current);
    
            if (current.getNextNode() != null) {
                current.getNextNode().setPrevNode(newNode);
            }
    
            current.setNextNode(newNode);
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    
        Node current = head;
    
        if (index == 0) {
            Object data = head.getData();
            head = head.getNextNode();
            if (head != null) {
                head.setPrevNode(null);
            }
            return data;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNextNode();
            }
    
            Object data = current.getData();
            Node prevNode = current.getPrevNode();
            Node nextNode = current.getNextNode();
    
            if (prevNode != null) {
                prevNode.setNextNode(nextNode);
            }
    
            if (nextNode != null) {
                nextNode.setPrevNode(prevNode);
            }
    
            return data;
        }
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

}
