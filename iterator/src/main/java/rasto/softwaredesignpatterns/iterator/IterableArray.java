package rasto.softwaredesignpatterns.iterator;

import java.util.Iterator;

public class IterableArray<T> implements Iterable<T> {

    private final T[] array;

    public IterableArray(T[] array) {
        this.array = array.clone();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        int index = 0;
        T[] iteratorArray = array.clone();

        @Override
        public boolean hasNext() {
            return index < iteratorArray.length;
        }

        @Override
        public T next() {
            return iteratorArray[index++];
        }
    }
}
