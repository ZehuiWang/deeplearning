package facebook;

/**
 * Created by Zehui on 9/15/17.
 */
public class greatFactor {
    public static void main(String[] args){
        greatFactor app = new greatFactor();

        System.out.println(app.greatFactor(27,18));
        System.out.println(app.greatFactor(1,1));
    }
    public int greatFactor(int num1,int num2){

        int k = 0;
        if(num1 > num2){
            k = num2;
        }else{
            k = num1;
        }
        for(int i = k;i > 0;i--){
            if(num1 % i == 0 && num2 % i == 0){
                return i;
            }
        }
        return -1;
    }
}
