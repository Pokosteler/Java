import java.io.*;
class Hero {
    static String name;
    int x;
    int y;
    static int countSteps = 0;
    Hero(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "Current position " + name + ": [" + x + ", " + y + "]";
    }
}
class Field { //field
    static int field[][] = new int[10][10]; // field initialization
    void init(int p) {  // fill the field by obstacles
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                while(p > 0) {
                    int x = 0 + (int)(Math.random()*10);
                    int y = 0 + (int)(Math.random()*10);
                    if (field[x][y] != 1) {
                        field[x][y] = 1;
                        p--;
                    }
                }
            }
        }
        field[9][0] = 2; // Mario
        field[0][9] = 3; // gold
    }
    void print() {
        int a, b;
        {a = 0;}
        {b = 0;}
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(" " + field[i][j] + " ");
                if(field[i][j] == 2) {
                    a = i;
                    b = j;
                }
            }
            System.out.println();
        }
        System.out.println(new Hero(a, b, "Mario"));
    }
    void swapRightLeft(int a, int b, int n) { // move Mario right/left
        if (field[n][b] != 1) {
            int t = field[n][a];
            field[n][a] = field[n][b];
            field[n][b] = t;
        }
        if (field[n][b] == 1) {  // obstacle check
            System.out.println("Obstacle!");
            field[n][a] = 2;
            field[n][b] = 1;
        }
    }
    void swapUpDown(int a, int b, int n) { // move Mario up/down
        if (field[b][n] != 1) {
            int t = field[a][n];
            field[a][n] = field[b][n];
            field[b][n] = t;
        }
        if (field[b][n] == 1) {  // obstacle check
            System.out.println("Obstacle!");
            field[a][n] = 2;
            field[b][n] = 1;
        }
    }
}
class Game {
    Field f = new Field();
    Hero h = new Hero(9, 0, "Mario");
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
    void play() {
        Field f = new Field();
        f.init(40);
        f.print();
        for (int i = 0; i < f.field.length; i++) {
            for (int j = 0; j < f.field[i].length; j++) {
                if (f.field[i][j] == 2) {
                    try {
                        while(f.field[0][9] == 3) {
                            switch(getKey()) {
                                case 2:
                                    f.swapUpDown(i, i + 1, j);
                                    if (f.field[i+1][j] != 1) {
                                        f.print();
                                        i++;
                                        System.out.println(h.name +
                                                " jumped down");
                                        h.countSteps++;
                                    }
                                    break;
                                case 4:
                                    f.swapRightLeft(j, j - 1, i);
                                    if (f.field[i][j-1] != 1) {
                                        f.print();
                                        j--;
                                        System.out.println(h.name +
                                                " jumped back");
                                        h.countSteps++;
                                    }
                                    break;
                                case 6:
                                    f.swapRightLeft(j, j + 1, i);
                                    if (f.field[i][j+1] != 1) {
                                        f.print();
                                        j++;
                                        System.out.println(h.name +
                                                " jumped forward");
                                        h.countSteps++;
                                    }
                                    break;
                                case 8:
                                    f.swapUpDown(i, i - 1, j);
                                    if (f.field[i-1][j] != 1) {
                                        f.print();
                                        i--;
                                        System.out.println(h.name +
                                                " jumped up");
                                        h.countSteps++;
                                    }
                                    break;
                                default:
                                    f.print();
                                    System.out.println("Input Error!");
                                    break;
                            }
                        }
                        if (f.field[0][9] == 2) {
                            System.out.println("Gold!!!!!");
                            System.out.println("Total number of steps " +
                                    h.name + ": " + h.countSteps);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        f.print();
                        System.out.println("Out of Field!");
                    }
                }
            }
        }
    }
}
public class Mario {
    public static void main(String[] args) {
        new Game().play();
    }
}