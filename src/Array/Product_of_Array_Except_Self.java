package Array;

public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            result[i] = result[i] * right;
        }
        return result;
    }

    public static void main(String[] args) {
        Product_of_Array_Except_Self x = new Product_of_Array_Except_Self();
        int[] input = {1, 2, 3, 4};
        int[] output = x.productExceptSelf(input);
        for (int e : output) {
            System.out.println(e);
        }
    }
}
