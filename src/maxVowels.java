public class maxVowels {
    public int maxVowels(String s, int k) {
        // 小于 k-1 直接入、更新、出
        int ans = 0, l = 0, cur = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                cur += 1;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.max(ans, cur);
            if (arr[i-k+1] == 'a' ||arr[i-k+1] == 'e' ||arr[i-k+1] == 'i' ||arr[i-k+1] == 'o' ||arr[i-k+1] == 'u') {
                cur -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maxVowels maxVowels = new maxVowels();
        System.out.println(maxVowels.maxVowels("abciiidef", 3));
    }
}
