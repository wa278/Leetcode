/**
 Hash法 复杂度O（n)
 */
/*
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> myHash = new Hashtable<>();
        int[] result = new int[2];
        for(int i = 0 ;i < nums.length;i++){
            myHash.put(nums[i],i);
        }
        for(int i = 0; i<nums.length;i++){
            if(myHash.containsKey(target-nums[i])){
                if(myHash.get(target-nums[i]) != i){
                    result[0] = i;
                    result[1] = myHash.get(target-nums[i]);// 如果相同的key 的话，第一个key 被替换掉了。
                    return result;
                }
            }
        }
        return null;
    }
}
*/
/*
双链表法 复杂度 O(nlogn)
 */
public class TwoSum{
    public int[] twoSum(int[] nums,int target){
        int[] index = new int[nums.length];       // 保存原来的索引
        for(int i = 0 ;i < nums.length;i++){
            index[i] = i;
        }
        shuffle(nums,index);
        sort(nums,0,nums.length-1,index);
        int low = 0;
        int high = nums.length-1;
        while (high>low){
            if(nums[high] + nums[low] > target){
                high--;
            }
            else if(nums[high] + nums[low] < target){
                low++;
            }
            else {
                int[] result = new int[2];
                result[0] = index[low];
                result[1] = index[high];
                return result;
            }
        }
        return null;
    }
    public void exch(int[] a,int i ,int j){
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }
    public boolean less(int i,int j){
        return i<j;
    }
    public int partition(int[] a, int lo,int hi,int[] b){
        int v = a[lo];
        int i = lo;
        int j = hi+1;
        while (true){
            while (less(a[++i],v)){
                if(i == hi)
                    break;
            }
            while (less(v,a[--j])){
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            exch(a,i,j);
            exch(b,i,j);
        }
        exch(a,lo,j);
        exch(b,lo,j);
        return j;
    }
    public void sort(int[] a,int lo,int hi,int[] b){
        if(hi <= lo){
            return;
        }
        int j = partition(a,lo,hi,b);
        sort(a,lo,j-1,b);
        sort(a,j+1,hi,b);
    }
    public void shuffle(int[] a,int[] b){                          //不写shuffle 数据有序的话就会栈溢出
        for(int i = 0 ;i < a.length;i++){
            int x = (int)(Math.random()*(i+1));
            exch(a,i,x);
            exch(b,i,x);
        }
    }
}
