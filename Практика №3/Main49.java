public class Main49 {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
        }
    }
    public static int fusc(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;  // fusc(0)
        int b = 1;  // fusc(1)
        while (n > 0) {
            if (n % 2 == 0) {
                b += a;  // Следующий шаг
                n /= 2;
            } else {
                a += b;
                n = (n - 1) / 2;
            }
        }
        return a;
    }
}