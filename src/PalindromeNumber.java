/**
 * Created by wa941 on 2018/5/8.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = x+"";
        int lo = 0;
        int hi = s.length()-1;
        while (hi>lo){
            if(s.charAt(lo)!=s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(isPalindrome(121));
    }
}
