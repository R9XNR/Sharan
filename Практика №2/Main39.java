public class Main39 {
    public static void main(String args[]) {
        String text = "Привет, как дела?";
        System.out.println("Исходник: " + text);
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                word.append(c);
            } 
            else {
                if (word.length() > 0) {
                    Word(word, result);
                    word.setLength(0);
                }
                result.append(c);
            }
        }
        if (word.length() > 0) {
            Word(word, result);
        }
        System.out.println("Результат: " + result.toString());
    }
    private static void Word(StringBuilder word, StringBuilder result) {
        if (word.length() == 0) return;
        char firstChar = word.charAt(0);
        word.deleteCharAt(0);
        word.append(firstChar);
        word.append("ауч");
        result.append(word);
    }
}

