package Binary_Search;

/*
二分查找代表的值是较小的数组分割成两部分后，左边部分的个数。选择较小数组的原因是：如果使用较大数组，在二分查找时候，当索引很大的时候，很有可能让另一个较小数组出现out of index
的情况。trick 将两个数组分成两部分，左边的小于右边的。
 */
public class Median_of_Two_Sorted_Arrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n + 1) / 2;

        int lo = 0;
        int hi = m;

        int partitionX;
        int partitionY;

        while (lo <= m) {
            partitionX = (lo + hi) / 2;
            partitionY = mid - partitionX;
            int maxOfLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxOfLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minOfRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            int minofRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxOfLeftX <= minofRightY && maxOfLeftY <= minOfRightX) {
                if ((m + n) % 2 == 0) {
                    return ((Math.max(maxOfLeftX, maxOfLeftY) + Math.min(minOfRightX, minofRightY))) / 2.0;
                } else {
                    return Math.max(maxOfLeftX, maxOfLeftY) + 0.0;
                }
            } else if (maxOfLeftX > minofRightY) {
                hi = partitionX - 1;
            } else
                lo = partitionX + 1;
        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Median_of_Two_Sorted_Arrays x = new Median_of_Two_Sorted_Arrays();
        System.out.println(x.findMedianSortedArrays(nums1, nums2));
    }
}
