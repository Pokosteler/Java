/*
* @author Nataliya Kozlova
* @version 1.0 
*/

class Cell {
    private int color; // 0 - white, 1 - black
    Cell(int c) {
        this.color = c;
        System.out.print(c + " ");
    }
}
class Board {
    Cell f[][] = new Cell[8][8];
    void init() {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    f[i][j] = new Cell(1);
                }
                else {
                    f[i][j] = new Cell(0);
                }
            }
            System.out.println();
        }
    }
}
public class ChessBoard {
    public static void main(String[] args) {
        new Board().init();
    }
}
