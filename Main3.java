public class Main3 {
    public static void main(String[] args) {
        String input = "Привет, как дела?";
        String result = removeVowels(input);
        System.out.println("Строка без гласных: " + result);
    }
    public static String removeVowels(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!isVowel(currentChar)) {
                result += currentChar;
            }
        }
        return result;
    }
    public static boolean isVowel(char c) {
        return "AEIOUАЕЁИОУЫЭЮЯaeiouаеёиоуыэюя".indexOf(c) != -1;
    }
}
