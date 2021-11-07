package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 一瓶水2元，四个瓶盖可以换一瓶水，两个空瓶可以换一瓶水，实现输入钱数输出可以喝到的总瓶数。
 */
public class DrinkWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        solve(money);
    }
    private static void solve(int money){
        int drink = money / 2;
        if (drink == 0)
            return;
        int empty = drink;
        int bottle = drink;

        while ((empty / 2 != 0) || (bottle / 4 != 0)){
            int a = empty / 2;
            int b = bottle / 4;
            if (a != 0){
                drink += a;
                empty = empty - a;
            }
            if (b != 0){
                drink += b;
                bottle = bottle - 3 * b;
            }
        }
        System.out.println(drink);
    }
}
