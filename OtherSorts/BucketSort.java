package OtherSorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public int[] bucketSort(int[] arr) {
        // 在此填写桶排序核心代码
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int size = (max - min) / arr.length + 1;
        int cnt = (max - min) / size + 1;
        int[][] bucket = new int[cnt][size];
        int[] bucketSize = new int[cnt];

//        for (int i = 0; i < arr.length; i++) {
//            int digitofElement = (arr[i] - min) / size;
//            bucket[digitofElement][bucketSize[digitofElement]] = arr[i];
//            bucketSize[digitofElement]++;
//        }

        for(int a:arr){
            int digitofElement=(a-min)/size;
            bucket[digitofElement][bucketSize[digitofElement]++] = a;
        }
        for (int i = 0; i < cnt; i++) {
            Arrays.sort(bucket[i], 0, bucketSize[i]);
        }
        int index = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < bucketSize[i]; j++) {
                arr[index++] = bucket[i][j];

            }
        }


        return arr;
    }

    public static void main(String[] args) {
        BucketSort solution = new BucketSort();
        int[] nums = {4, 1, 7, 9, 3, 6};
        int[] sortedNums = solution.bucketSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}