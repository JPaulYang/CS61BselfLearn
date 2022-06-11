import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test (timeout = 1000)
    public void isPalindromeTest() {
        boolean actual = palindrome.isPalindrome("@aSkSa@");
        //actual is a palindrome
        assertTrue(actual);
        boolean actual2 = palindrome.isPalindrome("catcatcat");
        //actual2 is not a palindrome
        assertFalse(actual2);
        boolean actual1 = palindrome.isPalindrome("a");
        assertTrue(actual1);
        boolean actual3 = palindrome.isPalindrome("");
        assertTrue(actual3);
        boolean actual4 = palindrome.isPalindrome(null);
        //actual is a palindrome
        assertTrue(actual4);
    }



    @Test
    public void isPalindromeTest2() {
        CharacterComparator cc = new OffByOne();
        boolean actual = palindrome.isPalindrome("ackbb", cc);
        boolean actual2 = palindrome.isPalindrome("az", cc);
        assertTrue(actual);
        assertFalse(actual2);
        boolean actual3 = palindrome.isPalindrome("asdfgj", cc);
        assertFalse(actual3);
        //one char test
        boolean actual4 = palindrome.isPalindrome("a", cc);
        //actual is a palindrome
        assertTrue(actual4);
        boolean actual5 = palindrome.isPalindrome(null, cc);
        //actual is a palindrome
        assertTrue(actual5);
    }
}
