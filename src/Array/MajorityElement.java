package Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                len++;
            } else {
                if (len > 0) {
                    len--;
                } else {
                    len = 1;
                    num = nums[i];
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MajorityElement x = new MajorityElement();
        int[] input = {2, 2, 1, 1, 1, 2, 2};
        System.out.print(x.majorityElement(input));
    }
}
