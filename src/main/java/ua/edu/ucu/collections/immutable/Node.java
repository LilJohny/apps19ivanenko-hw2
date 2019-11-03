package ua.edu.ucu.collections.immutable;

final class Node  {
    Object value;
    Node next;
    Node previous;


    Node(Object value) {
        this.value = value;
    }

    Node(Node node) {
        value = node.value;
        next = node.next;
        previous = node.previous;
    }
}
