import java.util.*;

public class ListA<T> implements List<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ListA() {
        elements = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }
    @Override public boolean contains(Object o) { return false; }
    @Override public Iterator<T> iterator() { return null; }
    @Override public Object[] toArray() { return new Object[0]; }
    @Override public <T1> T1[] toArray(T1[] a) { return null; }
    @Override public boolean remove(Object o) { return false; }
    @Override public boolean containsAll(Collection<?> c) { return false; }
    @Override public boolean addAll(Collection<? extends T> c) { return false; }
    @Override public boolean addAll(int index, Collection<? extends T> c) { return false; }
    @Override public boolean removeAll(Collection<?> c) { return false; }
    @Override public boolean retainAll(Collection<?> c) { return false; }
    @Override public void clear() {}
    @Override public T set(int index, T element) { return null; }
    @Override public void add(int index, T element) {}
    @Override public int indexOf(Object o) { return -1; }
    @Override public int lastIndexOf(Object o) { return -1; }
    @Override public ListIterator<T> listIterator() { return null; }
    @Override public ListIterator<T> listIterator(int index) { return null; }
    @Override public List<T> subList(int fromIndex, int toIndex) { return null; }
}
