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

 
}

