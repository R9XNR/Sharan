public class Main31 {
    public static void main(String args[]) {
        int[] distance = {50, 55, 57, 58, 60};
        int Petrol = 175;
        int a = 3;
        int result = Sum(Petrol, a, distance);
        System.out.println(result);
    }
    public static int Sum(int Petrol, int a, int[] distance) {
        int n = distance.length;
        if (a > n) return -1;
        int bestSum = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = distance[i] + distance[j] + distance[l];
                    if (sum <= Petrol && sum > bestSum) {
                        bestSum = sum;
                    }
                }
            }
        }
        return bestSum;
    }
}
