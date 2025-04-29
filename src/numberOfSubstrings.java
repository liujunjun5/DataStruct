public class numberOfSubstrings {
    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[3];
        int l = 0, ans = 0;
        for (int r = 0; r < chars.length; r++) {
            cnt[chars[r] - 'a'] += 1;
            while (cnt[0] >= 1 && cnt[1] >= 1 && cnt[2] >= 1) {
                cnt[chars[l] - 'a'] -= 1;
                l++;
            }
            ans += l;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numberOfSubstrings().numberOfSubstrings("abcabc"));
    }
}
