package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;


    public ImmutableLinkedList(ImmutableLinkedList linkedList) {
        head = new Node(linkedList.head);
        Node previousNode = head;
        Node currentNode = linkedList.head.next;
        Node newNode = null;
        while (currentNode.next != null) {
            newNode = new Node(currentNode);
            previousNode.next = newNode;
            newNode.previous = previousNode;
            previousNode = newNode;
            currentNode = currentNode.next;
        }
        tail = new Node(currentNode);
        tail.previous = previousNode;
        length = linkedList.size();
    }


    public ImmutableLinkedList(Object[] objects) {
        Node[] nodes = convertToNodes(objects);
        head = nodes[0];
        tail = nodes[nodes.length - 1];
        length = objects.length;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    private Node[] convertToNodes(Object[] objects) {
        Node[] nodes = new Node[objects.length];
        for (int i = 0; i < objects.length; i++) {
            nodes[i] = new Node(objects[i]);
            if (i - 1 >= 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public Object getLast() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        linkedList.head = linkedList.head.next;
        linkedList.head.previous = null;
        linkedList.length--;
        return linkedList;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        linkedList.tail = linkedList.tail.previous;
        linkedList.tail.next = null;
        linkedList.length--;
        return linkedList;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] objectArray = new Object[]{e};
        return addAll(index, objectArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (this.length == 0){
            ImmutableLinkedList linkedList = new ImmutableLinkedList(c);
            return linkedList;
        }
        if (index <= this.length) {
            ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
            Node[] nodes = convertToNodes(c);
            if (index + c.length < linkedList.length) {
                Node finishNode = linkedList.getNode(index + c.length - 1);
                finishNode.previous = nodes[nodes.length - 1];
            }
            if (index != 0) {
                Node startNode = linkedList.getNode(index - 1);
                startNode.next = nodes[0];
                nodes[0].previous = startNode;
            } else {
                nodes[nodes.length - 1].next = linkedList.head;
                linkedList.head = nodes[nodes.length - 1];
            }

            linkedList.length += c.length;
            return linkedList;
        }
        throw new IndexOutOfBoundsException();

    }

    @Override
    public Object get(int index) {
        if (index < this.size()) {
            int currentIndex = 0;
            Node currentNode = this.head;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode.value;
        }
        throw new IndexOutOfBoundsException();
    }

    private Node getNode(int index) {
        if (index < this.size()) {
            int currentIndex = 0;
            Node currentNode = this.head;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode;
        }
        throw new IndexOutOfBoundsException();
    }


    @Override
    public ImmutableList remove(int index) {
        if (index < size()) {
            ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
            Node currentNode = (Node) linkedList.getNode(index);
            Node parent = currentNode.previous;
            Node child = currentNode.next;
            parent.next = child;
            child.previous = parent;
            linkedList.length--;
            return linkedList;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < size()) {
            ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
            Node currentNode = (Node) linkedList.getNode(index);
            currentNode.value = e;
            return linkedList;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node currentNode = this.head;
        while (index != this.size()) {
            if (currentNode.value == e) {
                return index;
            } else {
                index++;
                currentNode = currentNode.next;
            }
        }
        if (index == this.size()) {
            index = -1;
        }
        return index;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node currentNode = head;
        int i = 0;
        while (currentNode != null) {
            array[i] = currentNode.value;
            i++;
            currentNode = currentNode.next;
        }
        return array;
    }
}
