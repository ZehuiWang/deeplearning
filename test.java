package glassdoor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zehui on 10/1/17.
 */
public class test
{
    public static void main(String[] args){

    }
    public int getTRY(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        int maxvalue = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> key:map.entrySet()){
            if(key.getValue() > maxvalue){
                maxvalue = key.getValue();
            }
        }
        return maxvalue;
    }
}
