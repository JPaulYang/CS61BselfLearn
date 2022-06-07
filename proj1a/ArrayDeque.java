/** I will still create the integer array deque first for simplicity
 * and then change it to T type
 */

public class ArrayDeque <T> {
    private T[] items;
    private int size;
    private int nextLast;
    private int nextFirst;

    //The default constructor
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[100];
        nextFirst = 50;
        nextLast = 51;
    }



    /** Several methods (add/remove/get/isEmpty/etc.) */
    public int size() {
        return size;
    }

    private boolean isFull() {
        if (size == items.length){
            return true;
        }
        return false;
    }

    public void printDeque() {

        int i = realFirstIndex();
        while(i!=realLastIndex()+1) {
            System.out.print(items[i] + " ");
            if (i == items.length-1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.println("");
    }


    //Add methods: add first:
    public void addFirst(T newItem) {
        if (isFull()) {
            reCapacity(2 * items.length);
        }
        items[nextFirst] = newItem;
        if (firstTouchHead()) {
            nextFirst = size -1;
        } else {
            nextFirst -= 1;
        }
        size++;
    }
    //Add methods: add last:
    public void addLast(T newItem) {
        if (isFull()) {
            reCapacity(2 * size);
        }
        items[nextLast] = newItem;
        if (lastTouchTail()) {// Making it Circular
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size ++;
    }

    //get methods

    public T get(int index) {
        int backLength = items.length - realFirstIndex();
        if (realFirstIndex() < realLastIndex()
                ||index <= backLength - 1) {
            return items[realFirstIndex()+index];
        } else {
            return items[index - backLength];
        }
    }

    //Remove methods: remove last
    public T removeLast() {
        T removedItem;
        size = size - 1;
        if (lastTouchHead()) {
            nextLast = items.length;//move it to the right of the tail/ items[items.length-1]
        }
        nextLast = nextLast - 1;
        removedItem = items[nextLast];
        items[nextLast] = null;//change it to null for T type
        return removedItem;
    }

    public T removeFirst() {
        T removedItem;
        size = size - 1;
        if (firstTouchTail()) {
            nextFirst = -1;//move it to the left of the head/ items[0]
        }
        nextFirst = nextFirst + 1;
        removedItem = items[nextFirst];
        items[nextFirst] = null;//change it to null for T type
        return removedItem;
    }

    /** Helper methods */

    //Alter the size of the list
    private void reCapacity(int newCapacity) {//change it to private once bug fixed
        if (realFirstIndex() < realLastIndex()) {
            T[] CopyCat = (T[]) new Object[newCapacity];
            System.arraycopy(items , realFirstIndex() , CopyCat , realFirstIndex(),size());
            items = CopyCat;
        } else {
            int frontLength = realLastIndex() + 1;
            int backLength = items.length - realFirstIndex();
            T[] CopyCat = (T[]) new Object[newCapacity];
            System.arraycopy(items , 0 , CopyCat , 0,frontLength);
            System.arraycopy(items , realFirstIndex() , CopyCat , newCapacity - backLength , backLength);
            items = CopyCat;
            nextFirst = newCapacity - backLength - 1;
            //There are more space in the middle, so it is okay to minus 1
        }

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    //nextFirst/nextLast reach the head of the array
    private boolean firstTouchHead() {
        if (nextFirst == 0) {
            return true;
        }
        return false;
    }
    private boolean lastTouchHead() {
        if (nextFirst == 0) {
            return true;
        }
        return false;
    }

    //nextFirst/nextLast reach the last box in the array

    private boolean firstTouchTail() {
        if (nextFirst == items.length - 1) {
            return true;
        }
        return false;
    }
    private boolean lastTouchTail() {
        if (nextLast == items.length - 1) {
            return true;
        }
        return false;
    }

    private int realFirstIndex() {
        if (firstTouchTail())
        {
            return 0;
        }
        return nextFirst+1;
    }
    private int realLastIndex() {
        if (lastTouchHead())
        {
            return items.length - 1;
        }
        return nextLast - 1;
    }
}
