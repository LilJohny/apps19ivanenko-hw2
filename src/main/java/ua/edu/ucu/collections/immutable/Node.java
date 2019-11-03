package ua.edu.ucu.collections.immutable;

final class Node  {
    private Object value;
    private Node next;
    private Node previous;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }


    Node(Object value) {
        this.value = value;
    }

    Node(Node node) {
        value = node.value;
        next = node.next;
        previous = node.previous;
    }
}
