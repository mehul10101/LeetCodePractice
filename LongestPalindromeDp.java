
class LongestPalindromeDp {
    public static void main(String[] args) {
        String s = "ababab";
        String lp = longestPalindrome(s);
        System.out.println(lp);
    }

    private static String longestPalindrome(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        return findLongestPalindrome(s, dp, l);
    }

    /**
     *
     * algorithm -
     *  1. Construct a 2d matrix arr[strlen][strlen] and assign all of them to 1 if i == j otherwise 0
     *  2. Maintain a max(max length), max_x(x where we got max) and max_y
     *  3. Now for i=0 -> l-1 and j=0 -> i-1 for i,j see if the string is palindrome.
     *      For checking palindrome we have to check two conditions:
     *      a. if length of string is 2 check charAt(i) == charAt(j), if true mark arr[i][j] = 1
     *      b. if length is more than 2 then check the above condition as well we need to see if arr[i-1][j+1] == 1
     *         (this will verify whether i and j substring is palindrome or not) if we get palindrome we have to mark
     *         arr[i][j] = 1
     *   4. return the substring with max palidrome.
     *
     */

    private static String findLongestPalindrome(String s, int[][] dp, int l) {
        int max_x = 0, max_y = 0, max = 1, i, j;
        for(i=0; i<l; i++){
            for(j=0; j<=i; j++){
                if(i == j){
                    dp[i][j] = 1;
                }else {
                    final boolean b = s.charAt(i) == s.charAt(j);
                    if(i - j == 1){
                        if(b) {
                            dp[i][j] = 1;
                            if(i-j+1 > max){
                                max = 2;
                                max_x = i;
                                max_y = j;
                            }
                        }else {
                            dp[i][j] = 0;
                        }
                    }
                    else if(b && dp[i-1][j+1] ==1){
                        dp[i][j] = 1;
                        if(i-j+1 > max){
                            max = i-j+1;
                            max_x = i;
                            max_y = j;
                        }
                    }
                }
            }
        }
        return s.substring(max_y, max_x+1);
    }
}
