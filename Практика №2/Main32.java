    public class Main32 {
        public static void main(String args[]) {
            int i = 10;
            String fib = fibonacci(i);
            int[] counts = countDigits(fib);
            int maxCount = 0;
            int maxDigit = 0;
            for (int digit = 9; digit >= 0; digit--) {
                if (counts[digit] > maxCount) {
                    maxCount = counts[digit];
                    maxDigit = digit;
                }
            }
            System.out.println("f(" + i + ") = " + fib + " возвращает [(" + maxCount + ", " + maxDigit + ")]");
        }
        public static String fibonacci(int n) {
            if (n == 0) return "0";
            if (n == 1) return "1";
            String a = "0";
            String b = "1";
            String c = "1";
            for (int i = 2; i <= n; i++) {
                c = addStrings(a, b);
                a = b;
                b = c;
            }
            return b;
        }
        public static String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;

            while (i >= 0 || j >= 0 || carry > 0) {
                int x = (i >= 0) ? num1.charAt(i--) - '0' : 0;
                int y = (j >= 0) ? num2.charAt(j--) - '0' : 0;
                int sum = x + y + carry;
                carry = sum / 10;
                res.append(sum % 10);
            }
            return res.reverse().toString();
        }
        public static int[] countDigits(String number) {
            int[] counts = new int[10];
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                counts[c - '0']++;
            }
            return counts;
        }
    }
