package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    double value;
    double weight;
    double ratio;

    Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = value / weight;
    }
}

public class FractionalKnapsack {
    public double fractionalKnapsack(double capacity, Item[] items) {
        // 在此处填写分数背包算法的核心代码
        Arrays.sort(items,Comparator.comparingDouble(a->-a.ratio));
        double totalValue=0;
        for(Item item:items){
            if(capacity>=item.weight){
                totalValue+=item.value;
                capacity-=item.weight;
            }
            else{
                totalValue+= capacity* item.ratio;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        double capacity = 50;
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        FractionalKnapsack solution = new FractionalKnapsack();
        double maxValue = solution.fractionalKnapsack(capacity, items);
        System.out.println("能装入背包的最大价值为: " + maxValue);
    }
}