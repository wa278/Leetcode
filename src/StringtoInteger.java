import java.math.BigInteger;

/**
 * Created by wa941 on 2018/5/7.
 */
public class StringtoInteger {
    public static int myAtoi(String str) {
        String re = "";
        boolean white = true;
        boolean minus = true;
        boolean shuliang = false;
        for(int i = 0 ; i< str.length();i++){
            if(str.charAt(i) == ' '&& white){
                continue;
            }
            else if(str.charAt(i)>='0' && str.charAt(i) <= '9'){
                re = re + str.charAt(i);
                white = false;
                shuliang = true;
            }
            else if((str.charAt(i) == '-'|| str.charAt(i) == '+') && minus&&!shuliang){
                minus = false;
                re = re+str.charAt(i);
                white = false;
            }
            else
                break;;
        }
        if(!shuliang){
            return 0;
        }
        else {
            BigInteger result = new BigInteger(re);
            if(result.compareTo(new BigInteger(Integer.MAX_VALUE+"")) >0){
                return Integer.MAX_VALUE;
            }
            else if(result.compareTo(new BigInteger(Integer.MIN_VALUE+"")) < 0){
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.parseInt(re);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }
}
