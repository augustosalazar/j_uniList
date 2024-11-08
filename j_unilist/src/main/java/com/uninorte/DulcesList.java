package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DulcesList<E> extends AbstractList<E> {
    private Node head;
    private Node tail;
    private int size;

    public DulcesList() {
        head = new Node(-1, null);
        tail = new Node(-1, null);
        head.setNextNode(tail);
        tail.setPrevNode(head);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head.getNextNode();
        while (current != tail) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }




    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head.getNextNode();
        int index = 0;
        while (current != tail) {
            array[index++] = current.getData();
            current = current.getNextNode();
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size) {
            return (Object[]) toArray();
        }
        Node current = head.getNextNode();
        for (int i = 0; i < size; i++) {
            a[i] = current.getData();
            current = current.getNextNode();
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(Object e) {
        Node newNode = new Node(size, e);
        Node last = tail.getPrevNode();
        last.setNextNode(newNode);
        newNode.setPrevNode(last);
        newNode.setNextNode(tail);
        tail.setPrevNode(newNode);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head.getNextNode();
        while (current != tail) {
            if (current.getData().equals(o)) {
                Node prev = current.getPrevNode();
                Node next = current.getNextNode();
                prev.setNextNode(next);
                next.setPrevNode(prev);
                size--;
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean modified = false;
        System.out.println("size of c "+c.size());
        for (Object obj : c) {
            System.out.println(obj);
            if (this.add(obj)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for (Object obj : c) {
            add(index++, obj);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object obj : c) {
            while (remove(obj)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head.getNextNode();
        while (current != tail) {
            if (!c.contains(current.getData())) {
                remove(current.getData());
                modified = true;
            }
            current = current.getNextNode();
        }
        return modified;
    }

    @Override
    public void clear() {
        head.setNextNode(tail);
        tail.setPrevNode(head);
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return (E) current.getData();
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        Object oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(index, element);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        Node next = current.getNextNode();
        current.setNextNode(newNode);
        newNode.setPrevNode(current);
        newNode.setNextNode(next);
        next.setPrevNode(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.getNextNode();
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        Object data = current.getData();
        Node prev = current.getPrevNode();
        Node next = current.getNextNode();
        prev.setNextNode(next);
        next.setPrevNode(prev);
        size--;
        return (E) data;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head.getNextNode();
        int index = 0;
        while (current != tail) {
            if (current.getData().equals(o)) {
                return index;
            }
            current = current.getNextNode();
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = tail.getPrevNode();
        int index = size - 1;
        while (current != head) {
            if (current.getData().equals(o)) {
                return index;
            }
            current = current.getPrevNode();
            index--;
        }
        return -1;
    }

  



}
