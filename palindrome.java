class Solution {
    public int lcs(String s, String r, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == r.charAt(j)) {
            dp[i][j] = 1 + lcs(s, r, i - 1, j - 1, dp);
            return dp[i][j];
        }

        dp[i][j] = Math.max(lcs(s, r, i - 1, j, dp), lcs(s, r, i, j - 1, dp));
        return dp[i][j];
    }

    public int kPalindrome(String str, int n, int k) {
        String r = new StringBuilder(str).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int x = lcs(str, r, n - 1, n - 1, dp);

        int rem = n - x;
        return rem <= k ? 1 : 0;
    }
}
