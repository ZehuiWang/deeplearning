package facebook;

import java.util.HashMap;

/**
 * Created by Zehui on 9/15/17.
 */
public class firstUniq {
    public int firstUniq(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],0);
            }
            map.put(nums[i],map.get(nums[i]) + 1);
        }
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
