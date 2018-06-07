public class UniqueBinarySearchTrees {
    // 递归方法 超时   个数 = 左子树的所有个数 + 右子树的所有个数。     左子树全部小于根节点，右子树全部元素大于根节点。二叉查找树按中序遍历是有序的。
//    public int numTrees(int n) {
//        int result  = 0;
//        if(n == 0){
//            return 1;
//        }
//        for(int i = 1; i <= n ;i++){
//            result += numTrees(i-1) * numTrees(n-i);      // 重复计算很多次
//        }
//        return result;
//    }
    //卡特兰数的的递推公式 通过dp保存子树的个数，避免了重复计算。
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n;i++ ){
            for(int j = i;j >=1; j--){
                dp[i] += dp[i-j] * dp[j-1];
            }
        }
        return dp[n];
    }
}
