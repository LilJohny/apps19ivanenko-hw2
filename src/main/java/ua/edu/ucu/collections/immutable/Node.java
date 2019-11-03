package ua.edu.ucu.collections.immutable;

public final class Node  {
    public Object value;
    public Node next;
    public  Node previous;


    public Node(Object value){
        this.value = value;
    }

    public Node(Node node){
        value = node.value;
        next = node.next;
        previous = node.previous;
    }
}
