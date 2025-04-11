public class Main4 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 5;
        int start = (num1 < num2) ? num1 : num2;
        int end = (num1 > num2) ? num1 : num2;
        for (int i = start; i <= end; i++) {
            System.out.print((i * i) + " ");
        }
    }
}