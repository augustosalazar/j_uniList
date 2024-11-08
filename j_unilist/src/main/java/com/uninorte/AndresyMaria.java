package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AndresyMaria<E> extends AbstractList<E>  {
    private Node head;
    
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
        Node current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        //
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.getData();
            current = current.getNextNode();
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        int size = size();
        if (a.length < size) {
            a = new Object[size];
        }
        Node current = head;
        int index = 0;
        while (current != null) {
            a[index++] = current.getData();
            current = current.getNextNode();
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(Object e) {
        Node newNode = new Node(size(), e);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
            newNode.setPrevNode(current);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                if (current.getPrevNode() != null) {
                    current.getPrevNode().setNextNode(current.getNextNode());
                } else {
                    head = current.getNextNode();
                }
                if (current.getNextNode() != null) {
                    current.getNextNode().setPrevNode(current.getPrevNode());
                }
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean modified = false;
        for (Object item : c) {
            add(item);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        for (Object item : c) {
            while (contains(item)) {
                remove(item);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
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
        head = null;
    }

    @Override
    public E get(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return (E) current.getData();
    }

    @Override
    public E set(int index, Object element) {

        throw new UnsupportedOperationException();

        // if (index < 0 || index >= size()) {
        //     throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        // }
        // Node current = head;
        // for (int i = 0; i < index; i++) {
        //     current = current.getNextNode();
        // }
        // Object oldData = current.getData();
        // current.setData(element);
        // return oldData;
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
    public E remove(int index) {
        throw new UnsupportedOperationException();
        // if (index < 0 || index >= size()) {
        //     throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        // }
        // Node current = head;
        // if (index == 0) {
        //     Object data = head.getData();
        //     head = head.getNextNode();
        //     if (head != null) {
        //         head.setPrevNode(null);
        //     }
        //     return data;
        // } else {
        //     for (int i = 0; i < index; i++) {
        //         current = current.getNextNode();
        //     }
        //     Object data = current.getData();
        //     Node prevNode = current.getPrevNode();
        //     Node nextNode = current.getNextNode();
        //     if (prevNode != null) {
        //         prevNode.setNextNode(nextNode);
        //     }
        //     if (nextNode != null) {
        //         nextNode.setPrevNode(prevNode);
        //     }
        //     return data;
       // }
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
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
        Node current = head;
        int index = -1;
        int counter = 0;
        while (current != null) {
            if (current.getData().equals(o)) {
                index = counter;
            }
            current = current.getNextNode();
            counter++;
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
}
