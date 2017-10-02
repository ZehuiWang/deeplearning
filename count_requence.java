package glassdoor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zehui on 9/30/17.
 */
public class count_requence {
    public void count(String str) {
        Map<String, Integer> map = new HashMap<>();
        if (str == null || str.length() == 0) {
            return;
        }

        String reg = "\\s*[^a-zA_Z]+";

        String[] words = str.toLowerCase().split(reg);

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word,1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet ()){
            System.out.println("Count of the :" + entry.getKey() + " : is : " + entry.getValue());
        }
    }
}
