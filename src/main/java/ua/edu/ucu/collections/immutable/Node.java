package ua.edu.ucu.collections.immutable;

public class Node  {
    private Object value;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Object value){
        this.value = value;
    }
    public Node clone(){
        Object newValue = value.
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
