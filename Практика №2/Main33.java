public class Main33 {
    public static void main(String args[]) {
        long n = 13; // начальное кол во палок
        boolean canWin = Win(n);
        System.out.println(canWin ? "Саша выиграет" : "Саша проиграет");
    }
    public static boolean Win(long n) {
        if (n == 1) return true;
        if (n == 2) return true;
        if (n == 3) return false;
        for (;;) {
            if (n % 2 == 1) {
                n -= 1;
                if (n == 0) return true;
            } else {
                long half = n / 2;
                if (half % 2 == 1) {
                    n = half;
                } else {
                    n -= 1;
                }
                if (n == 0) return true;
            }
            if (n % 2 == 1) {
                n -= 1;
            } else {
                long half = n / 2;
                if (half % 2 == 1) {
                    n = half;
                } else {
                    n -= 1;
                }
            }
            if (n == 0) return false;
        }
    }
}