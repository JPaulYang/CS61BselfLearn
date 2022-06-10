import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void offByOneTest() {
        char x = 'x';
        char y = 'y';
        assertTrue(offByOne.equalChars(x, y));
        char z = 'Z';
        char z2 = 'Z';
        assertFalse(offByOne.equalChars(z, z2));
    }

}
