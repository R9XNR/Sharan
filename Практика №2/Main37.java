import java.io.IOException;
public class Main37 {
    public static void main(String args[]) throws IOException {
        int[] Code = new int[4];
        long time = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            Code[i] = (int)(time % 10);
            time /= 10;
        }
        java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
        java.io.BufferedReader br = new java.io.BufferedReader(isr);
        int attempts = 0;
        final int maxAttempts = 20;
        boolean guessed = false;
        System.out.println("Угадайте 4-значный код (цифры 0-9). У вас " + maxAttempts + " попыток.");
        main_loop:
        while (attempts < maxAttempts && !guessed) {
            System.out.print("Попытка " + (attempts + 1) + ": Введите 4 цифры подряд: ");
            String input = br.readLine();
            if (input.length() != 4) {
                System.out.println("Нужно ввести ровно 4 цифры!");
                continue;
            }
            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                char c = input.charAt(i);
                if (c < '0' || c > '9') {
                    System.out.println("Вводите только цифры 0-9!");
                    continue main_loop;
                }
                guess[i] = c - '0';
            }
            int matches = 0;
            for (int i = 0; i < 4; i++) {
                if (guess[i] == Code[i]) {
                    matches++;
                }
            }
            System.out.println("Совпадений: " + matches);
            if (matches == 4) {
                guessed = true;
                System.out.println("Поздравляем! Вы угадали код!");
            } else {
                attempts++;
            }
        }
        if (!guessed) {
            System.out.print("Вы проиграли. Код был: ");
            for (int num : Code) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}