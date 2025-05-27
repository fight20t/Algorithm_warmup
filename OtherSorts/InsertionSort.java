package OtherSorts;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        int temp;
        int j;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                temp=nums[i];
                for( j=i-1;j>=0&&temp<nums[j];j--){
                    nums[j+1]=nums[j];
                }
                nums[j+1]=temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        InsertionSort solution = new InsertionSort();
        int[] nums = {5, 2, 9, 1, 5, 6};
        int[] sortedNums = solution.insertionSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}