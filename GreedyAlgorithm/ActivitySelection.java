package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    public List<Integer> selectActivities(int[][] activities) {
        // 在此处填写活动选择的核心代码
        // activities数组中每个元素是一个长度为2的数组，分别表示活动的开始时间和结束时间
        Arrays.sort(activities,Comparator.comparingInt(a->a[1]));
        int n=activities.length;
        List<Integer> selected=new ArrayList<>();
        selected.add(0);
        int prevEnd=activities[0][1];
        for (int i = 1; i <n ; i++) {
            if(activities[i][0]>=prevEnd){
                prevEnd=activities[i][1];
                selected.add(i);
            }
        }
       return selected;
    }

    public static void main(String[] args) {
        int[][] activities = {
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 6},
                {5, 7}
        };
        ActivitySelection solution = new ActivitySelection();
        List<Integer> selectedActivities = solution.selectActivities(activities);
        System.out.println("选择的活动索引为: ");
        for (int index : selectedActivities) {
            System.out.print(index + " ");
        }
    }
}