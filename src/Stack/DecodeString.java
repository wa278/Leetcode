package Stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> cStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                int j = i;
                while (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) {
                    j++;
                }
                numStack.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;

            } else if (s.charAt(i) == ']') {
                StringBuffer sb = new StringBuffer();
                while (!cStack.isEmpty()) {
                    if (cStack.peek() == '[') {
                        sb.reverse();
                        cStack.pop();
                        break;
                    } else {
                        sb.append(cStack.pop());
                    }
                }
                int num = numStack.pop();
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < sb.length(); k++) {
                        cStack.push(sb.charAt(k));
                    }
                }
            } else {
                cStack.add(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!cStack.isEmpty()) {
            sb.append(cStack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString x = new DecodeString();
        System.out.print(x.decodeString("100[leetcode]"));
    }
}
