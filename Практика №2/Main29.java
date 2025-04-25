public class Main29 {
    public static void main(String args[]) {
        int n = 8836; //любое число

        String result = find(n);
        
        System.out.println(result);
    }
    public static String find(int n) {
        if (n <= 0 || n > 100000) {
            return "диапазон числа: 0 < n <= 100000";
        }
        if (n % 2 == 1) {
            int k = (n - 1) / 2;
            int square1 = k * k;
            int square2 = (k + 1) * (k + 1);
            return square2 + " - " + square1 + " = " + n;
        }
        else if (n % 4 == 0) {
            int k = (n / 4) - 1;
            int square1 = k * k;
            int square2 = (k + 2) * (k + 2);
            return square2 + " - " + square1 + " = " + n;
        }
        else {
            return "Нельзя представить " + n + " как разность квадратов";
        }
    }
}