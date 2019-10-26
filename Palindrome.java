import java.io.*;
class Word {
    Word() {
        System.out.println("Enter your word: ");
        setWord(getKey());
        validatePalindromeWord(getWord());
    }
    private String word;
    void setWord(String word) {
        this.word = word;
    }
    String getWord() {
        return word;
    }
    String getKey() {
        String direction = "";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in, "Cp866"));
            direction = String.valueOf(br.readLine());
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
        return direction;
    }
    private void validatePalindromeWord(String s) {
        char arrStringBackwards[] = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            arrStringBackwards[s.length() - i - 1] = s.charAt(i);
        }
        if(s.replaceAll(" ","").equalsIgnoreCase(String.valueOf
                (arrStringBackwards).replaceAll(" ",""))) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("It's not a palindrome!");
        }
    }
}
public class Palindrome {
    public static void main(String[] args) {
        new Word();
    }
}
