package facebook;

/**
 * Created by Zehui on 9/17/17.
 */
public class count_subString {
    public int countSub(String str,String sub){
        if(str == null || sub == null){
            return -1;
        }

        int m = str.length();
        int n = sub.length();

        if(n > m){
            return -1;
        }
        int count = 0;

        for(int i = 0;i < m - n + 1;i++){
            String temp = str.substring(i,i + n);
            if(temp.equals(sub)){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args){
        count_subString app = new count_subString();
        app.countSub("abc","aa");
        app.countSub("abc","aa");
        app.countSub("abc","aa");
        app.countSub("abc","aa");
        app.countSub("abc","aa");

    }
}
