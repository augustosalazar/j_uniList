package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProfeListCS<E> extends AbstractList<E> {

    private Node startNode;
    private Node lastNode;

    public ProfeListCS() {
        this.startNode = null;
        this.lastNode = null;

    }

    @Override
    public int size() {
        Node node = this.startNode; // el nodo va a ser igual al cabecero de la lista, entonces si el cabecero es
        int c = 0; // nulo retonará cero como tamaño.
        while (node != null) {
            node = node.getNextNode();
            c++;
        }
        return c;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            Node current = startNode;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = (E) current.getData();
                current = current.getNextNode();
                return data;
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return startNode == null;
    }

    @Override
    public boolean contains(Object o) {
        boolean w = false;
        Node node = this.startNode;
        for (int i = 0; i < size(); i++) {
            if (node == null) {
                return w;
            } else if (node.getData() != o) {
                node = node.getNextNode();
                w = false;
            } else if (node.getData() == o) {
                w = true;
            }
        }
        return w;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return null;
    }

    @Override
    public boolean add(Object e) {
        Node node = new Node(e);
        if (startNode == null) {
            startNode = node;
        } else {
            Node current = startNode;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(node);
        }
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node currentNode = this.startNode;
        int currentIndex = 0;

        // Avanzamos hasta el nodo en la posición `index`
        while (currentIndex < index) {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        // Obtenemos el valor del nodo a eliminar
        E removedValue = (E) currentNode.getData();

        // Actualizamos los punteros de los nodos vecinos para "saltar" el nodo
        // eliminado
        if (currentNode.getPrevNode() != null) {
            currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
        } else {
            // Si no hay nodo previo, estamos eliminando el primer nodo
            this.startNode = currentNode.getNextNode();
        }

        if (currentNode.getNextNode() != null) {
            currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
        } else {
            // Si no hay nodo siguiente, estamos eliminando el último nodo
            this.lastNode = currentNode.getPrevNode();
        }

        return removedValue;
    }

    @Override
    public boolean remove(Object obj) {
        Node currentNode = this.startNode;

        // Recorremos la lista para buscar el nodo que contenga el valor `obj`
        while (currentNode != null) {
            if (currentNode.getData().equals(obj)) {
                // Nodo encontrado, ahora lo eliminamos
                if (currentNode.getPrevNode() != null) {
                    currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
                } else {
                    // Si no hay nodo previo, estamos eliminando el primer nodo
                    this.startNode = currentNode.getNextNode();
                }

                if (currentNode.getNextNode() != null) {
                    currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
                } else {
                    // Si no hay nodo siguiente, estamos eliminando el último nodo
                    this.lastNode = currentNode.getPrevNode();
                }

                return true; // Nodo eliminado exitosamente
            }

            currentNode = currentNode.getNextNode();
        }

        return false; // Nodo no encontrado, no se eliminó ningún elemento
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (this.startNode == null || c.size() == 0) {
            return false;
        }

        for (Object element : c) {
            boolean found = false;
            Node node = this.startNode;

            while (node != null) {
                if (node.getData().equals(element)) {
                    found = true;
                    break;
                }
                node = node.getNextNode();
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

        if (this.startNode == null) {
            boolean firstElement = true;
            for (Object element : c) {
                Node newNode = new Node(modCount, element);
                if (firstElement) {
                    this.startNode = newNode;
                    this.lastNode = newNode;
                    firstElement = false;
                } else {
                    this.lastNode.setNextNode(newNode);
                    newNode.setPrevNode(this.lastNode);
                    this.lastNode = newNode;
                }
            }
        } else {
            Node current = this.lastNode;
            for (Object element : c) {
                Node newNode = new Node(modCount, element);
                current.setNextNode(newNode);
                newNode.setPrevNode(current);
                current = newNode;
            }
            this.lastNode = current;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node currentNode = this.startNode;
        int currentIndex = 0;

        if (currentNode == null && index == 0) {
            for (Object element : c) {
                Node newNode = new Node(modCount, element);
                if (this.startNode == null) {
                    this.startNode = newNode;
                    this.lastNode = newNode;
                } else {
                    this.lastNode.setNextNode(newNode);
                    newNode.setPrevNode(this.lastNode);
                    this.lastNode = newNode;
                }
            }
        } else {
            while (currentIndex < index) {
                currentNode = currentNode.getNextNode();
                currentIndex++;
            }

            Node prevNode;
            if (currentNode != null) {
                prevNode = currentNode.getPrevNode();
            } else {
                prevNode = this.lastNode;
            }

            for (Object element : c) {
                Node newNode = new Node(modCount, element);
                if (prevNode != null) {
                    prevNode.setNextNode(newNode);
                    newNode.setPrevNode(prevNode);
                } else {
                    this.startNode = newNode; // Caso especial cuando el index es 0
                }
                if (currentNode != null) {
                    currentNode.setPrevNode(newNode);
                    newNode.setNextNode(currentNode);
                } else {
                    this.lastNode = newNode; // Caso especial si añadimos al final
                }
                prevNode = newNode;
            }
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        Node current = startNode;
        Node previous = null;

        while (current != null) {
            Node nextNode = current.getNextNode();

            if (c.contains(current.getData())) {
                if (previous == null) {
                    startNode = nextNode;
                } else {
                    previous.setNextNode(nextNode);
                }

                if (nextNode == null) {
                    lastNode = previous;
                } else {
                    nextNode.setPrevNode(previous);
                }

                modified = true;

            } else {
                previous = current;
            }

            current = nextNode;
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean modified = false;
        Node current = startNode;
        Node previous = null;

        while (current != null) {
            Node nextNode = current.getNextNode();

            if (!c.contains(current.getData())) {
                if (previous == null) {
                    startNode = nextNode;
                } else {
                    previous.setNextNode(nextNode);
                }

                if (nextNode == null) {
                    lastNode = previous;
                }

                modified = true;

            } else {
                previous = current;
            }
            current = nextNode;
        }

        return modified;
    }

    @Override
    public void clear() {
        startNode = null;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }

        Node current = startNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        Object oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    @Override
    public void add(int index, Object element) {
        Node node = new Node(index, element);
        Node actual = this.startNode;
        Node l;
        if (actual == null && index == 0) {
            actual = node;
        } else if (actual == null && index > 0) {
            System.out.println("No hay elementos que recorrer para alcanzar ese indice dentro de la lista.");
        } else {
            for (int i = 0; i <= index; i++) {
                actual = actual.getNextNode();
                if (i == index) {
                    actual = actual.getNextNode();// El nodo actual va a apuntar al siguiente nodo
                    l = actual.getNextNode();
                    l = node;// Y ese siguiente nodo dirije el puntero al nuevo nodo
                    node = node.getPrevNode();// El nodo nuevo al nodo anterior
                    node = actual;// El nodo que ahora es el anterior va al nodo llamado "actual" original.
                }
            }
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node node = this.startNode;
        for (int i = 0; i < size(); i++) {
            if (node == null) {
                System.out.println("La lista está vacía.");
                return index;
            } else if (node.getData() != o) {
                node = node.getNextNode();
                index++;
            } else if (node.getData() == o) {
                return index;
            }

        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node current = startNode;

        while (current != null) {
            if (current.getData() != null && current.getData().equals(o)) {
                lastIndex = currentIndex;
            }

            current = current.getNextNode();
            currentIndex++;
        }

        return lastIndex;
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
    public List<E> subList(int fromIndex, int toIndex) {

        if (fromIndex < 0 || toIndex > this.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }

        ProfeListCS<E> subList = new ProfeListCS<>();

        Node currentNode = this.startNode;
        int currentIndex = 0;

        while (currentNode != null && currentIndex < fromIndex) {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        while (currentNode != null && currentIndex < toIndex) {
            subList.add((E) currentNode.getData());
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        return subList;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }

        Node current = startNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        return (E) current.getData();
    }

}