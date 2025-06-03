public class Main46 {
    public static void main(String[] args) {
        String[] Romania = {"I", "II", "V", "XLV", "C", "CDXCIX", "MXCIX", "MCMLXXXV", 
                              "MMXXV", "MMMCMXXIX", "MMMM", "MMMMCMXCIX", "MMMMM", "MMMMMMMMMCMXCIX"};
        
        for (String roman : Romania) {
            System.out.println(roman + " ----> " + Convert(roman));
        }
    }
    
    public static int Convert(String roman) {
        if (roman == null || roman.isEmpty()) {
            return 0;
        }
        
        int total = 0;
        int prevValue = 0;
        
        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = Value(currentChar);
            
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            
            prevValue = currentValue;
        }
        
        return total;
    }
    
    private static int Value(char romanChar) {
        return switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}