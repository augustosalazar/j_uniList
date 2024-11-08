package com.uninorte;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProfeList<E> extends AbstractList<E> implements List<E>{

    private Node PTR;
    private Node FINAL;
    @Override
    public int size() {
        int contador = 0;
        Node aux = this.PTR;
        while (aux != null) {
                contador++;
                aux = aux.getNextNode();
            }
        return contador;
    }

    public Node getPTR() {
        return PTR;
    }

    public Node getFINAL() {
        return FINAL;
    }

    @Override
    public boolean isEmpty() {
        if(this.PTR == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node aux = this.PTR;
        if (aux == null){
            return false;
        }
        while (aux != null) {
            if(aux.getData() == o){
                return true;
            }
            aux = aux.getNextNode();
        }
        return false;
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
        Node nodo = new Node(e);
        if(this.PTR == null){
            this.PTR = nodo;
            this.FINAL = nodo;
        }else{
            this.FINAL.setNextNode(nodo);
            nodo.setPrevNode(this.FINAL);
            this.FINAL = nodo;
        }
        return true;
    }

    @Override
    public E remove(int o) {
        Node aux = this.PTR;
        if(aux == null){
            return (E) "Lista vacia";
        }
        while (aux != null) {
            if((int)aux.getData() == o){
                if(aux == this.PTR){
                    if(aux.getNextNode() == null){
                        this.PTR = null;
                        this.FINAL = null;
                    }else {
                        this.PTR = aux.getNextNode();
                        aux.getNextNode().setPrevNode(null);
                    }
                } else if (aux == this.FINAL){
                    aux.getPrevNode().setNextNode(null);
                    this.FINAL = aux.getPrevNode();
                } else{
                    aux.getPrevNode().setNextNode(aux.getNextNode());
                    aux.getNextNode().setPrevNode(aux.getPrevNode());
                }
                return (E) "Nodo Eliminado";
            }
            aux = aux.getNextNode();
        }
        return (E) "No encontrado";
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection c) {
        Node aux = ((ProfeList) c).getPTR();
            while (aux != null) {
                this.add(aux);
                aux = aux.getNextNode();
            }
            return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {    
        Node aux = ((ProfeList) c).getPTR();
        int contador = 0;
        while (aux != null) {
            if(contador < index){
                aux = aux.getNextNode();
                contador++;
            } else{
                this.add(aux);
                aux = aux.getNextNode();
            }
        }
        return true;
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
       this.PTR = null;
       this.FINAL = null;
    }



    @Override
    public Object set(int index, Object element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, Object element) {

    }


    @Override
    public int indexOf(Object o) {
       Node aux = this.PTR;
       int contador = 0;
       if(aux == null){
        return -1;
       }
       while (aux != null) {
            if(aux.getData() == o){
                return contador;
            }
            aux = aux.getNextNode();
            contador++;
       }
       return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node aux = this.PTR;
        int contadorLista = 0;
        int contadorNodos = 0;
        if (aux == null){
            return -1;
        }
        while(aux != null){
            if (aux.getData() == o){
                contadorNodos = contadorLista;
            }
            aux = aux.getNextNode();
            contadorLista++;
        }
        return contadorNodos;
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

    @Override
    public E get(int index) {
        int contador = 0;
        Node aux = this.PTR;
        while(aux != null){
            if(index == contador){
                return (E) aux.getData();
            }
            aux = aux.getNextNode();
            contador++;
        }
        return (E) "index fuera de rango";
    }
    
}
