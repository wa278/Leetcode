import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
//        HashSet<Integer> mySet = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            if(mySet.contains(nums[i])){
//                mySet.remove(nums[i]);
//            }
//            else {
//                mySet.add(nums[i]);
//            }
//        }
//        return mySet.iterator().next();
        /*
        异或是 异值为真，同值为假     0和一个值异或 还是这个值。
         */
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result^= nums[i];
        }
        return result;
    }
}
