package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/** ȫ����
 * ������һ��û���ظ�Ԫ�ص���������S����S�������Ӽ�
 * ע��:��������Ӽ��е�Ԫ�ر��밴�������и����Ľ⼯�в��ܳ����ظ���Ԫ��
 * ����:
 * ���S=[1,2,3],�����Ľ⼯ӦΪ:[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
 * ���
 *  ���³���ʹ��DFS�㷨ʵ�֡�ÿһ�����һ��Ԫ�أ�����������ʹ�øýڵ㣬����������ʹ�øýڵ㣬
 *  ʹ��������������ȫ��Ҷ�ӽ�㣬��ô���ܻ�ø�������Ӽ���˼·ͼƬ��file�ļ����С�
 * */
public class AllSetSon {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] begin = bf.readLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (String i:begin) {
            list.add(Integer.parseInt(i));
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int level = 0;
        // list Ϊ��ʼ���ϣ�result�����Ӽ����ϣ�tempΪ��ǰ�Ӽ���levelΪ��ǰ��Ρ�
        getArr(list, result, temp, level);
        System.out.println(result);
    }

    private static void getArr(List<Integer> list, List<List<Integer>> result, List<Integer> temp, int level)
    {
        if(level == list.size()){
            // ��ֹ�����������ÿһ��temp���ϼ��뵽result�С�
            result.add(temp);
        }else {
            getArr(list, result, new ArrayList(temp), level+1);
            temp.add(list.get(level));// ������Ԫ�ص���������
            getArr(list, result, new ArrayList(temp), level+1);
        }
    }
}