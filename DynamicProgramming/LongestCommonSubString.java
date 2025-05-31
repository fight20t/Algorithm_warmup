package DynamicProgramming;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String A="aavabsdet";
        String B="joanaavabjej4goi";
        int len1=A.length();
        int len2=B.length();
        int start=0;
        int manLenth=0;
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                if(dp[i][j]>manLenth){
                    manLenth=dp[i][j];
                    start=i-manLenth;
                }
            }
        }
        System.out.println(A.substring(start,start+manLenth));
    }

}
