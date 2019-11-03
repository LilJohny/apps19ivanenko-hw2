package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list;
    public Object peek() {
        return list.getLast();
    }

    public Object pop() {
        Object last = list.getLast();
        list = list.removeLast();
        return last;
    }

    public void push(Object e) {
        list = list.addLast(e);

    }

}
