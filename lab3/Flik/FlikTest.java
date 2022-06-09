import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void sameTest(){
        int a = 128;
        int b = 128;

        boolean expect = true;
        boolean actual = Flik.isSameNumber(a,b);
        assertEquals(expect, actual);
    }
}
