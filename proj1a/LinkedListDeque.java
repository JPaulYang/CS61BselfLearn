/**At this point, we would like to try out the
 * 1. doubly linked IntList (done), if it is successful,
 * we will move to the
 * 2. creation of sentinel (done), then
 * 3. double sentinel, then
 * 4. circular sentinel,
 * after geting all the necessary ideas we will move to
 * 5. doubly linked typeList by generics
 */

public class LinkedListDeque <T> {
    private int size;
    private TNode sentinelF;
    private TNode sentinelL;
    private TNode searchPointer;
    //use this to search indexed item,
    // only used in getRecursive
  //  public LinkedListDeque last;
    private class TNode<T> {
        //instance variables
        private TNode next;
        private T item;
        private TNode prev;
        //parameter constructor
        public TNode(TNode prev,T item,TNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /** There are three constructor here
     *  1. Default constructor take no parameter
     *  2. Parameter constructor,
     *  take an int (will change to type)
     *  3. Copy constructor, LinkedListDeque
     *  as a parameter, deep copy of this thing
     */
    //Default constructor to construct an empty Deque
    public LinkedListDeque() {
        size = 0;
        sentinelF = new TNode(null,"Front sentinel",null);
        sentinelL = new TNode(null,"Last sentinel",null);
        sentinelF.next = sentinelL;
        sentinelL.prev = sentinelF;
        searchPointer = sentinelF.next;
    }
    //Parameter constructor


    /** Several instance method (member functions)
     *  to modify the naked Deque indirectly.
     */

    //Judge if the Deque is empty
    public boolean isEmpty() {
        if (sentinelF.next == sentinelL) {
            return true;
        }
        return false;
    }
    /**Add a node in front of the first node
     * variable temp store the address
     * of the old 1st node (now the 2nd)*/
    public void addFirst(T x) {
        //sentinelF.next is the first meaningful node
        TNode temp = sentinelF.next;
        //middle is the node we want to insert between the front sentinel and the first node
        TNode middle = new TNode(sentinelF,x,temp);
        sentinelF.next = middle;
        temp.prev = middle;
        size+=1;
        searchPointer = sentinelF.next;
    }
    /**Add a node after the last node
     * variable temp store the old
     * last node (now the 2nd last)
     */
    public void addLast(T x) {
        TNode temp = sentinelL.prev;
        TNode middle = new TNode(temp,x,sentinelL);
        sentinelL.prev = middle;
        temp.next = middle;
        size +=1;
        searchPointer = sentinelF.next;
    }

    /**Remove the first node, temp is the next
     * node of the removed one
     */

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TNode temp = sentinelF.next.next;
        T removedItem = (T) sentinelF.next.item;
        temp.prev = sentinelF;
        sentinelF.next = temp;
        size -= 1;
        searchPointer = sentinelF.next;
        return removedItem;
    }

    /**Remove the last node, temp is
     * the previous node of the removed one
     * @author Jiannan
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        TNode temp = sentinelL.prev.prev;
        T removedItem = (T) sentinelL.prev.item;
        temp.next = sentinelL;
        sentinelL.prev = temp;
        size -= 1;
        searchPointer = sentinelF.next;
        return removedItem;
    }


    //print the list
    public void printDeque() {
        TNode temp = sentinelF;
        while(temp != sentinelL.prev) {
            System.out.print(temp.next.item + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    //Return the number of item in deque
    public int size() {
        return size;
    }

    //Get the index-th item in the list (Iterative)
    public T get(int index) {
        if (isEmpty() || index < 0 || index > size){
            return null;
            //change it to null for a generic type
        }
        TNode searchPinter = sentinelF;
        int i = 0;
        while(i <= index) {
            searchPinter = searchPinter.next;
            i++;
        }
        if (searchPinter == sentinelL) {
            return null;
            //change to null for a generic type
        }
        return (T) searchPinter.item;
    }
    //Get the index-th item in the list (Recursive)

    public T getRecursive(int index) {
        if (isEmpty() || index < 0 || index > size) {
            searchPointer = sentinelF.next;
            return null;//change it to null
        }
        if (index == 0) {
            TNode temp = searchPointer;
            searchPointer = sentinelF.next;
            return (T) temp.item;
        }
            searchPointer = searchPointer.next;
            return getRecursive(index - 1);
    }
}
