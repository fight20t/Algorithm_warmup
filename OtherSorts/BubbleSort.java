package OtherSorts;

public class BubbleSort {
    public int[] bubbleSort(int[] nums) {

        // 在此处填写冒泡排序核心代码
         int temp;
        for(int  i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        BubbleSort solution = new BubbleSort();
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        int[] sortedNums = solution.bubbleSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}