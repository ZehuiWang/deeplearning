package glassdoor;

/**
 * Created by Zehui on 9/30/17.
 */
public class strStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();

        for(int i = 0; i < m - n + 1;i++){
            int index;
            for(index = 0;index < n;index++){
                if(haystack.charAt(i + index) != needle.charAt(index)){
                    break;
                }
            }
            if(index == needle.length()){
                return i;
            }
        }
        return -1;
    }
}
