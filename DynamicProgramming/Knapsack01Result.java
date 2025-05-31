package DynamicProgramming;

import java.util.List;

public class Knapsack01Result {
    private int BiggestValue;
    private List<Integer> BiggestChosen;

    public Knapsack01Result(int biggestValue, List<Integer> biggestChosen) {
        BiggestValue = biggestValue;
        BiggestChosen = biggestChosen;
    }

    public int getBiggestValue() {
        return BiggestValue;
    }

    public void setBiggestValue(int biggestValue) {
        BiggestValue = biggestValue;
    }

    public List<Integer> getBiggestChosen() {
        return BiggestChosen;
    }

    public void setBiggestChosen(List<Integer> biggestChosen) {
        BiggestChosen = biggestChosen;
    }
}
