package com.uninorte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProfeList<T> implements List<T> {
    private List<T> list;

    public ProfeList() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(T element) {
        return list.add(element);
    }

    @Override
    public void add(int index, T element) {
        list.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return list.addAll(index, c);
    }

    @Override
    public void clear() {
        list.clear();
    }

   
}

