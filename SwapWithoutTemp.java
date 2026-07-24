public class SwapWithoutTemp {
    public static void main(String[] args) {
        int rollA = 45;
        int rollB = 72;

        System.out.println("Before Swap -> Roll A: " + rollA + ", Roll B: " + rollB);

        rollA = rollA + rollB; 
        rollB = rollA - rollB; 
        rollA = rollA - rollB; 

        System.out.println("After Swap  -> Roll A: " + rollA + ", Roll B: " + rollB);
    }
}