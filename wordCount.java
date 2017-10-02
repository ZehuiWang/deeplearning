package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zehui on 9/17/17.
 */
public class wordCount {
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for(String str :  strings){
            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else{
                map.put(str,1);
            }
        }
        return map;
    }
}
