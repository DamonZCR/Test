package postgraduate.leetcd.xunLian;

import org.apache.commons.lang3.StringUtils;
import java.util.*;

/**
 * ���������ĸ�����ͨ��"+", "-", "*", "/"�������ĸ������� 24�����з�ʽ��
 */
public class Point24Caculator {

    /**
     * ����24���п��Ե��Ĳ���
     */
    private static String[] operators = {
            "+", "-", "*", "/"
    };

    public static void main(String[] args) throws Exception {

        double[] array = new double[4];
        int index=0;
        Scanner scanner=new Scanner(System.in);
        while (index<4)
        {
            System.out.println(String.format("�������%s��1-10������",index+1));
            String tempNumStr=scanner.nextLine();
            if(!StringUtils.isNumeric(tempNumStr))
            {
                System.out.println("������Ĳ���һ������");
                continue;
            }
            double tmpNum=Double.valueOf(tempNumStr);
            if (tmpNum<0 || tmpNum>10)
            {
                System.out.println("����������ֲ���1-10������");
                continue;
            }

            array[index++]=tmpNum;

        }

        System.out.println(String.format("�������4��1-10������Ϊ%s,%s,%s,%s",array[0],array[1],array[2],array[3]));
        System.out.println("������£�");

        List<double[]> resultAllList = new ArrayList<double[]>();
        List<double[]> list = new ArrayList<double[]>();
        list.add(array);
        list.add(new double[]{array[1], array[2], array[3], array[0]});
        list.add(new double[]{array[2], array[3], array[0], array[1]});
        list.add(new double[]{array[3], array[0], array[1], array[2]});
        for (int i = 0; i < list.size(); i++) {
            getAllArray(resultAllList, Arrays.copyOf(list.get(i), list.get(i).length));
        }

        int sum = 0;
        Iterator<double[]> iterator = resultAllList.iterator();
        while (iterator.hasNext()) {
            double[] tempArray = iterator.next();
            sum += caculate24Point(tempArray);
            sum += caculate24Point2(tempArray);
        }

        System.out.println("�ܹ�����������" + sum);
    }


    /**
     * ��ȡarray�����п������
     *
     * @param list
     * @param array
     */
    public static void getAllArray(List<double[]> list, double[] array) {
        if (!exists(list, array)) {
            list.add(array);
        }

        for (int i = 1; i < 4; i++) {
            double[] arrayCopy = Arrays.copyOf(array, array.length);
            List<double[]> newList = getArrayList(arrayCopy, i);
            Iterator<double[]> iterator = newList.iterator();
            while (iterator.hasNext()) {
                double[] temp = iterator.next();
                if (!exists(list, temp)) {
                    list.add(temp);
                }
            }
        }
    }

    /**
     * ��ȡarray�±�����i��λ���������
     *
     * @param array
     * @param i
     * @return
     */
    public static List<double[]> getArrayList(double[] array, int i) {
        List<double[]> list = new ArrayList<double[]>();

        for (int j = i; j > 0; j--) {
            double temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
            list.add(array);
            array = Arrays.copyOf(array, array.length);
        }

        return list;
    }

    /**
     * array�Ƿ�氡��list��
     *
     * @param list
     * @param array
     * @return
     */
    public static boolean exists(List<double[]> list, double[] array) {
        Iterator<double[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            double[] tmpArray = iterator.next();
            if (tmpArray[0] == array[0] && tmpArray[1] == array[1] && tmpArray[2] == array[2] && tmpArray[3] == array[3]) {
                return true;
            }
        }
        return false;
    }

    /**
     * ����array����24���������ϣ������ҵ�˳��
     *
     * @param
     * @throws Exception
     */
    public static int caculate24Point(double[] array) throws Exception {
        int count = 0;
        if (array.length != 4) {
            throw new Exception("�����ĸ���");
        }


        for (String op : operators) {
            String expressionStr = "";

            double result = getTwoNumCaculate(array[0], array[1], op);
            if (!isValidResult(result))
            {
                continue;
            }
            expressionStr = String.format("(%s %s %s)", array[0], op, array[1]);

            for (String op2 : operators) {
                double result1 = getTwoNumCaculate(result, array[2], op2);
                if (!isValidResult(result1))
                {
                    continue;
                }
                String expressionStr2 = String.format("(%s %s %s)", expressionStr, op2, array[2]);
                for (String op3 : operators) {

                    double result2 = getTwoNumCaculate(result1, array[3], op3);
                    String expressionStr3 = String.format("%s %s %s", expressionStr2, op3, array[3]);

                    if (result2 == 24.0d) {
                        count++;
                        System.out.println(String.format("������%s=%s", expressionStr3, result2));
                    }
                }
            }
        }
        return count;
    }

    /**
     * ����array����24���������� ,�������
     *
     * @param array
     * @return
     * @throws Exception
     */
    public static int caculate24Point2(double[] array) throws Exception {
        int count = 0;
        if (array.length != 4) {
            throw new Exception("�����ĸ���");
        }
        for (String op : operators) {
            double result1 = getTwoNumCaculate(array[0], array[1], op);
            if (!isValidResult(result1))
            {
                continue;
            }
            String expressionStr1 = String.format("(%s %s %s)", array[0], op, array[1]);
            for (String op2 : operators) {
                double result2 = getTwoNumCaculate(array[2], array[3], op2);
                if (!isValidResult(result2))
                {
                    continue;
                }
                String expressionStr2 = String.format("(%s %s %s)", array[2], op2, array[3]);
                for (String op3 : operators) {
                    double result3 = getTwoNumCaculate(result1, result2, op3);
                    String expressionStr3 = String.format("%s %s %s", expressionStr1, op3, expressionStr2);
                    if (result3 == 24.0d) {
                        count++;
                        System.out.println(String.format("������ %s = %s", expressionStr3, result3));
                    }
                }
            }

        }
        return count;
    }


    /**
     * �Ƿ�Ϊ�Ϸ��ļ�����
     * @param result
     * @return
     */
    public  static  boolean isValidResult(double result){
        if (result<1)
        {
            return  false;
        }
        return  result == Math.floor(result);
    }

    private static double getTwoNumCaculate(double num1, double num2, String operator) throws Exception {
        if ("+".equals(operator)) {
            return num1 + num2;
        } else if ("-".equals(operator)) {
            return num1 - num2;
        } else if ("*".equals(operator)) {
            return num1 * num2;
        } else if ("/".equals(operator)) {
            return num1 / num2;
        }
        throw new Exception("����������Ϲ淶");
    }
}