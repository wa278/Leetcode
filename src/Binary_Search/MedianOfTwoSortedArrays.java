package Binary_Search;
//二分法，四个数字，判断边界 0， len的情况。
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int sum = nums1.length + nums2.length;
        int half = sum / 2;
        int lo = 0;
        int hi = nums1.length;
        int x;
        int y;
        while (lo <= hi) {
            x = lo + (hi - lo) / 2;
            y = half - x;
            int maxOfLeftX = x == 0 ? Integer.MIN_VALUE : nums1[x - 1];
            int maxOfLeftY = y == 0 ? Integer.MIN_VALUE : nums2[y - 1];
            int minOfRightX = x == nums1.length ? Integer.MAX_VALUE : nums1[x];
            int minOfRightY = y == nums2.length ? Integer.MAX_VALUE : nums2[y];
            if (maxOfLeftX <= minOfRightY && maxOfLeftY <= minOfRightX) {
                if ((sum) % 2 == 0) {
                    return ((Math.max(maxOfLeftX, maxOfLeftY) + Math.min(minOfRightX, minOfRightY))) / 2.0;
                } else {
                    return Math.min(minOfRightX, minOfRightY) + 0.0;
                }
            } else if (maxOfLeftX > minOfRightY) {
                hi = x - 1;
            } else
                lo = x + 1;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        MedianOfTwoSortedArrays x = new MedianOfTwoSortedArrays();
        System.out.print(x.findMedianSortedArrays(nums1, nums2));
    }
}
