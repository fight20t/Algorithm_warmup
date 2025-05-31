package DynamicProgramming;

public class LCS {

    private static LCSResult computeLCS(String A, String B) {
        int m=A.length();
        int n=B.length();
        int [][] dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0||j==0){
                    dp[i][j]=0;
                } else if (A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;

                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        int index=dp[m][n];
        char[] lcs=new char[index];
        int i=m,j=n;
      while (i>0&&j>0) {
            if(A.charAt(i-1)==B.charAt(j-1)){
                lcs[--index]=A.charAt(i-1);
                i--;
                j--;
            } else if (dp[i-1][j]>dp[i][j-1]) {
                i--;

            }else {
                j--;
            }
        }
        return new LCSResult(new String(lcs),dp[m][n]);
    }

    public static void main(String[] args) {
        String A="ABCD";
        String B="AEBD";
        LCSResult result=computeLCS(A,B);
        System.out.println("LCS长度："+result.getLCSLength());
        System.out.println("LCS字符串"+result.getLCSString());
    }

}
