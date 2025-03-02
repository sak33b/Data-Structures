package tests.linkedlist;

import implementations.linkedlist.DoublyLinkedList;
import interfaces.ListI;

public class TestDoublyLinkedList {

    public static void main(String[] args) {
        // Create a test DoublyLinkedList instance
        ListI<Integer> list = new DoublyLinkedList<>();

        // Test isEmpty
        System.out.println("Test: isEmpty()");
        System.out.println("Expected: true");
        System.out.println("Actual: " + list.isEmpty()); // Should print true
        System.out.println();

        // Test add() and size()
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Test: add() and size()");
        System.out.println("Expected array: [1, 2, 3]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [1, 2, 3]
        System.out.println("Expected size: 3");
        System.out.println("Actual size: " + list.size()); // Should print 3
        System.out.println();

        // Test get() and set()
        System.out.println("Test: get() and set()");
        System.out.println("Expected get(1): 2");
        System.out.println("Actual get(1): " + list.get(1)); // Should print 2
        list.set(1, 10);
        System.out.println("Expected array after set(1, 10): [1, 10, 3]");
        System.out.println("Actual array after set(1, 10): " + java.util.Arrays.toString(list.toArray())); // Should print [1, 10, 3]
        System.out.println();

        // Test addFirst() and addLast()
        list.addFirst(0);
        list.addLast(4);
        System.out.println("Test: addFirst() and addLast()");
        System.out.println("Expected array: [0, 1, 10, 3, 4]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [0, 1, 10, 3, 4]
        System.out.println();

        // Test removeFirst() and removeLast()
        System.out.println("Test: removeFirst() and removeLast()");
        System.out.println("Expected removeFirst(): 0");
        System.out.println("Actual removeFirst(): " + list.removeFirst()); // Should print 0
        System.out.println("Expected removeLast(): 4");
        System.out.println("Actual removeLast(): " + list.removeLast()); // Should print 4
        System.out.println("Expected array after removeFirst and removeLast: [1, 10, 3]");
        System.out.println("Actual array after removeFirst and removeLast: " + java.util.Arrays.toString(list.toArray())); // Should print [1, 10, 3]
        System.out.println();

        // Test remove() by element
        list.remove(Integer.valueOf(10));
        System.out.println("Test: remove() by element");
        System.out.println("Expected array: [1, 3]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [1, 3]
        System.out.println();

        // Test contains() method
        System.out.println("Test: contains()");
        System.out.println("Expected contains(3): true");
        System.out.println("Actual contains(3): " + list.contains(3)); // Should print true
        System.out.println("Expected contains(10): false");
        System.out.println("Actual contains(10): " + list.contains(10)); // Should print false
        System.out.println();

        // Test indexOf() method
        System.out.println("Test: indexOf()");
        System.out.println("Expected indexOf(3): 1");
        System.out.println("Actual indexOf(3): " + list.indexOf(3)); // Should print 1
        System.out.println("Expected indexOf(10): -1");
        System.out.println("Actual indexOf(10): " + list.indexOf(10)); // Should print -1
        System.out.println();

        // Test peekFirst() and peekLast()
        System.out.println("Test: peekFirst() and peekLast()");
        System.out.println("Expected peekFirst(): 1");
        System.out.println("Actual peekFirst(): " + list.peekFirst()); // Should print 1
        System.out.println("Expected peekLast(): 3");
        System.out.println("Actual peekLast(): " + list.peekLast()); // Should print 3
        System.out.println();

        // Test reverse()
        list.reverse();
        System.out.println("Test: reverse()");
        System.out.println("Expected array: [3, 1]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [3, 1]
        System.out.println();

        // Test clear()
        list.clear();
        System.out.println("Test: clear()");
        System.out.println("Expected array: []");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print []
        System.out.println();

        // Test adding at index
        list.add(0, 5);
        list.add(1, 10);
        System.out.println("Test: add(index, element)");
        System.out.println("Expected array: [5, 10]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [5, 10]
        System.out.println();

        // Test removing by index
        list.remove(0);
        System.out.println("Test: remove(index)");
        System.out.println("Expected array: [10]");
        System.out.println("Actual array: " + java.util.Arrays.toString(list.toArray())); // Should print [10]
        System.out.println();

        // Test toArray() method
        Object[] array = list.toArray();
        System.out.println("Test: toArray()");
        System.out.println("Expected array: [10]");
        System.out.println("Actual array: " + java.util.Arrays.toString(array)); // Should print [10]
    }
}
