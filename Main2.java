public class Main2 {
  public static void main(String[] args) {
        String name = "аНнА";
        String formatName = formatName(name);
        System.out.println("Привет, " + formatName + "!");
    }
    public static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        char firstChar = name.charAt(0);
        firstChar = Character.toUpperCase(firstChar);
        String restOfName = name.substring(1);
        restOfName = restOfName.toLowerCase();
        return firstChar + restOfName;
    }
}