package DynamicProgramming;

public class MaxSubArray2 {
    private static MaxSubArray2Result computeMaxSubArray2(int[] nums) {
        int n=nums.length;
        if(n==0) return new MaxSubArray2Result(-1,-1,0);
        int[] dp=new int[n];
        int[] start=new int[n];//以i结尾的最大字数组的起始索引
        dp[0]=nums[0];
        start[0]=0;
        int maxSum=dp[0];
        int maxEnd=0;//记录全局最大和的结束位置
        for (int i = 1; i <n ; i++) {
            if(nums[i]>nums[i]+dp[i-1]){
                dp[i]=nums[i];
                start[i]=i;
            }
            else {
                dp[i]=nums[i]+dp[i-1];
                start[i]=start[i-1];
            }
            if(dp[i]>maxSum){
                maxEnd=i;
                maxSum=dp[i];
            }
        }




        return new MaxSubArray2Result(start[maxEnd],maxEnd,maxSum);
    }

    public static void main(String[] args) {
        int[] nums={3,4,-1,2,-6,1,4};
        MaxSubArray2Result result=computeMaxSubArray2(nums);
        System.out.println("最大子数组的和是"+result.getSum());
        System.out.println("最大子数组是从"+result.getStart()+"到"+result.getEnd());
    }

}
