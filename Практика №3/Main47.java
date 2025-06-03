import java.io.IOException;
public class Main47 {
    public static void main(String[] args) {
        System.out.print("Введите кол-во чисел для генерации: ");
        int totalNumbers = ReadUser();
        if (totalNumbers <= 0) {
            System.out.println("Число должно быть положительным");
            return;
        }
        int n = (int) Math.ceil(Math.sqrt(totalNumbers));
        int[][] array = generate(n, totalNumbers);
        System.out.println("\nИсходный массив:");
        printArray(array);
        int[] snailSorted = snail(array);
        System.out.println("\nОтсортированный змейкой:");
        printArray(snailSorted);
    }
    private static int ReadUser() {
        byte[] buffer = new byte[10];
        try {
            int length = System.in.read(buffer);
            String input = new String(buffer, 0, length).trim();
            return Integer.parseInt(input);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }
    
    private static int[][] generate(int n, int totalNumbers) {
        int[][] array = new int[n][n];
        long seed = System.currentTimeMillis();
        
        for (int i = 0, count = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count < totalNumbers) {
                    seed = (seed * 9301 + 49297) % 233280;
                    array[i][j] = (int)(seed % 100);
                    count++;
                } else {
                    array[i][j] = 0;
                }
            }
            Sort(array[i]);
        }
        return array;
    }
    private static void Sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    private static int[] snail(int[][] array) {
        if (array.length == 0) return new int[0];
        int n = array.length;
        int[] result = new int[n * n];
        int index = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) result[index++] = array[top][i];
            top++;
            for (int i = top; i <= bottom; i++) result[index++] = array[i][right];
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result[index++] = array[bottom][i];
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result[index++] = array[i][left];
                left++;
            }
        }
        return result;
    }
    
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            printArray(row);
        }
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}