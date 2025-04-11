public class Main7 {
    public static void main(String args[]) {
        String word = "abc abc ab abc ab acs acs";
        String[] words = word.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            boolean isduplicate = false;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    isduplicate = true;
                    break;
                }
            }
            if (!isduplicate) {
                result.append(words[i]).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}
