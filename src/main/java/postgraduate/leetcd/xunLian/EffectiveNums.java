package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**ID 36 有效的数独
 * 详细题目见题目图片。
 * 请你判断一个9x9的数独是否有效。只要根据以下规则,验证已经填入的数字是否有
 * 效即可。
 * 1.数字1-9 在每一行只能出现-次。
 * 2.数字1-9在每一-列只能出现- -次。
 * 3.数字1-9在每一个以粗实线分隔的3x3 宫内积能出现- -次。 (请参考示例图)
 * 数独部分空格内已填入了数字,空白格用’.’表示。
 * 注意:
 * ●一个有效的数独(部分已被填充)不-定是可解的。
 * ●只要根据以上规则,验证已经填入的数字是否有效即可。
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 */
public class EffectiveNums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[9][9];
        for (int j = 0;j < 9;j++){
            String s = br.readLine();
            char[] lincs = s.toCharArray();
            for(int i = 0; i < 9; i++){
                char c = lincs[i];
                if (c == '.'){
                    board[j][i] = c;
                    continue;
                }
                if (Character.isDigit(c)){
                    board[j][i] = c;
                    continue;
                }
            }
        }
        solve(board);
    }

    private static boolean solve(char[][] board) {
        List list = new ArrayList<>(9);
        for (int j = 0;j < 9;j++){
            list = Arrays.asList(board[j]);
            boolean res = isEffive(list);
            if (!res)
                return res;
        }
        for (int z = 0;z < 9;z++){
            for (int i = 0;i < 9;i++){
                list.add(board[i][z]);
            }
            boolean res = isEffive(list);
            if (!res)
                return res;
        }
        for (int x = 0;x < 9;x++) {
            int nx = x % 3;
            int nx2 = x / 3;
            for (int z = 3 * nx2; z < 3 * nx2 + 3; z++) {
                for (int i = 0; i < 3; i++) {
                    list.add(board[z][i + 3 * nx]);
                }
                boolean res = isEffive(list);
                if (!res)
                    return res;
            }
        }
        return true;
    }
    private static boolean isEffive(List list){
        HashSet set = new HashSet(list);
        Iterator it = set.iterator();
        int res = 0;
        while(it.hasNext()){
            char c = (char)it.next();
            if (c != '.')
                res = Collections.frequency(list, c);
            if (res > 1)
                return false;
        }
        return true;
    }

}
