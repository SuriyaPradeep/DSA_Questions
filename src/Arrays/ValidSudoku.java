package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(String[][] board) {
        Set seen=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                String number=board[i][j];
                if(!number.equals(".")){
                    if(!seen.add(number+"in row"+i)||!seen.add(number+"in column"+j)||!seen.add(number+"in block"+i/3+" "+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board1={{"5","3",".",".","7",".",".",".","."}
                        ,{"6",".",".","1","9","5",".",".","."}
                        ,{".","9","8",".",".",".",".","6","."}
                        ,{"8",".",".",".","6",".",".",".","3"}
                        ,{"4",".",".","8",".","3",".",".","1"}
                        ,{"7",".",".",".","2",".",".",".","6"}
                        ,{".","6",".",".",".",".","2","8","."}
                        ,{".",".",".","4","1","9",".",".","5"}
                        ,{".",".",".",".","8",".",".","7","9"}};
        String[][] board2={{"8","3",".",".","7",".",".",".","."}
                        ,{"6",".",".","1","9","5",".",".","."}
                        ,{".","9","8",".",".",".",".","6","."}
                        ,{"8",".",".",".","6",".",".",".","3"}
                        ,{"4",".",".","8",".","3",".",".","1"}
                        ,{"7",".",".",".","2",".",".",".","6"}
                        ,{".","6",".",".",".",".","2","8","."}
                        ,{".",".",".","4","1","9",".",".","5"}
                        ,{".",".",".",".","8",".",".","7","9"}};
        System.out.println(isValidSudoku(board1));//true
        System.out.println(isValidSudoku(board2));//false

    }
}
