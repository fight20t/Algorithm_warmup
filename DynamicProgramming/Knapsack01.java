package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack01 {

    private static Knapsack01Result computeKnapsack01(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        boolean[][] selected = new boolean[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (w - weights[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                    selected[i][w]=false;
                } else {
                    if (dp[i - 1][w - weights[i - 1]] + values[i - 1] > dp[i - 1][w]) {
                        dp[i][w] = dp[i - 1][w - weights[i - 1]] + values[i - 1];
                        selected[i][w] = true;
                    } else {
                        dp[i][w] = dp[i - 1][w];
                        selected[i][w] = false;
                    }


                }
            }
        }
        List<Integer> chosenItems = new ArrayList<>();
        int remaincapacity=capacity;
        for (int i = n; i > 0; i--) {
            if (selected[i][remaincapacity]) {
                chosenItems.add(i - 1);
                remaincapacity-=weights[i-1];
            }
        }
        Collections.reverse(chosenItems);
        return new Knapsack01Result(dp[n][capacity], chosenItems);

    }


    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        Knapsack01Result result = computeKnapsack01(weights, values, capacity);

        System.out.println("最大价值: " + result.getBiggestValue());
        System.out.print("装入的物品索引: " + result.getBiggestChosen());

    }
}
