public class Main45 {
    public static void main(String[] args) {
        int[] testnum = {1, 2, 5, 45, 100, 499, 1099, 1985, 2025, 3929, 4000, 4999, 5000, 9999};
        
        for (int num : testnum) {
            System.out.println(num + " ----> " + Convert(num));
        }
    }
    
    public static String Convert(int num) {
        if (num < 1 || num >= 10000) {
            return "Вне диапазона";
        }
        
        String[] thousand = {"", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        String romania = thousand[num / 1000] + 
                      hundred[(num % 1000) / 100] + 
                      ten[(num % 100) / 10] + 
                      one[num % 10];
        
        return romania;
    }
}