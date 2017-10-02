package facebook;

import java.util.*;

/**
 * Created by Zehui on 9/17/17.
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(i) + 1, i + 1};
            }
            map.put(nums[i],i);
        }
        return result;
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            if(numbers == null || numbers.length < 2){
                return result;
            }
            int left = 0;
            int right = numbers.length - 1;
            while(left < right){
                int mid = numbers[left] + numbers[right];

                if(mid == target){
                    return new int [] {left + 1, right + 1};
                } else if(mid > target){
                    right--;
                }else{
                    left++;
                }
            }
            return null;
        }
    }
}
