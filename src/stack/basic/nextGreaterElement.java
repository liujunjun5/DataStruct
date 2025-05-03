package stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 思路： 先建立一个映射 nums1-nums2 求得nums的下一个比较大的元素 根据映射更新nums1
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int x = nums2[i];
            while (!queue.isEmpty() && x > queue.peek()) {
//                nums2[]
                map.put(queue.pop(), x);
            }
            queue.push(x);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
