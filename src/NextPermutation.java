/**
 * Created by wa941 on 2018/5/17.
 * 下一个全排列问题，要从某一值后面的值里面找一个更大的交换，才能找一个稍微大的。此时后面全是降序，改成升序。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int j;
        for(j = nums.length-2; j >= 0;j--){
            if(nums[j] < nums[j+1]){
                for(int i = nums.length-1; i > j;i--){
                    if(nums[i] > nums[j]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        reverse(nums,j+1,nums.length-1);
                        return;
                    }
                }
            }
        }
        if(j == -1){
            reverse(nums,0,nums.length-1);
        }
    }
    public void reverse(int[] nums,int begin,int end){
        while (begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation a = new NextPermutation();
        int[] nums = {3,2,1};
        a.nextPermutation(nums);
    }
}
