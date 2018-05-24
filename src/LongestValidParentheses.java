import java.util.Stack;

/**
 * Created by wa941 on 2018/5/17.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> myStack = new Stack<>();
        int max = 0;
        myStack.add(-1);
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '('){
                myStack.push(i);
            }
            else {
                int c = myStack.pop();
                if(myStack.isEmpty()){
                    myStack.push(i);
                }
                else {
                    max = Math.max(i-myStack.peek(),max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int c = longestValidParentheses(")()())");
        int b = 11;
    }
}
