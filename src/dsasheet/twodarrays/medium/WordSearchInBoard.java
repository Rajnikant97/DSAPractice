package dsasheet.twodarrays.medium;

public class WordSearchInBoard {
    public static void main(String[] args) {
        char[][]board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public  static boolean search(char[][] board, String word, int r, int c, int ind) {
        if(ind >= word.length()) {
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != word.charAt(ind)) {
            return false;
        }

        char currChar = board[r][c];
        board[r][c] = ' ';

        boolean isFound=
                search(board, word,r + 1, c, ind + 1)
            || search(board, word, r, c + 1, ind + 1)
            || search(board, word,r - 1, c,ind+1)
            || search(board, word, r, c - 1,ind+1);

        board[r][c] = currChar;

        return isFound;
    }
}
