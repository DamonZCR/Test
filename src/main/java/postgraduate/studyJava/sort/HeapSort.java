package postgraduate.studyJava.sort;

import java.util.Arrays;

/**
 * 堆排序demo
 * adjustHeap(arr, i, arr.length);函数的作用就是：
 *  将以序号i为父节点的子树，然后找到它的子树中最大的一个数字，放到i位置，然后将原序号i
 *  位置上的旧值，放到这个最大数字的原位置；
 */
public class HeapSort {
    public static void main(String []args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        /**1.构建大顶堆.对应笔记内容的步骤一全过程；
         * 构建后的堆，满足父节点总大于两个孩子节点，如何保证的呢？
         * 首先，对于第一个非叶子节点，找到它的子树中最大的数，使用adjustHeap(arr, i, arr.length);函数，
         * 就这样一个一个非叶子节点的找，直到轮到根节点，执行了adjustHeap();函数，此时，就是一个大顶堆，因为
         * 任意一个非叶子节点都大于它的孩子节点；
         */
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            //从第一个非叶子结点（也就是最大序号的非叶子结点）从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length - 1;j > 0;j--){
            swap(arr,0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，调整后的结果是第 i 个位置为堆中的最大元素）
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i

        // 一个节点序号 i，它的左孩子节点序号为 2 * i + 1,右孩子节点为 2 * i + 2;
        for(int k = i * 2 + 1;k < length;k = k * 2 + 1){//从i结点的左子结点开始，也就是2i+1处开始
            //判断左孩子大还是右孩子大。如果左子结点小于右子结点，k指向右子结点
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
    /**
     * 交换元素
     */
    public static void swap(int []arr,int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
