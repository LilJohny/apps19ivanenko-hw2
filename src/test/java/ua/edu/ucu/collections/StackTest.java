package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(stack.peek(), 1);
    }
    
}
