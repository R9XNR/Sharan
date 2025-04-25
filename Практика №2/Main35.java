public class Main35 {
    public static void main(String args[]) {
        String input = "56 65 74 100 99 68 86 180 90";
        String[] weight = input.split(" ");
        for (int i = 0; i < weight.length - 1; i++) {
            for (int j = 0; j < weight.length - i - 1; j++) {
                int sum1 = Sum(weight[j]);
                int sum2 = Sum(weight[j + 1]);
                if (sum1 > sum2 || (sum1 == sum2 && weight[j].compareTo(weight[j + 1]) > 0)) {
                    String temp = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = temp;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (String weight2 : weight) {
            result.append(weight2).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    public static int Sum(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}