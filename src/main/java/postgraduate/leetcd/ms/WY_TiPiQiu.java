package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**20220417-网易游戏-第一题
 * 2222年，中国足球队再次参加亚洲区预选赛冲击参加世界杯的资格。中国队所在的小组包含六支队伍,小组的前两名出线晋级世界杯。
 * 2222年的亚洲预选赛积分规则如下:
 * 1.一场比赛进球多者获胜，胜者积3分，负者积0分;进球数相同为平局,双方各得1分;
 * 2.小组排名规则:
 * a)积分多者排前;
 * b)如果积分相同，则净胜球(进球数-失球数）多者排前;
 * c)如果净胜球也相同，则进球数多者排前;
 * d)如果进球数也相同，则队伍名称字典序小的排前;
 * 目前最后一轮的3场比赛刚刚结束，中国球迷想知道根据各队当前积分情况(未更新最后一轮比赛结果)，
 * 以及最后一轮3场比赛的结果，更新得到最终的积分排行榜，你能帮助他们吗?
 *
 * 输入描述:
 * 输入的第一行是一个正整数T（0<T<= 10），表示有T组测试数据。
 * 每组测试数据包含9行，前面6行描述中国队所在小组队伍在最后一轮比赛前的积分情况（未排序），
 * 每行的格式为"name points goals_ for goals against"，分别表示队伍名称，队伍积分（0<=points <=30），
 * 进球数(0<= goals_for <= 50)，丢球数(0<= goals _against<=50)。其中每个队伍名称name由长度不超过20
 * 的字符（只包含大小写字母）组成，保证六支队伍的名称不同。
 * 最后3行是最后一轮三场比赛的结果，每行的格式为"name0 name1 goals_for_name0 goals_for_name1"，
 * 分别表示对赛的双方（名称一定在前面出现过），以及双方的进球数（0<= goals_for_name0，goals_for_name1 <= 5)。
 * 输出描述:
 * 每个测试数据输出七行，前六行表示加上最后一轮比赛结果后的积分榜，每行的格式为"name points goals_for goals_against",
 * 分别表示队伍名称，队伍积分，进球数，丢球数。请按排名规则进行排名后输出。最后一行输出"END"。
 * 示例1：输入：
 2
 China 18 16 7
 oman 12 9 10
 Japan 24 12 3
 Iran 20 11 6
 Thailand 7 9 17
 vietam 0 6 20
 Iran Japan 0 3
 China oman 2 0
 Thailand vietam 1 1
 Indonesia 4 13 12
 Cyprus 4 14 17
 singapore 7 18 20
 cambodia 18 14 8
 sikkim 17 13 14
 china 25 12 13
 Indonesia china 2 1
 Cyprus singapore 3 0
 输出
 Japan 27 15 3
 China 21 18 7
 Iran 20 11 9
 Oman 12 9 12
 Thailand 8 10 18
 Vietam 1 7 21
 END
 china 25 13 15
 Cambodia 19 17 11
 sikkim 18 16 17
 Indonesia 7 15 13
 Cyprus 7 17 17
 Singapore 7 18 23
 END
 */
class OneTeam {
    String name;
    int jifen;
    int jin;
    int lost;
}

public class WY_TiPiQiu {
    public static void main(String[] args) throws IOException {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // list中的一个元素，就又是一个list, 内部list存放每组的各个队的分值情况；
        ArrayList<ArrayList<OneTeam>> list = new ArrayList<>(T);
        // map中的一个元素就是一个HashMap，这个HashMap存放了对应索引list的，每个队的索引下标
        ArrayList<HashMap<String, Integer>> map = new ArrayList<>(T);
        // 这个list中每一个元素list,存放了每组数据中的后三个场次比赛结果；
        ArrayList<ArrayList<String>> list2 = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            list.add(new ArrayList<OneTeam>());
            map.add(new HashMap<>(6));
            // 保存当前组的前六行输入，即每队的数据；
            for (int j = 0; j < 6; j++) {
                String[] s = br.readLine().split(" ");
                OneTeam one = new OneTeam();
                one.name = s[0];
                map.get(i).put(s[0], j);//方便检索到这个名字的队；
                one.jifen = Integer.parseInt(s[1]);
                one.jin = Integer.parseInt(s[2]);
                one.lost = Integer.parseInt(s[3]);
                list.get(i).add(one);
            }
            for (int j = 0; j < 3; j++) {
                ArrayList<String> objects = new ArrayList<>();
                String[] s = br.readLine().split(" ");
                objects.add(s[0]);
                objects.add(s[1]);
                objects.add(s[2]);
                objects.add(s[3]);
                list2.add(objects);
            }
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                String one1 = list2.get(3*i+j).get(0);// 1队名
                String one2 = list2.get(3*i+j).get(1);// 2队名
                int fen1 = Integer.parseInt(list2.get(3*i+j).get(2));// 1队分
                int fen2 = Integer.parseInt(list2.get(3*i+j).get(3));// 2队分

                Integer index1 = map.get(i).get(one1);
                Integer index2 = map.get(i).get(one2);
                OneTeam oneTeam1 = list.get(i).get(index1);
                OneTeam oneTeam2 = list.get(i).get(index2);
                // 进球数
                oneTeam1.jin = oneTeam1.jin + fen1;
                oneTeam2.jin = oneTeam2.jin + fen2;
                // 丢球数=对方的进球数+ 自己原有的丢球数
                oneTeam1.lost = oneTeam1.lost + fen2;
                oneTeam2.lost = oneTeam2.lost + fen1;
                // 积分
                if (fen1 > fen2) {
                    oneTeam1.jifen = oneTeam1.jifen + 3;
                } else if (fen1 < fen2) {
                    oneTeam2.jifen = oneTeam2.jifen + 3;
                } else {
                    oneTeam1.jifen = oneTeam1.jifen + 1;
                    oneTeam2.jifen = oneTeam2.jifen + 1;
                }
            }
            Collections.sort(list.get(i), new Comparator<OneTeam>() {

                @Override
                public int compare(OneTeam o1, OneTeam o2) {
                    OneTeam one = (OneTeam) o1;
                    OneTeam two = (OneTeam) o2;
                    //int res = 0;
                    if ((one.jifen != two.jifen)) {
                        return -(one.jifen - two.jifen);
                    } else if (one.jin - one.lost != two.jin - two.lost) {
                        return -((one.jin - one.lost) - (two.jin - two.lost));
                    } else if (one.jin != two.jin) {
                        return -(one.jin - two.jin);
                    } else {
                        return -one.name.compareTo(two.name);
                    }
                }
            });
        }
        for (int k = 0; k < list.size(); k++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(list.get(k).get(j).name + " ");
                System.out.print(list.get(k).get(j).jifen + " ");
                System.out.print(list.get(k).get(j).jin + " ");
                System.out.println(list.get(k).get(j).lost);
            }
            System.out.println("END");
        }
    }
}
