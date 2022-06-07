import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void arrayAddLastTest(){
        ArrayDeque actual = new ArrayDeque();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(8);
        int expected = 8;
        assertEquals(expected,actual.getLast());

    }

    @Test
    public void arrayAddFirstTest(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        actual.addLast(34);
        actual.addFirst(118);
        actual.addLast(3);
        actual.addFirst(198);
        actual.addLast(8);
        actual.addFirst(996);
        int expected = 996;


    }

    @Test
    public void arrayGetLastTest(){
        ArrayDeque actual = new ArrayDeque();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(4);
        actual.addLast(333444);
        int expected = 333444;
        assertEquals(expected,actual.getLast());
    }
    @Test
    public void arrayRemoveLastTest(){
        ArrayDeque actual = new ArrayDeque();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(77);
        actual.addLast(333444);
        actual.removeLast();
        int expected = 77;
        assertEquals(expected,actual.getLast());
    }

    @Test
    public void printDequeTest(){
        ArrayDeque actual = new ArrayDeque();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(77);
        actual.addLast(333444);
        ArrayDeque actual2 = new ArrayDeque(actual);
        actual.removeLast();
        actual.addFirst(135);
        actual.addFirst(321);
        actual.addFirst(75);
        actual.addFirst(90);
        actual.addLast(3217);
        actual.printDeque();
        actual2.printDeque();
    }

    @Test
    public void getTest(){
        ArrayDeque actual = new ArrayDeque();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(77);
        actual.addLast(333444);
        int expect = 77;
        assertEquals(expect,actual.get(2));
    }
    @Test
    public void reCapacityTest(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        actual.addLast(34);
        actual.addLast(3);
        actual.addLast(266);
        actual.addLast(77);
        actual.addFirst(333444);
        ArrayDeque expect = new ArrayDeque(actual);
      //  actual.reCapacity(50);
        assertEquals(expect.get(3),actual.get(3));
    }
}
