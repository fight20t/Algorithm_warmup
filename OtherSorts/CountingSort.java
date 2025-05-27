package OtherSorts;

public class CountingSort {
    public int[] countingSort(int[] nums) {
        // 在此处填写计数排序核心代码
        int max=nums[0];
        int min=nums[0];
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int[] countArr=new int[max-min+1];
        for(int num:nums){
            countArr[num-min]++;
        }
        for(int i=1;i<max-min+1;i++){
            countArr[i]=countArr[i]+countArr[i-1];
        }
        int[] sortedArr=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int index=countArr[nums[i]-min]-1;
            sortedArr[index]=nums[i];
            countArr[nums[i]-min]--;
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        CountingSort solution = new CountingSort();
        int[] nums = {4, 2, 2, 8, 3, 3, 1};
        int[] sortedNums = solution.countingSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}