package Stack;

import java.util.Stack;

/**
 * Created by wa941 on 2018/5/16.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                myStack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                if(myStack.size() == 0 || myStack.pop() != '('){
                    return false;
                }
            }
            else if(s.charAt(i) == ']'){
                if(myStack.size() == 0 || myStack.pop() != '['){
                    return false;
                }
            }
            else if(s.charAt(i) == '}'){
                if(myStack.size() == 0 || myStack.pop() != '{'){
                    return false;
                }
            }
        }
        if(myStack.size() != 0){
            return false;
        }
        else
            return true;
    }
}
