import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<String> actual = new ArrayDeque<>();
        actual.addFirst("zaoshanghao");
        actual.addFirst("shazigege");
        actual.addFirst("nishishei");
        actual.addFirst("nishishei");
        actual.addFirst("nishsishei");
        actual.addFirst("nishishei");
        actual.addFirst("nisahishei");
        actual.addFirst("niszhishei");
        actual.addFirst("nisvhishei");
        actual.addFirst("shaznigege");
        actual.addLast("shaz2igege");

        String expected = "shaznigege";
        assertEquals(expected, actual.get(0));
    }
    @Test
    public void addLastTest() {
        ArrayDeque<String> actual = new ArrayDeque<>();
        actual.addFirst("zaoshanghao");
        actual.addFirst("shazigege");
        actual.addFirst("nishishei");

        actual.addFirst("nishsishei");
        actual.addFirst("nishishei");
        actual.addFirst("nisahishei");
        actual.addFirst("niszhishei");
        actual.addLast("shaz2igege");
        actual.addFirst("shaznigege");
        actual.addFirst("123");
        actual.addFirst("1111");
        String expected = "shaz2igege";
        assertEquals(expected, actual.get(actual.size() - 1));
    }

    @Test
    public void sizeTest() {
        ArrayDeque<Integer> actual = new ArrayDeque<>();
        actual.addLast(33);
        int expect1 = 1;
        assertEquals(expect1, actual.size());
        actual.removeFirst();
        actual.removeFirst();
        int expect2 = 0;
        assertEquals(expect2, actual.size());
    }
    @Test
    public void removeFirstTest() {
        ArrayDeque<String> actual = new ArrayDeque<>();
        actual.addLast("jinhsiyue");
        actual.addFirst("jinhsiyu==e");
        actual.addLast("jinhsiyue");
        String act = actual.removeFirst();
        String expect = "jinhsiyu==e";
        assertEquals(expect, act);
        String expect2 = "jinhsiyue";
        String act2 = actual.removeFirst();
        assertEquals(expect2, act2);
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<String> actual = new ArrayDeque<>();
        actual.addLast("jinhsiyue");
        actual.addFirst("jinhsiyu==e");
        actual.addLast("jinhsiyue");
        String act = actual.removeLast();
        String expect = "jinhsiyue";
        assertEquals(expect, act);
        actual.removeLast();
        actual.removeLast();
        String act2 = actual.removeLast();
        String expect2 = null;
        assertEquals(expect2, act2);
    }

    @Test
    public void removeLastIntegerTest() {
        ArrayDeque<Integer> act = new ArrayDeque<>();
        act.addFirst(0);
        act.addFirst(1);
        act.addFirst(2);
        int actual = act.removeLast();
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test //Shrink the capacity when the size is reduced to less than 1/2 of the capacity
    public void sizeMemoryTest() {
        ArrayDeque<String> actual = new ArrayDeque<>();
        int expect1 = 8;
        /** change the private capacity() to public before running this test */
     //   assertEquals(expect1,actual.capacity());
        actual.addFirst("shanghai");
        actual.addFirst("shagged");
        actual.addFirst("heathenish");
        actual.addFirst("garnisheeing");
        actual.addFirst("heathenish");
        actual.addFirst("fishy");
        actual.addFirst("garnisheeing");
        actual.addLast("jungle");
        actual.addFirst("forest");
        int expect2 = 16;
     //   assertEquals(expect2,actual.capacity());
        actual.removeFirst();
        actual.removeFirst();
        actual.removeFirst();
        actual.removeFirst();
        actual.removeFirst();
        actual.removeFirst();
        actual.removeFirst();
        int expect3 = 8;
      //  assertEquals(expect3,actual.capacity());
    }

    @Test //get test
    public void getTest() {
        ArrayDeque<Integer> act = new ArrayDeque<>();
        act.addFirst(1);
        act.addFirst(2);
        act.addFirst(13);
        act.addFirst(14);
        act.addFirst(19);
        act.addFirst(15);
        act.addFirst(16);
        act.addFirst(17);
        act.addFirst(18);
        act.addLast(89);
        int actual = act.get(9);
        int expect = 89;
        assertEquals(expect, actual);
    }

}
