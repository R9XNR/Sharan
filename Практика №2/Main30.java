
public class Main30 {
    public static void main(String args[]) {
                int number = 6875;  // число для проверки
        int start = 9; // начало
        if (isSpecialNumber(number, start)) {
            System.out.println("Условие выполняется для числа " + number + 
                             " с начальной степенью " + start);
        } else {
            System.out.println("Условие НЕ выполняется");
        }
    }
        public static boolean isSpecialNumber(int number, int startPower) {
        int[] digits = getDigits(number);
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += power(digits[i], startPower + i);
        }
        if (sum % number == 0) {
            int multiplier = sum / number;
            System.out.println(digitsToString(digits) + " = " + number + 
                             " * " + multiplier);
            return true;
        }
        return false;
    }
    public static int[] getDigits(int number) {
        int temp = number;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        return digits;
    }
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    public static String digitsToString(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (i > 0) sb.append(" + ");
            sb.append(digits[i]).append("^").append(i + 1);
        }
        return sb.toString();
    }
}

