package facebook;

import java.util.*;

/**
 * Created by Zehui on 9/17/17.
 */
public class count_frequence {
    //-Count the frequency of words from the list and store the results in a hash map.
    public void count(String str) {
        Map<String, Integer> map = new HashMap<>();
        if(str == null || str.length() == 0){
            return;
        }
        String[] split = str.trim().split(" ");

        for (String word : split) {
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
    public static void main(String [] args){
        count_frequence app = new count_frequence();
        //app.count("I am a Boy I am a");
        app.count(null);
        app.count("");
    }

}
