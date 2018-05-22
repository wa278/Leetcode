/**
 * Created by wa941 on 2018/5/22.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int num = nums[0];
        int index = 0;
        for(int i = 1; i< nums.length;i++){
            if(nums[i] != nums[index] ){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

}
