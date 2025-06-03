public class Main48 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Введите кол-во элементов X: ");
        int count = scanner.nextInt();
        int[] u = new int[count * 3];
        u[0] = 1;
        int size = 1;
        
        for (int i = 0; i < count && i < size; i++) {
            int current = u[i];
            int y = 2 * current + 1;
            int z = 3 * current + 1;
            if (!contains(u, size, y)) {
                u[size++] = y;
            }
            if (!contains(u, size, z)) {
                u[size++] = z;
            }
            sort(u, size);
        }
        System.out.println("Первые " + count + " элементов последовательности u:");
        for (int i = 0; i < count && i < size; i++) {
            System.out.print(u[i] + " ");
        }
    }
    private static boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
    private static void sort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}