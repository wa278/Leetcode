package Two_Pointers;

public class Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int a = nums[i];
            if(a == i+1){
                i++;
            }
            else {
                int b = nums[a-1];
                if ( b == a){
                    return b;
                }
                else {
                    nums[a-1] = a;
                    nums[i] = b;
                }
            }

        }
        return -1;
    }
}
