package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public ImmutableLinkedList addFirst(Object e) {

        return null;
    }

    public ImmutableLinkedList addLast(Object e) {
        Node newNode = new Node(e);
        Node newTail = tail.clone();
        this.tail.setNext(newNode);
    }

    public Object getFirst() {
        return null;
    }

    public Object getLast() {
        return null;
    }

    public ImmutableLinkedList removeFirst() {
        return null;
    }

    public ImmutableLinkedList removeLast() {
        return null;
    }

    @Override
    public ImmutableList add(Object e) {
        return null;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        if (index < this.size()) {
            int currentIndex = 0;
            Node currentNode = this.head;
            while (currentIndex != index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            return currentNode.getValue();
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node currentNode = this.head;
        while (index != this.size()) {
            if (currentNode.getValue() == e) {
                return index;
            } else {
                index++;
                currentNode = currentNode.getNext();
            }
        }
        if (index == this.size()) {
            index = -1;
        }
        return index;
    }

    @Override
    public int size() {
        int length = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        return new Object[0];
    }
}
