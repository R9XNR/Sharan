public class Main8 {
    public static void main(String args[]) {
        String input = "ABccAAr";
        int Up = 0;
        int Low = 0;
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                Up++;
            } else if (Character.isLowerCase(c)) {
                Low++;
            }
        }
        String result;
        if (Up > Low) {
            result = input.toUpperCase();
        } else if (Low > Up) {
            result = input.toLowerCase();
        } else {
            result = input.toLowerCase();
        }
        System.out.println(result);
    }
}
