public class nextGreatestLetter {
    //给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
    // 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。

    // 输入: letters = ["c", "f", "j"]，target = "a"
    // 输出: "c"
    // 解释：letters 中字典上比 'a' 大的最小字符是 'c'。

    // 输入: letters = ["c","f","j"], target = "c"
    // 输出: "f"
    // 解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。

    // 输入: letters = ["x","x","y","y"], target = "z"
    // 输出: "x"
    // 解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (letters[mid] < target+1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l == letters.length) return letters[0];
        return letters[l-1];
    }
}
