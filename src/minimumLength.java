import java.util.Scanner;

public class minimumLength {
    // 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
    // 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
    // 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
    // 前缀和后缀在字符串中任意位置都不能有交集。
    // 前缀和后缀包含的所有字符都要相同。
    // 同时删除前缀和后缀。
    // 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
    // 输入：s = "ca"
    // 输出：2
    // 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            while (l < r && s.charAt(l) == s.charAt(l + 1)) {
                l += 1;
            }
            while (l < r && s.charAt(r) == s.charAt(r - 1)) {
                r -= 1;
            }
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        minimumLength solution = new minimumLength();
        String s = new Scanner(System.in).next();
        System.out.println(solution.minimumLength(s));
    }
}
