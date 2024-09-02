import java.util.*;

public class SetC<T> implements Set<T> {
    private List<T> elements;

    public SetC() {
        elements = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        if (!elements.contains(e)) {
            elements.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    @Override public void clear() { elements.clear(); }
    @Override public Iterator<T> iterator() { return elements.iterator(); }
    @Override public Object[] toArray() { return elements.toArray(); }
    @Override public <T1> T1[] toArray(T1[] a) { return elements.toArray(a); }
    @Override public boolean retainAll(Collection<?> c) { return false; }
    @Override public boolean equals(Object o) { return false; }
    @Override public int hashCode() { return 0; }
}
