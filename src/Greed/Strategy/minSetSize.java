package Greed.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class minSetSize {
    public int minSetSize(int[] arr) {
        //贪心 选择出现次数最多的
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        ArrayList<Integer> list = new ArrayList<>(cnt.values());
        int pre = arr.length;
        int cur = pre;
        Collections.sort(list);
        // 最少删除次数使得数组长度变为原数组的一半
        for (int i = list.size() - 1; i >= 0; i--) {
            if (cur<=pre/2) {
                return ans;
            }
            ans += 1;
            cur -= list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        minSetSize minSetSize = new minSetSize();
        System.out.println(minSetSize.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }
}
