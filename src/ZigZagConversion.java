/**
 * Created by wa941 on 2018/5/8.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        String result ="";
        int num = s.length();
        for(int i = 0; i< numRows;i++){
            int k = i;
            int a = 2 * numRows-2 - 2*i;
            int b = 2 *i;
            boolean count = false;
            while (k<num){
                result+=s.charAt(k);
                if(a!=0 && b!=0){
                    if(!count){
                        k = k + a;
                        count = true;
                    }
                    else {
                        k = k + b;
                        count = false;
                    }
                }
                else if(a == 0 && b!= 0){
                    k = k + b;
                }
                else if(a != 0 && b == 0){
                    k = k + a;
                }
                else {
                    result = s;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(convert("AB",1));
    }
}
