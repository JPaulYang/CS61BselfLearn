public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }
        //Sorry I have to use a constructor here: ArrayDeque()
        Deque<Character> seperatedWord = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            seperatedWord.addLast(word.charAt(i));
        }
        return seperatedWord;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return true;
        }
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        int i = 0;
        while (!wordDeque.isEmpty() && wordDeque.removeFirst() == wordDeque.removeLast()) {
            i++;
        }
        if (i == word.length() / 2) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        //empty and length one cases
        if (word == null) {
            return true;
        }
        if (word.length() <= 1) {
            return true;
        }

        //normal cases
        Deque<Character> wordDeque = wordToDeque(word);
        int i = 0;
        while (wordDeque.size() > 1
                && cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
            i++;
        }
        if (i == word.length() / 2) {
            return true;
        }
        return false;
    }

}
