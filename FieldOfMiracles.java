import java.io.*;

class GameFieldOfMiracles {
    private String word;

    GameFieldOfMiracles() {
        play();
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    private String getKey() {
        String direction = "";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            direction = String.valueOf(br.readLine());
        } catch (IOException ex) {
            System.out.println("Input Error!");
        }
        return direction;
    }

    private void play() {
        setWord("wordwordword");
        String changeableWord = getWord();
        int count = 0;
        for (String ch : changeableWord.split("")) {
            changeableWord = changeableWord.replaceAll(ch, "_");
        }
        String changeableArray[] = changeableWord.split("");
        changeableWord = "";
        String inputString = "";
        while (!changeableWord.equals(getWord()) ||
                !inputString.equals(getWord())) {
            System.out.print("Key in one character or your guess word: ");
            inputString = getKey();
            if (!inputString.equals(getWord())) {
                if (getWord().contains(inputString)) {
                    int i = -1;
                    while (i < getWord().length() - 1) {
                        String c = getWord().substring(i + 1, i + 2);
                        if (c.equals(inputString)) {
                            changeableArray[i + 1] =
                                    changeableArray[i + 1].replaceAll
                                            (changeableArray[i + 1], inputString);
                        }
                        i++;
                    }
                    count++;
                    for (String ch : changeableArray) {
                        changeableWord += ch;
                    }
                    System.out.println("Trail " + count + ": " + changeableWord);
                    if (!changeableWord.equals(getWord())) {
                        changeableWord = "";
                    }
                } else {
                    count++;
                    System.out.println("Trail " + count + ": Try again");
                }
            }
            if (inputString.equals(getWord()) ||
                    changeableWord.equals(getWord())) {
                count++;
                System.out.println("Trail " + count + ": " + "Congratulation!");
                break;
            }
        }
        System.out.println("You got in " + count + " trials");
    }
}

public class FieldOfMiracles {
    public static void main(String[] args) {
        new GameFieldOfMiracles();
    }
}
