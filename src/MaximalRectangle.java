import java.util.Stack;
/*
用 最大矩形做这道题
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
           for (int j = 0; j < matrix[0].length ; j++){
               if(matrix[i][j] == '1'){
                   height[j] += 1;
               }
               else {
                   height[j] = 0;
               }
           }
            max = Math.max(max,largestRectangleArea(height));
        }
        return max;
    }
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

}
