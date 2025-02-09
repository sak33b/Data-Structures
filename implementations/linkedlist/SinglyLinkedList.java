package implementations.linkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    class Node {

        private final T data;
        private Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return this.data.toString();
        }
    }


    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // public LinkedList(Node<T> node) {
    // this.head = node;
    // this.size = 1;
    // }

    public int indexOf(T element) { // O(n)

        int index = 0;
        Node pointer = this.head;

        while (pointer != null) {

            if (pointer.data.equals(element)) {
                return index;
            }

            pointer = pointer.next;
            index++;
        }
        return -1;

    }

    public void addFirst(T element) { // O(1)

        Node node = new Node(element);

        node.next = this.head;
        this.head = node;

        this.size += 1;
    }

    public void addLast(T element) { // O(n)

        if (head == null) {
            head = new Node(element);
            this.size += 1;
            return;
        }

        Node pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(element);
        this.size += 1;
    }

    public void removeFirst() { // O(1)

        if (this.head == null) {
            throw new NoSuchElementException("Empty list");
        }

        this.head = this.head.next;
        this.size -= 1;

    }

    public void removeLast() { // O(n)

        if (this.head == null) {
            throw new NoSuchElementException("Empty List");
        }

        if (this.head.next == null) {
            this.head = null;
            this.size -= 1;
            return;
        }

        Node pointer = this.head;

        while (pointer.next.next != null) {
            pointer = pointer.next;
        }

        pointer.next = null;
        this.size -= 1;

    }

    public void remove(T element) { // O(n)

        int index = indexOf(element);

        if (index < 0) {
            throw new NoSuchElementException("Could not found");
        } else if (index == 0) {
            removeFirst();
            return;
        } else if (index == this.size - 1) {
            removeLast();
            return;
        }

        Node pointer = this.head;

        while (pointer.next.next != null) {

            if (element.equals(pointer.next.data)) {
                pointer.next = pointer.next.next;
                this.size -= 1;
                return;
            }

            pointer = pointer.next;
        }

    }

    public T peek() { // O(1)

        if (this.size == 0) {
            return null;
        }
        return head.data;
    }

    public int size() { // O(1)
        return this.size;
    }

    public String toString() { // O(n)

        StringBuilder sb = new StringBuilder();
        Node pointer = head;

        while (pointer != null) {
            sb.append(pointer);
            sb.append(" -> ");
            pointer = pointer.next;
        }

        return sb.append("null").toString();
    }
}
