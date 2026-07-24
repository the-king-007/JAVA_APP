public class HighestScore {
    public static void main(String[] args) {
        int score1 = 88;
        int score2 = 95;
        int score3 = 91;

        int highest = score1;

        if (score2 > highest) {
            highest = score2;
        }
        if (score3 > highest) {
            highest = score3;
        }

        System.out.println("Student 1 Score: " + score1);
        System.out.println("Student 2 Score: " + score2);
        System.out.println("Student 3 Score: " + score3);
        System.out.println("--------------------------");
        System.out.println("Highest Score achieved: " + highest);
    }
}