import java.util.Arrays;

public class maxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0, right = position[position.length - 1] - position[0];
        while (right >= left) {
            int mid = (left + right) / 2;
            if (check(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] position, int m, int mid) {
        int s = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] >= s + mid) {
                s = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
    // [269826447,974181916,225871443,189215924,664652743,592895362,754562271,335067223,996014894,510353008,48640772,228945137]
    public static void main(String[] args) {
        maxDistance solution = new maxDistance();
        System.out.println(solution.maxDistance(new int[]{269826447,974181916,225871443,189215924,664652743,592895362,754562271,335067223,996014894,510353008,48640772,228945137}, 3));
    }
}
