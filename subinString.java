package facebook;

/**
 * Created by Zehui on 9/17/17.
 */
public class subinString {
    public int strStr(String str, String sub) {
        if(str == null || sub == null){
            return -1;
        }
        int m = str.length();
        int n = sub.length();

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(str.charAt(i + j) != sub.charAt(j)){
                    break;
                }
                if(j == n){
                    return i;
                }
            }
        }
        return -1;
    }
}
