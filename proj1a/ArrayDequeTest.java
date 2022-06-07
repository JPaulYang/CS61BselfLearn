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
        assertEquals(expected,actual.get(0));
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
        assertEquals(expected,actual.get(actual.size()-1));
    }
}
