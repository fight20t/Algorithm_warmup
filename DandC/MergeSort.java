package DandC;

public class MergeSort {
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (l == h) {
            return new int[]{nums[l]};
//            new int[]
//            这部分是 Java 中创建数组的标准语法，表示 "创建一个新的整数数组"。
//            { nums[l] }
//            这是数组的初始化列表，用大括号 {} 包裹。在这里，列表中只有一个元素 nums[l]，即原数组 nums 中索引为 l 的元素。
        }
//递归分解步骤：
//
//初始调用：l=0, h=4, mid=2
//左半部分：mergeSort(nums, 0, 2)
//右半部分：mergeSort(nums, 3, 4)
//左半部分递归：l=0, h=2, mid=1
//左半部分：mergeSort(nums, 0, 1)
//右半部分：mergeSort(nums, 2, 2) ➔ 触发终止条件（l==h）
//继续分解左半部分：l=0, h=1, mid=0
//左半部分：mergeSort(nums, 0, 0) ➔ 触发终止条件（l==h）
//右半部分：mergeSort(nums, 1, 1) ➔ 触发终止条件（l==h）
//关键逻辑：每次递归 l 和 h 如何变化？
//
//计算中间点：mid = l + (h - l) / 2
//例如 l=0, h=4 ➔ mid=2
//递归分解左半部分：mergeSort(nums, l, mid)
//h 变为 mid，范围缩小 ➔ 最终 l == h
//递归分解右半部分：mergeSort(nums, mid+1, h)
//l 变为 mid+1，范围缩小 ➔ 最终 l == h
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid);
        int[] rightArr = mergeSort(nums, mid + 1, h);
        int[] newArr = new int[leftArr.length + rightArr.length];
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newArr[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];

        }
        while (i < leftArr.length) {
            newArr[m++] = leftArr[i++];

        }
        while (j < rightArr.length) {
            newArr[m++] = leftArr[j++];

        }
        return newArr;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.println(x);
        }
    }
}
