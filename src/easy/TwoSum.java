package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(TwoSum.twoSum(new int[] {2,7,11,15}, 9))
        );
        System.out.println(
                Arrays.toString(TwoSum.twoSum(new int[] {3,2,4}, 6))
        );
        System.out.println(
                Arrays.toString(TwoSum.twoSum(new int[] {3,2,4}, 10))
        );
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (remainderMap.containsKey(nums[i])) {
                return new int[] {remainderMap.get(nums[i]), i};
            } else {
                remainderMap.put(target-nums[i], i);
            }
        }
        return new int[] {};
    }
}
