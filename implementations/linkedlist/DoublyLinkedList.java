package implementations.linkedlist;

import interfaces.ListI;

public class DoublyLinkedList<T> implements ListI<T> {

    private class Node {

        T data;
        Node prev;
        Node next;

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        Node(T data) {
            this(data, null, null);
        }

        public String toString() {
            return this.data.toString();
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void add(int index, T element) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }

        Node toPush = nodeAt(index);
        Node node = new Node(element, toPush.prev, toPush);
        toPush.prev.next = node;
        toPush.prev = node;

        this.size++;
    }

    public T get(int index) {

        Node node = nodeAt(index);
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
        return node.data;

    }

    public void set(int index, T element) {
        Node node = nodeAt(index);
        node.data = element;
    }

    public T remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node toRemove = nodeAt(index);

        if (toRemove == null) {
            return null;
        }

        T toRemoveData = toRemove.data;

        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        this.size--;

        return toRemoveData;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null || this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T element) {

        if (isEmpty()) {
            addLast(element);
            return;
        }

        this.head = new Node(element, null, head);
        this.size++;
    }

    public void addLast(T element) {

        if (isEmpty()) {
            this.head = this.tail = new Node(element);
            this.size++;
            return;
        }

        this.tail.next = new Node(element, this.tail, null);
        this.tail = this.tail.next;
        this.size++;
    }

    private Node nodeAt(int index) {
        int count = 0;
        for (Node node = this.head; node != null; node = node.next) {
            if (count == index) {
                return node;
            }
            count++;
        }
        return null;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T toRemove = head.data;

        if (size() == 1 || this.head.next == null) {
            this.head = null;
            this.size = 0;
            return toRemove;
        }

        this.head = this.head.next;
        head.prev = null;
        this.size--;

        return toRemove;
    }

    public T removeLast() {
        if (size() <= 1) {
            return removeFirst();
        }

        T toRemove = tail.data;

        tail = tail.prev;
        tail.next = null;
        this.size--;

        return toRemove;
    }

    public T peekFirst() {

        if (isEmpty()) {
            return null;
        }
        return this.head.data;
    }

    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return this.tail.data;
    }

    public void reverse() {

        if (isEmpty()) {
            return;
        }

        Node pointer = this.head;

        while (pointer != null) {
            Node temp = pointer.next;
            pointer.next = pointer.prev;
            pointer.prev = temp;
            pointer = temp;
        }

        pointer = this.tail;
        this.tail = this.head;
        this.head = pointer;
    }

    public void remove(T element) {
        int toRemoveIndex = indexOf(element);
        if (toRemoveIndex == -1) {
            return;
        }
        remove(toRemoveIndex);
    }

    public int indexOf(T element) {

        if (element == null)
            return -1;

        int index = 0;
        for (Node node = this.head; node != null; node = node.next) {
            if (element.equals(node.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Object[] toArray() {

        Object[] array = new Object[this.size];
        Node node = this.head;

        for (int i = 0; i < array.length; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    public String toString() {

        if (isEmpty()) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("null - ");

        Node node = this.head;
        while (node.next != null) {
            sb.append(node.data.toString());
            sb.append(" = ");
            node = node.next;
        }
        sb.append(node.data.toString());
        sb.append(" - null");

        return sb.toString();
    }
}