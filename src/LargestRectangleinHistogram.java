import java.util.Stack;

/**
 * Created by wa941 on 2018/6/5.
 */
/*
按照每个值为矩形峰值进行计算。如果下一值更小，这就是上一值矩形的右侧边界。
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> mystack = new Stack<>();
        int index = 0;
        int max = 0;
        while (index < heights.length){
            if(mystack.isEmpty() || heights[mystack.peek()] < heights[index]){

            }
            else {
                while (!mystack.isEmpty() && heights[mystack.peek()] > heights[index]){
                    int x = mystack.pop();
                    int l = mystack.isEmpty()? index:index-mystack.peek()-1; // 必须要用peek 这样才能计算出长度。
                    max = Math.max(max,heights[x]*l);
                }

            }
            mystack.push(index++);
        }
        while (!mystack.isEmpty()){
            int x = mystack.pop();
            int l = mystack.isEmpty()? heights.length:heights.length-mystack.peek()-1;
            max = Math.max(max,heights[x] * l);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram x = new LargestRectangleinHistogram();
        int[] input = {4,2,0,3,2,5};
        System.out.print(x.largestRectangleArea(input));
    }
}
