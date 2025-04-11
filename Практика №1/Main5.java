public class Main5 {
    public static void main(String args[]) {
        int start = 1;
        int step = 2;
        int steps = 5;
        for (int i = 0; i < steps; i++) {
            int currentNumber = start + i * step;
            System.out.print(currentNumber + " ");
        }
    }
}
