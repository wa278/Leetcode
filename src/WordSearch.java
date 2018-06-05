/**
 * Created by wa941 on 2018/6/5.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[][] ismarked = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board,i,j,word,1,ismarked)){
                        return true;
                    }
                    ismarked = new boolean[board.length][board[0].length];
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board,int i,int j,String word,int k,boolean[][] ismarked){
        if(k == word.length()){
            return true;
        }
        ismarked[i][j] = true;
        if(i -1 >=0 && ismarked[i-1][j] == false&&board[i-1][j] == word.charAt(k)){
            if(search(board,i-1,j,word,k+1,ismarked)){
                return true;
            }
            ismarked[i-1][j] = false;
        }
        if(i +1 < board.length && ismarked[i+1][j] == false&&board[i+1][j] == word.charAt(k)){
            if(search(board,i+1,j,word,k+1,ismarked)){
                return true;
            }
            ismarked[i+1][j] = false;
        }
        if(j -1 >=0 && ismarked[i][j-1] == false&&board[i][j-1] == word.charAt(k)){
            if(search(board,i,j-1,word,k+1,ismarked)){
                return true;
            }
            ismarked[i][j-1] = false;
        }
        if(j +1 <board[0].length && ismarked[i][j+1] == false&&board[i][j+1] == word.charAt(k)){
            if(search(board,i,j+1,word,k+1,ismarked)){
                return true;
            }
            ismarked[i][j+1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.print(exist(board,word));
    }
}
