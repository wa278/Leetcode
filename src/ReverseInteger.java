/**
 * Created by wa941 on 2018/5/7.
 */
// 判断是否溢出可以用更大的类型装，弄清楚补码 -128的补码是多余了剩下给他的。-2147483648*-1 = -2147483648；
public class ReverseInteger {
    public static int reverse(int x) {
        long b = x;
        boolean zx = false;
        if(b >= 0){
            zx = true;
        }
        else {
            zx = false;
            b = b * -1;
        }
        long result = 0;
        while (b != 0) {
            int a = (int)(b % 10);
            b = b / 10;
            result = (result * 10) + a;
        }
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        else
            return(int) (zx?result:result*-1);
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
