public class SwapWithTemp {
    public static void main(String[] args) {
        int rollA = 45;
        int rollB = 72;

        System.out.println("Before Swap -> Roll A: " + rollA + ", Roll B: " + rollB);

        int temp = rollA;
        rollA = rollB;
        rollB = temp;

        System.out.println("After Swap  -> Roll A: " + rollA + ", Roll B: " + rollB);
    }
}