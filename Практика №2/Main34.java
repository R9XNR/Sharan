public class Main34 {
    public static void main(String args[]) {
        long n = 18; //начальное кол во палок
        long TanyaSticks = Calculator(n);
        System.out.println("У Тани будет " + TanyaSticks + " палочек");
    }

 public static long Calculator(long n) {
        long tanyaCount = 0;
        boolean Tanya = true;

        while (n > 0) {
            long taken;
            if (n % 2 == 0) {
                taken = n / 2;
            } else {
                taken = 1;
            }
            n -= taken;
            if (Tanya) {
                tanyaCount += taken;
            }
            Tanya = !Tanya;
        }
        return tanyaCount;
    }
}