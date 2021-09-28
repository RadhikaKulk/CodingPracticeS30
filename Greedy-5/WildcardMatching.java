class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals("*")) {
            return true;
        }
        int slen, plen;
        slen = s.length();
        plen = p.length();

        boolean [][] dp = new boolean[plen + 1][slen + 1];

        dp[0][0] = true;

        for(int i = 1; i < plen + 1; i++) {
            for(int j = 0; j < slen + 1; j++) {
                if(p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j];
                    if(j > 0) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                } else if(j > 0 && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[plen][slen];
    }
}