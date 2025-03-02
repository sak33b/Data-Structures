package interfaces;

public interface ListI<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    void set(int index, T element);

    T remove(int index);

    boolean contains(T element);

    int size();

    boolean isEmpty();

    void clear();

    void addFirst(T element);

    void addLast(T element);

    T removeFirst();

    T removeLast();

    T peekFirst();

    T peekLast();

    void reverse();

    void remove(T element);

    int indexOf(T element);

    Object[] toArray();

    String toString();
}