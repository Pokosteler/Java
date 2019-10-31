import java.util.*;

class Diagram {
    int counters[] = new int[10];

    void print(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 0 && marks[i] < 10) {
                counters[0]++;
            }
            if (marks[i] >= 10 && marks[i] < 20) {
                counters[1]++;
            }
            if (marks[i] >= 20 && marks[i] < 30) {
                counters[2]++;
            }
            if (marks[i] >= 30 && marks[i] < 40) {
                counters[3]++;
            }
            if (marks[i] >= 40 && marks[i] < 50) {
                counters[4]++;
            }
            if (marks[i] >= 50 && marks[i] < 60) {
                counters[5]++;
            }
            if (marks[i] >= 60 && marks[i] < 70) {
                counters[6]++;
            }
            if (marks[i] >= 70 && marks[i] < 80) {
                counters[7]++;
            }
            if (marks[i] >= 80 && marks[i] < 90) {
                counters[8]++;
            }
            if (marks[i] >= 90 && marks[i] <= 100) {
                counters[9]++;
            }
        }
        System.out.println();
        String dataForDiagramm[][] = new String[marks.length][10];
        for (int j = 0; j < 10; j++) {
            for (int i = (marks.length - 1); i > (marks.length - 1) - counters[j]; i--) {
                dataForDiagramm[i][j] = "   *   ";
            }
        }
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (dataForDiagramm[i][j] == null) {
                    dataForDiagramm[i][j] = "       ";
                }
                System.out.print(dataForDiagramm[i][j]);
            }
            System.out.println();
        }
        System.out.println(" (0-9) (10-19)(20-29)(30-39)(40-49)(50-59)(60-69)"
                + "(70-79)(80-89)(90-100)");
    }
}

class DataOfStudents extends Diagram {
    DataOfStudents() {
        enterMarks();
    }

    Scanner s = new Scanner(System.in);
    int amount = s.nextInt();
    int marks[] = new int[amount];

    void enterMarks() {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(i + 1 + " student grade: ");
            try {
                marks[i] = s.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    s.nextLine();
                    i--;
                    System.out.println("Input Error! Try again!");
                }
            } catch (InputMismatchException ex) {
                s.nextLine();
                i--;
                System.out.println("Input Error! Try again!");
            }
        }
        print(marks);
    }
}

public class StudentPerformance {
    public static void main(String[] args) {
        System.out.print("Amount of students: ");
        new DataOfStudents();
    }
}
