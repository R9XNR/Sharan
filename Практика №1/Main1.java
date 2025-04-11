public class Main1 {
    public static void main(String[] args) {
        String abc = "abc";
        String bc = "bc";
        boolean result = endsWith(abc, bc);
        System.out.println(result);
    }
    public static boolean endsWith(String abc, String bc) {
        if (bc.length() > abc.length()) {
            return false;
        }
        for (int i = 0; i < bc.length(); i++) {
            if (abc.charAt(abc.length() - bc.length() + i) != bc.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}