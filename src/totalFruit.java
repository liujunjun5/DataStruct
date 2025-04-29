import java.util.HashMap;

public class totalFruit {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int ans = 0, l = 0;
        for (int r = 0; r < fruits.length; r++) {
            bucket.merge(fruits[r], 1, Integer::sum);
            while (bucket.size() > 2) {
                bucket.merge(fruits[l], -1, Integer::sum);
                if (bucket.get(fruits[l]) == 0) bucket.remove(fruits[l]);
                l += 1;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new totalFruit().totalFruit(new int[]{0, 1, 2, 2}));
    }
}
