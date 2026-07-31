class Marks {
    double subject1;
    double subject2;
    double subject3;

    Marks(double s1, double s2, double s3) {
        this.subject1 = s1;
        this.subject2 = s2;
        this.subject3 = s3;
    }

    // Method to calculate and display total and average marks
    void displayReportCard() {
        double total = subject1 + subject2 + subject3;
        double average = total / 3.0;

        System.out.println("--- Semester Examination Results ---");
        System.out.println("Subject 1: " + subject1);
        System.out.println("Subject 2: " + subject2);
        System.out.println("Subject 3: " + subject3);
        System.out.println("Total Marks Obtained: " + total);
        System.out.println("Average Marks: " + String.format("%.2f", average));
    }
}

public class MainTask7 {
    public static void main(String[] args) {
        Marks studentMarks = new Marks(85.5, 92.0, 78.0);
        studentMarks.displayReportCard();
    }
}