package LinkedList;

public class findDuplicate {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int tmp = 0;
        while (slow != tmp) {
            slow = nums[slow];
            tmp = nums[tmp];
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new findDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
