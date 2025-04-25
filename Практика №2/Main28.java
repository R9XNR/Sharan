public class Main28 {
    public static void main(String args[]) {
        String input = "Hello, World!";
        int shift = 3; //сюда любое кол во сдвига
        String direction = "left"; //сюда направление сдвига

        String result = caesarCipher(input, shift, direction);
        
        System.out.println("Результат: " + result);
    }
    public static String caesarCipher(String input, int shift, String direction) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int originalPos = c - base;
                int newPos;
                
                if (direction.equalsIgnoreCase("right")) {
                    newPos = (originalPos + shift) % 26;
                } else if (direction.equalsIgnoreCase("left")) {
                    newPos = (originalPos - shift) % 26;
                    if (newPos < 0) newPos += 26;
                } else {
                    throw new IllegalArgumentException("Направление должно быть 'left' или 'right'");
                }
                
                result.append((char) (base + newPos));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}