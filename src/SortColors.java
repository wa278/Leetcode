import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by wa941 on 2018/6/1.
 */
/*
快速排序尽量减少无意义的交换
 */
public class SortColors {
//    public void sortColors(int[] nums) {
//        shuffle(nums);
//        sort(nums,0,nums.length-1);
//    }
//    public void sort(int[] nums,int i,int j){
//        if(i < j){
//            int x = partition(nums,i,j);
//            sort(nums,i,x-1);
//            sort(nums,x+1,j);
//        }
//    }
//    public void shuffle(int[] nums){
//        for(int i = 0; i < nums.length;i++){
//            int j = (int)(Math.random()*(i+1));
//            exch(nums,i,j);
//        }
//    }
//    public int partition(int[] nums,int first,int end){
//        int i = first;
//        int j = end +1;
//        while (true){
//            while (nums[++i] <= nums[first]){
//                if(i >=  end){
//                    break;
//                }
//            }
//            while (nums[--j] >= nums[first]){
//                if(j <= first){
//                    break;
//                }
//            }
//            if(j > i){
//                exch(nums,i,j);                // 如果 j>=i 为 条件的话，不会break，会继续运行。如果正好i,j 为边界的话 就越界了。
//            }
//            else {
//                break;
//            }
//        }
//        exch(nums,first,j);
//        return j;
//    }
//    public void exch(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    public static void main(String[] args) {
//        SortColors x = new SortColors();
//        int[] nums = {2,0,1};
//        x.sortColors(nums);
//        for(int e : nums){
//            System.out.print(e);
//        }
//    }
    /*
    三项切分的快速排序算法
    针对有大量重复值的数据 时间复杂度O（n）
    (0,lt-1)存放小于V的数据  （lt,gt）存放等于v的数据       (gt+1,length)存放大于V的数据
    if(num[i] < v)
        交换lt++,i++     把相等序列最左边的交换进里面，把i这个不相等的交换到最左边 通过两边的转换让相等序列向内移动
    if(num[i] > v)       把大于的数移到最右边，继续比较原来位置这个新来的数据
        交换 gt--,i
    if(num[i] = v)       相等继续向前
        i++

     */
    public void sortColors(int[] nums){
        Quick3Way(nums,0,nums.length-1);
    }
    public void Quick3Way(int[]nums, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int v = nums[lo];
        int lt = lo;
        int gt = hi;
        int i = lo;
        while (i <= gt){
            if(nums[i] == v){
                i++;
            }
            else if(nums[i] < v){
                exch(nums,lt++,i++);
            }
            else {
                exch(nums,gt--,i);
            }
        }
        Quick3Way(nums,lo,lt-1);
        Quick3Way(nums,gt+1,hi);
    }
    public void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors x = new SortColors();
        int[] nums = {2,0,2,1,10};
        x.sortColors(nums);
    }
}
