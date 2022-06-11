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
        boolean actual = palindrome.isPalindrome("aSa");
        //actual is a palindrome
        assertTrue(actual);
        boolean actual2 = palindrome.isPalindrome("catcatcat");
        //actual2 is not a palindrome
        assertFalse(actual2);
        boolean actual3 = palindrome.isPalindrome("asA");
        //actual2 is not a palindrome
        assertFalse(actual3);
        boolean actual4 = palindrome.isPalindrome("%#### A ? A ####%");
        //actual2 is not a palindrome
        assertTrue(actual4);
        boolean actual5 = palindrome.isPalindrome("%### A ? A *##%");
        //actual2 is not a palindrome
        assertFalse(actual5);
    }

    @Test (timeout = 1000)
    public void isPalindromeSingleTest() {
        boolean actual = palindrome.isPalindrome("a");
        //actual is a palindrome
        assertTrue(actual);
        boolean actual2 = palindrome.isPalindrome("%");
        //actual is a palindrome
        assertTrue(actual2);
        boolean actual3 = palindrome.isPalindrome("A");
        //actual is a palindrome
        assertTrue(actual3);
        boolean actual4 = palindrome.isPalindrome("");
        //actual is a palindrome
        assertTrue(actual4);
    }

    @Test (timeout = 1000)
    public void isPalindromeNullTest() {
        String wd = null;
        boolean actual = palindrome.isPalindrome(wd);
        //actual is a palindrome
        assertTrue(actual);
    }

    @Test
    public void isPalindromeTest2() {
        CharacterComparator cc = new OffByOne();
        boolean actual = palindrome.isPalindrome("&ackbb%", cc);
        boolean actual2 = palindrome.isPalindrome("az", cc);
        assertTrue(actual);
        assertFalse(actual2);
        boolean actual3 = palindrome.isPalindrome("ABab", cc);
        assertFalse(actual3);
        //one char test
        boolean actual4 = palindrome.isPalindrome("a", cc);
        assertTrue(actual4);
        boolean actual5 = palindrome.isPalindrome("A", cc);
        assertTrue(actual5);
        boolean actual6 = palindrome.isPalindrome(")", cc);
        assertTrue(actual6);
        boolean actual7 = palindrome.isPalindrome("", cc);
        assertTrue(actual7);
        //null test

        boolean actual8 = palindrome.isPalindrome(null, cc);
        assertTrue(actual8);
    }
}
