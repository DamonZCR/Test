package postgraduate.studyJava.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ʱ�临�Ӷȣ�O(N + C)
 * ���ڴ��������д�СΪ N������Ϊ M ��Ͱ����Ҫ�����У�
 *     N ��ѭ������ÿ��Ԫ��װ���Ӧ��Ͱ��
 *     M ��ѭ������ÿ��Ͱ�е����ݽ�������ƽ��ÿ��Ͱ�� N/M ��Ԫ�أ�
 * һ��ʹ�ý�Ϊ���ٵ������㷨��ʱ�临�Ӷ�Ϊ O ( N l o g N ) O(NlogN) O(NlogN)��ʵ�ʵ�Ͱ�����������������ʽ����ġ�
 * ����Ͱ�����ʱ�临�Ӷ�Ϊ��
 * O(N)+O(M*(N/M*log(N/M)))=O(N*(log(N/M)+1))
 * �� N = M ʱ�����Ӷ�Ϊ O ( N )
 * ����ռ临�Ӷȣ�O(N + M)
 *
 * ��ҪӦ�������ݷֲ����ȵĴ������ݣ��Կռ任ʱ�䡣
 * */
public class BucketSort {
    public static void bucketSort(int[] arr){

        // �������ֵ����Сֵ
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // ����Ͱ������
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // ��ÿ��Ԫ�ط���Ͱ
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // ��ÿ��Ͱ��������
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        // ��Ͱ�е�Ԫ�ظ�ֵ��ԭ����
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }

}
