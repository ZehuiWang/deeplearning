package facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Zehui on 9/15/17.
 */
public class mostFrequent {
    public static void main(String[] args){
        mostFrequent app = new mostFrequent();
        int[] test1 = {1,2,1,1,1,1,1,2,3};
        int[] test2 = {2,2,2,2,2,2,2,2,3};
        int[] test3 = {1,2,3,4,5,6,7,1};
        System.out.println(app.mostFrequent(test1));
        System.out.println(app.mostFrequent(test2));
        System.out.println(app.mostFrequent(test3));


        System.out.println(app.mostFrequent2(test1));
        System.out.println(app.mostFrequent2(test2));
        System.out.println(app.mostFrequent2(test3));

    }
    public int mostFrequent(int [] nums){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        for(int item : nums){
            maxHeap.add(item);
        }
        return maxHeap.poll();
    }

    public int mostFrequent2(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        int maxKey = nums[0];
        int maxValue = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> key : map.entrySet()){
            if (key.getValue() > maxValue) {
                maxKey = key.getKey();
                maxValue = key.getValue();
            }
        }

        System.out.println("The winner is number "+maxKey+" its frequency of occurrence is "+maxValue);
        return maxValue;
    }


}
