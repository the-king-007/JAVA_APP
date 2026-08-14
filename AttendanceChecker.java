import java.util.Scanner;

public class AttendanceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] attendance = new int[7];
        int presentCount = 0;

        for (int i = 0; i < 7; i++) {
            attendance[i] = scanner.nextInt();
        }

        for (int i = 0; i < 7; i++) {
            if (attendance[i] == 1) {
                presentCount++;
            }
        }

        double percentage = ((double) presentCount / 7) * 100;

        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }

        scanner.close();
    }
}