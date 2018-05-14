import java.util.Comparator;

/**
 * Created by wa941 on 2018/5/14.两点问题 都是 用两个指针一起扫描，达到o(n)的复杂度。都是通过内在的逻辑关系，减少复杂度，通过内在的逻辑关系，就可以找到那些店根本不需要考虑。只有更改短的边才有可能增大面积，更改搞得边一定会缩小面积。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int lo = 0 ;
        int hi = height.length-1;
        int max = area(height,lo,hi);
        while (hi>lo){
            int x = area(height,lo,hi);
            if(x > max){
                max = x;
            }
            if(height[lo] <= height[hi]){
                lo++;
            }
            else {
                hi--;
            }
        }
        return max;
    }
    public int area(int[] height, int lo , int hi){
        int area = (hi-lo) * Math.min(height[lo], height[hi]);
        return area;
    }
}
