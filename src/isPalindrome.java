public class isPalindrome {
    // 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    // 字母和数字都属于字母数字字符。
    // 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
    // 示例 1：
    // 输入: s = "A man, a plan, a canal: Panama"
    // 输出：true
    // 解释："amanaplanacanalpanama" 是回文串。
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l += 1;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r -= 1;
            }
            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l = l + 1;
                r = r - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome solution = new isPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
