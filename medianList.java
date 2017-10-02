package facebook;

import java.util.Arrays;

/**
 * Created by Zehui on 9/15/17.
 */
public class medianList {
    public double findMedian(int[] nums){
        Arrays.sort(nums);
        double median;
        if(nums.length % 2 == 0){
            median = ((double)nums[nums.length/2] + (double)nums[nums.length/2 -1])/2;
        }else{
            median = ((double)nums[nums.length/2]);
        }
        return median;
    }

    public double findMedia2n(int[] nums){
        Arrays.sort(nums);
        double median;
        int len = nums.length;
        if(nums.length % 2 == 0){
            median =(double) (nums[len/2] + nums[len/2 - 1])/2;
        }else{
            median = (double)nums[len/2];
        }
        return median;
    }
}
