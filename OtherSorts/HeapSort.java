package OtherSorts;

public class HeapSort {
    public int[] heapSort(int[] nums) {
        // 在这里填写堆排序的核心代码
        int n=nums.length;
        for(int i=n/1-1;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(nums,i,0);
        }
        return nums;
    }

    private void heapify(int[] nums, int n, int i) {
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;
        if(left<n&&nums[left]>nums[largest]){
                largest=left;
        }
        if(right<n&&nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            int swap=nums[i];
            nums[i]=nums[largest];
            nums[largest]=swap;
            heapify(nums,n,largest);
        }
    }

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        int[] sortedNums = solution.heapSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}