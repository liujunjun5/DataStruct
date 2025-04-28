public class mySqrt {
    public int mySqrt(int x) {
        // 上下界
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        mySqrt solution = new mySqrt();
        System.out.println(solution.mySqrt(8));
    }
}
