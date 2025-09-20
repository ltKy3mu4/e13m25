package ru.mpei.lec4.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList <T> implements List<T> {

    private ElementWrapper<T> head;


    @Override
    public boolean add(T t) {
        var e = new ElementWrapper<>(t, null, null);
        if (head == null) {
            head = e;
            return true;
        } else {
            ElementWrapper<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = e;
            e.prev = last;
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index == 0){
            return head.value;
        }
        int counter = 0;
        var el = head;
        while (el.hasNext()) {
            counter++;
            el = el.next;
            if (counter == index){
                return el.value;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public T set(int index, T element) {
        return null;
    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    private static class ElementWrapper<T> {
        T value;
        ElementWrapper<T> next;
        ElementWrapper<T> prev;

        ElementWrapper(T value, ElementWrapper<T> next, ElementWrapper<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        boolean hasNext() {
            return next != null;
        }

    }
}
