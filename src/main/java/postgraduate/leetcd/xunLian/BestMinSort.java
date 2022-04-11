package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*��һ�����ֶ��б仯��Ϸ�У���ʼʱ��һ�õ�һ����n������Ԫ�صĶ��У�ÿ��Ԫ��Ϊ...9�е�һ�������ÿ�ο��ԴӶ����ײ�����β��ȡ��һ�����֣�����
�����¶��е�β�����ظ��˲���ֱ���������ֶ���ȡ�����¶��л����һ��nλ������(���ܰ����ȵ�0)��������֪������ÿ����Ϸ�����ڹ���������������ܻ�
�õ���С�������Ƕ���?
��������:
��һ��һ�������������ָ���n;
�ڶ���n�����֣���������0��...��9������ʾ�����д�ǰ�����n��Ԫ�ء�
�������:
һ��nλ����(���ܰ����ȵ�0)����ʾ��С�Ľ������
����������
* 6
* 0 2 3 1 2 1
* ���Ϊ12123
* ���³������������ǲ���ȷ��
* �������4����Ϊ2 1 9 2
���Ϊ2219��ӦΪ2129.���������������������ȵ�ʱ��ֻ����һζ��ȡ�ұߡ���ȷӦΪ����ȡ����߻��ұ߲�������һ����������һ��Ҳ����ȡ����С�ġ�
 */
public class BestMinSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] lens = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList(lens.length);
        for (int i = 0;i<lens.length;i++) {
            list.add(Integer.parseInt(lens[i]));
        }
        int[] a = test(list);
        for (int i:a)
            System.out.print(i);
    }

    public static int[] test(ArrayList<Integer> list){
        int[] a = new int[list.size()];
        int q = 0;
        int h = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(q) < (list.get(list.size() - h - 1))){
                a[i] = list.get(q);
                q += 1;
            }
            else {
                a[i] = list.get(list.size() - h - 1);
                h += 1;
            }
        }
        return a;
    }
}
