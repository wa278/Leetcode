/**
 * Created by wa941 on 2018/5/22.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int a = 0;
        for(int i = 0 ;i < nums.length-a;i++){
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[nums.length-1-a];
                nums[nums.length-1-a] = temp;
                a++;
                i--;
            }
        }
        return nums.length-a;
    }
}
