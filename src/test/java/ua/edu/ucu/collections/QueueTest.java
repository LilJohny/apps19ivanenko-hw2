package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(1);
        assertEquals(queue.peek(), 1);
    }
    
}
