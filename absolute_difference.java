package glassdoor;

import java.util.Arrays;

/**
 * Created by Zehui on 10/1/17.
 */
public class absolute_difference {
    public int findMinDiff(int[] nums,int n){
        int diff = Integer.MAX_VALUE;

        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if(Math.abs(nums[i] - nums[j]) < diff){
                    diff = Math.abs(nums[i] - nums[j]);
                }
            }
        }
        return diff;
        //Simple: O(n2)
    }
    public int findMidDiff2(int[] nums,int n){
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i = 0;i < n - 1;i++){
            if(nums[i + 1] - nums[i] < diff ){
                diff = nums[i + 1] - nums[i];
            }
        }
        return diff;
    }
}
