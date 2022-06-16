package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount += 1;
        if (last == capacity - 1) {
            last = 0;
        } else {
            last += 1;
        }
    }

    /**
     * Dequeue the oldest item in the ring buffer.
     * If the buffer is empty, then throw new
     * RuntimeException("Ring buffer underflow").
     * Exceptions covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T removedItem = rb[first];
        rb[first] = null;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first += 1;
        }
        fillCount -= 1;
        return removedItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
    }

    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }


    private class RingBufferIterator implements Iterator<T> {
        private int wizPos;

        RingBufferIterator() {
            wizPos = first;
        }

        @Override
        public boolean hasNext() {
            return wizPos < fillCount;
        }

        @Override
        public T next() {
            T returnItem = rb[wizPos];
            if (wizPos == last) {
                return returnItem;
            }
            if (wizPos == capacity - 1) {
                wizPos = 0;
            } else {
                wizPos += 1;
            }
            return returnItem;
        }
    }
}
