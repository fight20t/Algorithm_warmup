package DivideandConquer;

public class QuickSort {
    public static void quickSort(int[] nums) {
        // 核心代码，调用递归的快速排序函数
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(int[] nums, int l, int r) {
        // 核心代码，递归进行分区和排序
        if (l < r) {
            int pos = partition(nums, l, r);

            quickSortHelper(nums, l, pos - 1);
            quickSortHelper(nums, pos + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        // 核心代码，选择基准元素并进行分区操作
        int base = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= base) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= base) {
                l++;
            }
            nums[l] = nums[r];

        }
        nums[l] = base;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}