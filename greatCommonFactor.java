package glassdoor;

/**
 * Created by Zehui on 9/30/17.
 */
public class greatCommonFactor {

    public int greatFactor(int num1,int num2){
        int k = 0;
        if(num1 > num2){
            k = num2;
        }else{
            k = num1;
        }

        for(int i = k;i >= 0;i--){
            if(num1%i == 0 && num2% i == 0){
                return i;
            }
        }
        return -1;

    }

    public int greatFactors(int num1,int num2){
        int k = 0;
        if(num1 > num2){
            k = num2;
        }else{
            k = num1;
        }

        for(int i = k;i >= 0;i--){
            if(num1 % k == 0 && num2 % k == 0){
                return i;
            }
        }
        return -1;
    }
}
