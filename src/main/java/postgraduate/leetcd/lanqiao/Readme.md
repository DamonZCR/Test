Java11A 一个数存在约数的个数
FileContain2020 文件中包含多少个2020
Java11D 蛇形填数
Java11F 及格率与优秀率
Java11G 单词中字母出现频率最高
Java11H 数字三角形
XBallPhone X星球的摔手机测试


参加第十二届蓝桥杯第二场，感悟：
    1、int所能表示的最大值为2 147 483 647（刚好大于20亿,即 2^31 -1），即Integer.MAX_VALUE;最小值是 -2147483648，即Integer.MIN_VALUE;
    2、需要熟悉如何表示一个非常大的整数，考虑使用long val = 2147483650L,long可以表示的数范围是：
        -9223372036854774808~9223372036854774807，（9的后面有18位数），即（-2的63次方到2的63次方-1）。
        定义long 的时候如果数大于int 所能表示的范围一定要加 L 或者 l；
    3、掌握BigInterger。
    4、Java不存在无符号整型（unsigned）;
    5、如果是计算难度问题，如数据范围、Java短时间运行不出来或文件操作等，使用Python ！
    
    BigInteger : 表示超大整数。整数取值范围原则上是没有上限的，取决于计算机的内存；注意：BigInteger表示是一个对象；
    BigInteger 多种构造方法，其中有 BigInteger("num",进制) 和 BigInteger("num")，前者将字符串num转为对应进制的数字，后者将 num 转为十进制的整数；
    