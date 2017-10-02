package facebook;

import java.util.ArrayList;

/**
 * Created by Zehui on 9/15/17.
 */
public class maxElement {
    public int max(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return Integer.MIN_VALUE;
        }
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int getMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
