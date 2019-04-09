package Stack;

import java.util.Stack;

/*
 Created by wa941 on 2018/6/5.*/
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area;
                if (!stack.isEmpty()) {
                    area = heights[top] * (i - stack.peek() - 1);
                } else {
                    area = heights[top] * i;
                }
                max = Math.max(max, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (!stack.isEmpty()) {
                int area = heights[top] * (i - stack.peek() - 1);
                max = Math.max(max, area);
            } else {
                int area = heights[top] * i;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram x = new LargestRectangleinHistogram();
        int[] input = {2, 1, 5, 6, 2, 3};
        System.out.print(x.largestRectangleArea(input));
    }
}
