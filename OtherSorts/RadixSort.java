package OtherSorts;

import java.util.Arrays;

public class RadixSort {
    public int[] radixSort(int[] arr) {
        // 在此处填写基数排序核心代码
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength=Integer.toString(max).length();

        int [][] bucket=new int[10][arr.length];
        int [] bucketElementCounts=new int[10];

        for(int i=0,n=1;i<maxLength;i++,n*=10){
            for(int j=0;j<arr.length;j++){
                int digitofElement=(arr[j]/n)%10;
                bucket[digitofElement][bucketElementCounts[digitofElement]]=arr[j];
                bucketElementCounts[digitofElement]++;

            }
            int index=0;
            for(int k=0;k<10;k++){
                if(bucketElementCounts[k]!=0){
                    for(int l=0;l<bucketElementCounts[k];l++){
                        arr[index++]=bucket[k][l];
                    }
                    bucketElementCounts[k]=0;
                }
            }
        }




        return arr;
    }

    public static void main(String[] args) {
        RadixSort solution = new RadixSort();
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] sortedNums = solution.radixSort(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}