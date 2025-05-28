package OtherSorts;


public class HeapSort {
    public int[] heapSort(int[] nums) {
        // 在这里填写堆排序的核心代码
        int n=nums.length;
        int lastNode=n/2-1;
        for(int i=lastNode;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i=n-1;i>=0;i--){
            swap(nums,0,i);
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
            swap(nums,i,largest);
            heapify(nums,n,largest);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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