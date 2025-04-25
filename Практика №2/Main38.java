public class Main38 {
    public static void main(String args[]) {
        int playersCount = 4;
        int startPlayer = 3;
        int[] players = new int[playersCount];
        for (int i = 0; i < playersCount; i++) {
            players[i] = startPlayer + i;
        }
        int[] eliminated = new int[playersCount];
        int eliminatedCount = 0;
        int currentPos = 0;
        while (playersCount > 1) {
            currentPos = (currentPos + 2) % playersCount;
            eliminated[eliminatedCount++] = players[currentPos];
            for (int i = currentPos; i < playersCount - 1; i++) {
                players[i] = players[i + 1];
            }
            playersCount--;
        }
        eliminated[eliminatedCount] = players[0];
        System.out.print("[");
        for (int i = 0; i < eliminated.length; i++) {
            System.out.print(eliminated[i]);
            if (i < eliminated.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}


