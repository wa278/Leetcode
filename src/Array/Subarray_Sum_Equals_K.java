package Array;


import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.containsKey(sum) ? hashMap.get(sum) + 1 : 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Subarray_Sum_Equals_K x = new Subarray_Sum_Equals_K();
        int[] input = {1, 1, 1};
        System.out.println(x.subarraySum(input, 2));
    }
}
