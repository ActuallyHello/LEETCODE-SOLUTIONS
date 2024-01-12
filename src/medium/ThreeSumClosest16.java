package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        threeSumClosest(new int[]{-1,2,1,-4}, 3);
    }

    public static boolean hasValuesInTuples(List<Integer> values, List<List<Integer>> tuples) {
        boolean isSameValuesInTuples = false;
        for (var tuple : tuples) {
            if (tuple.equals(values)) {
                isSameValuesInTuples = true;
                break;
            }
        }
        return isSameValuesInTuples;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    var tuple = List.of(nums[i], nums[j], nums[k]);
                    if (!hasValuesInTuples(tuple, tuples)) {
                        tuples.add(tuple);
                    }
                }
            }
        }
        List<Integer> results = new ArrayList<>();
        for (var tuple: tuples) {
            int sum = 0;
            for (var e : tuple) {
                sum += e;
            }
            results.add(sum);
        }
        int min = 1000;
        int minIndex = -1;
        for (var i = 0; i < results.size(); i++) {
            var value = Math.abs(results.get(i) - target);
            if (min > value) {
                min = value;
                minIndex = i;
            }
        }
        return results.get(minIndex);
    }
}
