import static org.junit.Assert.*;
import org.junit.Test;

public class LLDTest {
    @Test
    public void removeFirstTest(){
        LinkedListDeque<String> actual = new LinkedListDeque<String>();
        actual.addFirst("Zao");
        actual.addFirst("shang");
        actual.addFirst("hao");
        actual.addFirst("a");
        actual.addFirst("shi");
        actual.addFirst("yue");
        actual.addFirst("!");
        String x = actual.removeFirst();
        String expected = "!";
        assertEquals(expected,x);
    }
    @Test
    public void removeLastTest(){
        LinkedListDeque<String> actual = new LinkedListDeque<String>();
        actual.addFirst("Zao");
        actual.addLast("shang");
        actual.addFirst("hao a");
        actual.addFirst("a");
        actual.addLast("shi");
        actual.addFirst("yue");
        actual.addFirst("!");
        String x = actual.removeLast();
        String expected = "shi";
        assertEquals(expected,x);
    }

    @Test
    public void sizeTest(){
        LinkedListDeque<String> actual = new LinkedListDeque<String>();
        actual.addFirst("Zao");
        actual.addFirst("shang");
        int expect = 2;
        assertEquals(expect, actual.size());
        actual.removeFirst();
        actual.removeLast();
        int expect2 = 0;
        assertEquals(expect2, actual.size());
        actual.removeLast();
        actual.removeLast();
        actual.removeLast();
        int expect3 = 0;
        assertEquals(expect2, actual.size());
    }

    @Test
    public void isEmptyTest(){
        LinkedListDeque<String> actual = new LinkedListDeque<>();
        actual.addFirst("Zao");
        actual.addFirst("shang");
        boolean expect = false;
        assertEquals(expect,actual.isEmpty());
        actual.removeFirst();
        actual.removeLast();
        boolean expect2 = true;
        assertEquals(expect2,actual.isEmpty());
    }

    @Test
    public void printDequeTest(){
        LinkedListDeque<String> actual = new LinkedListDeque<>();
        actual.addLast("Zao");
        actual.addLast("shang");
        actual.addLast("hao");
        actual.addLast("Shi");
        actual.addLast("yue");

        actual.printDeque();
        System.out.println("!");
    }
}
