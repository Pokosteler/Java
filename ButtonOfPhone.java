class Phone {
    Phone() {
       System.out.println(TypeSMS("abcdefghijklmnopqrstuvwxyz")); 
    }
    private char[] digits = {'1', '2', '3',
            '4', '5', '6',
            '7', '8', '9',
            '0'};
    private String[] letters = {"", "abc", "def",
            "ghi", "jkl", "mno",
            "pq", "stu", "vwx",
            "yz"};
    public void setDigits(char[] digits) {
        this.digits = digits;
    }
    public char[] getDigits() {
        return digits;
    }
    public void setLetters(String[] letters) {
        this.letters = letters;
    }
    public String[] getLetters() {
        return letters;
    }
    private String TypeSMS(String s) {
        String setOfButtons = "";
        if (s != "") {
            for (int i = 0; i < s.length(); i++) {
                if (getLetters()[1].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[1]+ "(" +
                            (getLetters()[1].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[2].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[2]+ "(" +
                            (getLetters()[2].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[3].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[3]+ "(" +
                            (getLetters()[3].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[4].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[4]+ "(" +
                            (getLetters()[4].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[5].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[5]+ "(" +
                            (getLetters()[5].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[6].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[6]+ "(" +
                            (getLetters()[6].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[7].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[7]+ "(" +
                            (getLetters()[7].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[8].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[8]+ "(" +
                            (getLetters()[8].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
                if (getLetters()[9].contains(String.valueOf(s.charAt(i)))) {
                    System.out.print(getDigits()[9]+ "(" +
                            (getLetters()[9].indexOf(s.charAt(i)) + 1)
                            + " times) ");
                }
            }
            return setOfButtons;
        }
        return "word don't exist";
    }
}
public class ButtonOfPhone {
    public static void main(String[] args) {
        new Phone();
    }
}
