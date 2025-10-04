package ru.mpei.lec4.collection;

import java.util.*;

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
    public boolean remove(Object o) {
        var e = head;
        if (e == null) {
            return false;
        }
        if (e.value.equals(o)) {
            head = e.next;
            head.prev = null;
            return true;
        }
        while (e.hasNext()) {
            e = e.next;
            if (e.value.equals(o)) {
                e.prev.next = e.next;
                e.next.prev = e.prev;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean contains(Object o) {
        var e = head;
        if (e == null) {
            return false;
        }
        if(e.value.equals(o)) {
            return true;
        }
        while (e.hasNext()) {
            e = e.next;
            if(e.value.equals(o)){
                return true;
            }


        }
        return false;
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
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private ElementWrapper<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                T val = current.value;
                current = current.next;
                return val;
            }
        };
        return it;
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


        ListIterator<T> it = new ListIterator<T>() {
            private ElementWrapper<T> current = head;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public T next() {
                current = current.next;
                return current.value;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };

        return it;
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
