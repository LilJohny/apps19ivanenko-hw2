package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private Object[] array;
    private final int DEFAULT_SIZE = 100;
    private int length;

    public ImmutableArrayList() {
        array = new Object[DEFAULT_SIZE];
        this.length = 0;
    }

    public ImmutableArrayList(int size) {
        array = new Object[size];
        this.length = 0;
    }

    public ImmutableArrayList(Object[] array) {
        this.array = new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.length = array.length;
    }


    @Override
    public ImmutableList add(Object e) {
        Object[] array = new Object[1];
        array[0] = e;
        return this.addAll(array);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] array = new Object[1];
        array[0] = e;
        return this.addAll(index, array);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList returnObject = new ImmutableArrayList(this.length + c.length);
        return returnObject.addAll(0, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        int length;
        if (index > this.length) {
            length = index + c.length;
        } else {
            length = this.length + c.length;
        }
        Object[] returnArray = new Object[length];
        int first = Math.min(index, this.length);
        System.arraycopy(this.array, 0, returnArray, 0, first);
        System.arraycopy(c, 0, returnArray, index, c.length);
        int last = this.length - first;
        if (last != 0) {
            System.arraycopy(this.array, index, returnArray, index + c.length, last);
        }
        ImmutableArrayList returnObject = new ImmutableArrayList(returnArray);
        return returnObject;
    }

    @Override
    public Object get(int index) {
        if (this.length - index > 0) {
            return this.array[index];
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < this.length) {
            Object[] newArray = new Object[this.array.length - 1];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index + 1, newArray, index , this.array.length-1 - (index ));
            ImmutableArrayList returnObject = new ImmutableArrayList(newArray);
            return returnObject;
        }
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < this.length) {
            ImmutableArrayList returnObject = new ImmutableArrayList();
            returnObject.array[index] = e;
            return returnObject;
        }
        return null;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.length];
        System.arraycopy(this.array, 0, array, 0, this.length);
        return array;
    }
}
