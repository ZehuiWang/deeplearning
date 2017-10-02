package glassdoor;

import java.util.HashMap;

/**
 * Created by Zehui on 9/30/17.
 */
public class firstUniqChar {
    public int firstUniChar(String s){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i = 0;i < s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return i;}
        }
        return -1;
    }
}
