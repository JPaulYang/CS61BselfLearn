import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class TestOffByN {

    @Test
    public void offByNTest() {
        CharacterComparator offBy5 = new OffByN(5);

        boolean actual1 = offBy5.equalChars('a', 'f');
        assertTrue(actual1);
        boolean actual2 = offBy5.equalChars('f', 'a');
        assertTrue(actual2);
        boolean actual3 = offBy5.equalChars('f', 'h');
        assertFalse(actual3);
        CharacterComparator offBy2 = new OffByN(2);
        boolean actual4 = offBy2.equalChars('f', 'h');
        assertTrue(actual4);

    }
}
