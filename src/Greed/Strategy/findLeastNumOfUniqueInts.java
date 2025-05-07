package Greed.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class findLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        ArrayList<Integer> list = new ArrayList<>(cnt.values());
        Collections.sort(list);
        int ans = list.size();
        for (Integer integer : list) {
            if (k >= integer) {
                k -= integer;
                ans -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        findLeastNumOfUniqueInts findLeastNumOfUniqueInts = new findLeastNumOfUniqueInts();
        System.out.println(findLeastNumOfUniqueInts.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }
}
