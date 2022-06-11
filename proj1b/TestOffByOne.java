import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void offByOneTest() {
        char a = 'x';
        char a2 = 'y';
        assertTrue(offByOne.equalChars(a, a2));
        char b = 'Z';
        char b2 = 'Z';
        assertFalse(offByOne.equalChars(b, b2));
        char c = 'A';
        char c2 = 'b';
        assertFalse(offByOne.equalChars(c, c2));
        char d = '%';
        char d2 = '&';
        assertTrue(offByOne.equalChars(d, d2));
    }

}
