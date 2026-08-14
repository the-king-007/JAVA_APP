import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double[] marks = new double[3];
    double attendance;

    public Student(int rollNo, String name, double[] marks, double attendance) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.attendance = attendance;
    }

    public double getAverage() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / 3.0;
    }

    public void displayPerformance() {
        double avg = getAverage();
        String result = (avg >= 50) ? "Pass" : "Fail";
        String scholarship = (avg >= 75 && attendance >= 80) ? "Eligible" : "Not Eligible";
        String classification = (avg >= 85) ? "Excellent" : "Good";

        System.out.println("Roll No: " + rollNo + " | Name: " + name);
        System.out.println("Average: " + avg + " | Result: " + result);
        System.out.println("Scholarship: " + scholarship + " | Performance: " + classification);
        System.out.println("--------------------------------------------------");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Roll No: ");
            int roll = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter Marks of your 3 subjects: ");
            double[] marks = new double[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextDouble();
            }
            System.out.println("Enter Attendance %: ");
            double att = sc.nextDouble();
            students[i] = new Student(roll, name, marks, att);
        }

        System.out.println("\n--- STUDENT RESULTS ---");
        int topStudentIndex = 0;
        for (int i = 0; i < 5; i++) {
            students[i].displayPerformance();
            if (students[i].getAverage() > students[topStudentIndex].getAverage()) {
                topStudentIndex = i;
            }
        }

        System.out.println("Highest Scorer: " + students[topStudentIndex].name + 
                           " with Average: " + students[topStudentIndex].getAverage());
        sc.close();
    }
}