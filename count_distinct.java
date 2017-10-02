package facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zehui on 9/17/17.
 */
public class count_distinct {
    public int countDistinct(String str){
        Set<String> set = new HashSet<>();
        if(str == null || str.length() == 0){
            return 0;
        }
        String reg = "\\s*[^a-zA-Z]+";

        String[] res = str.split(reg);
        String[] words = str.trim().toLowerCase().split(reg);
        for(String word : words){
            set.add(word);
        }
        return set.size();
    }

    public int countDis(String str){
        Set<String> set = new HashSet<> ();
        if(str == null || str.length() == 0){
            return 0;
        }
        String reg = "\\s*[^a-zA-Z]+";
        String[] words = str.trim().toLowerCase().split(reg);

        for(String word: words){
            set.add(word);
        }
        return set.size();
    }
    public static void main(String [] args){
        String reg = "\\s*[^a-zA-Z]+";
        String str = "a b";

        String[] res = str.split(reg);
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("A");
        for(String out:res){
            System.out.println(out);
            System.out.println(set.size());
        }
    }
}
