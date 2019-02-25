package Two_Pointers;

import java.util.Stack;

/**
 * Created by wa941 on 2018/5/27.
 */
public class TrappingRainWater {
    /*
    brute algorithm O(n2)
     */
//    public static int trap(int[] height) {
//        int result = 0;
//        for (int i = 0; i < height.length;i++){
//            int left = 0;
//            int right = 0;
//            for(int j = i; j >=0 ; j--){
//                if(height[j] > left){
//                    left = height[j];
//                }
//            }
//            for (int j = i; j < height.length;j++){
//                if(height[j] > right){
//                    right = height[j];
//                }
//            }
//            result += Math.min(left,right) - height[i];
//        }
//        return result;
//    }
    /*
    时间复杂度O（n) 空间复杂度O（n）,逐个节点储存左右最大值。
     */
//    public static int trap(int[] height){
//        if(height.length == 0){
//            return 0;
//        }
//        int result = 0;
//        int[] left = new int[height.length];
//        int[] right = new int[height.length];
//        left[0] = height[0];
//        right[height.length - 1] = height[height.length -1];
//        for(int i = 1; i < height.length;i++){
//            left[i] = Math.max(left[i-1],height[i]);
//        }
//        for (int j = height.length-2;j >=0;j--){
//            right[j] = Math.max(right[j+1],height[j]);
//        }
//        for (int i = 0 ; i < height.length;i++){
//            result += Math.min(left[i],right[i]) - height[i];
//        }
//        return result;
//    }
    /*
    用栈 时间复杂度O(n),空间复杂度O（N),存的时候栈从下到上是有序的。一旦遇到顺序不一样的，出栈并计算数值。
     */
//    public static int trap(int[] height){
//        Stack<Integer> myStack = new Stack<>();
//        int result = 0;
//        for(int i = 0 ; i < height.length; i++){
//            while (!myStack.isEmpty() && height[i] > height[myStack.peek()]){
//                int x = myStack.pop();
//                if(myStack.isEmpty()){
//                    break;
//                }
//                int distance = i -myStack.peek()  -1;
//                int he = Math.min(height[i],height[myStack.peek()]) - height[x];
//                result += distance * he;
//            }
//            myStack.push(i);
//        }
//        return result;
//    }
    /*
    2点法，每次都在两边选择峰值，另一边一定更大，只考虑一侧即可，时间复杂度O（n)
     */
    public static int trap (int[] height){
        int result = 0;
        int left = 0;
        int right = 0;
        int lo = 0;
        int hi = height.length-1;
        while (lo < hi){
            if(height[lo] <= height [hi]){
                if(height[lo] > left){
                    left = height[lo];
                }
                else {
                    result += left - height[lo];
                }
                lo++;
            }
            else {
                if(height[hi] > right){
                    right = height[hi];
                }
                else {
                    result += right - height[hi];
                }
                hi--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trap(height));
    }
}
