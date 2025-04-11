public class Main6 {
    public static void main(String args[]) {
        int[] massive = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] inputs = {1, 6, 4, 9, 2};
        for (int input : inputs) {
            AddNumInMassive(massive, input);
            printMassive(massive);
        }
    }
    public static void AddNumInMassive(int[] massive, int number) {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == Integer.MIN_VALUE) {
                massive[i] = number;
                return;
            }
        }
        int minIndex = 0;
        for (int i = 1; i < massive.length; i++) {
            if (massive[i] < massive[minIndex]) minIndex = i;
        }
        if (number > massive[minIndex]) massive[minIndex] = number;
    }
    public static void printMassive(int[] massive) {
        System.out.print("Память: ");
        for (int num : massive) {
            System.out.print((num == Integer.MIN_VALUE ? "пусто" : num) + " ");
        }
        System.out.println();
    }
}
