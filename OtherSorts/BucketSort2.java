package OtherSorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.sort;

public class BucketSort2 {
    public int[] bucketSort(int[] nums) {
        // 在此填写桶排序核心代码
        int max=nums[0];
        int min=nums[0];
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int size=(max-min)/nums.length+1;
        int cnt = (max - min) / size + 1;
        List<Integer>[] buckets=new List[cnt];
//        for(int i=0;i<cnt;i++){
//            buckets[i]=new ArrayList<>();
//        }
        IntStream.range(0, cnt).forEach(i -> {
            buckets[i]=new ArrayList<>();
        });
        for(int num:nums){
            int idx=(num-min)/size;
            buckets[idx].add(num);
        }
        for(List<Integer> bucket:buckets){
            sort(null);
        }
        int index=0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                nums[index++] = buckets[i].get(j);

            }
        }

        return nums;
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