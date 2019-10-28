import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Variable {
    private int count;
    Variable() {
        System.out.println("Enter decimal number: ");
        fromDecimalToBinaryTranslation(getKey());
        System.out.println("Enter binary number: ");
        fromBinaryToDecimalTranslation(getKey());
        System.out.println("Enter octal number: ");
        fromOctalToDecimal(getKey());
        System.out.println("Enter decimal number: ");
        fromDecimalToOctal(getKey());
    }
    void setCount(int count) {
        this.count = count;
    }

    int getCount() {
        return count;
    }

    private int getKey() {
        int direction = 0;
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            direction = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println("Input Error!");
        }
        return direction;
    }

    void fromDecimalToBinaryTranslation(int v) { // convert decimal to binary
        int oldVariable = v;
        while (v != 0) {
            count++;
            v = v / 2;
        }
        int result[] = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = oldVariable % 2;
            oldVariable = oldVariable / 2;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    void fromBinaryToDecimalTranslation(int v) { // convert binary to decimal
        int oldVariable = v;
        count = 0;
        while (v != 0) {
            count++;
            v = v / 10;
        }
        int result[] = new int[count];
        while (oldVariable != 0) {
            for (int i = 0; i < count; i++) {
                result[i] = (int) (Math.pow(2, i) * (oldVariable % 10));
                oldVariable = (oldVariable - (oldVariable % 10)) / 10;
            }
        }
        int summ = 0;
        for (int i = 0; i < result.length; i++) {
            summ += result[i];
        }
        System.out.println(summ);
    }

    void fromOctalToDecimal(int v) { // convert octal to decimal
        int oldVariable = v;
        count = 0;
        while (v != 0) {
            count++;
            v = v / 10;
        }
        int result[] = new int[count];
        while (oldVariable != 0) {
            for (int i = 0; i < count; i++) {
                result[i] = (int) (Math.pow(8, i) * (oldVariable % 10));
                oldVariable = (oldVariable - (oldVariable % 10)) / 10;
            }
        }
        int summ = 0;
        for (int i = 0; i < result.length; i++) {
            summ += result[i];
        }
        System.out.println(summ);
    }

    void fromDecimalToOctal(int v) { // convert decimal to octal
        int oldVariable = v;
        while (v != 0) {
            count++;
            v = v / 8;
        }
        int result[] = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = oldVariable % 8;
            oldVariable = oldVariable / 8;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}

public class NumberTranslation {
    public static void main(String[] args) {
        new Variable();
    }
}
