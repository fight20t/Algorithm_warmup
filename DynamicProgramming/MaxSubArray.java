package DynamicProgramming;

public class MaxSubArray {



    private static int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        //空间复杂度为O(n)
//        int[] dp=new int[n];
//        dp[0]=nums[0];
//        for (int i = 1; i <n ; i++) {
//            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
//        }
//        int res=Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            res=Math.max(res,dp[i]);
//        }
        int dp_0=nums[0];
        int dp_1=0,res=dp_0;
        for (int i = 1; i <n ; i++) {
            dp_1=Math.max(dp_0+nums[i],nums[i]);
            dp_0=dp_1;
            res=Math.max(dp_0,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={3,4,-1,2,-6,1,4};
        System.out.println("最大子数组的和为"+maxSubArray(nums));
    }

}
