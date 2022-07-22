package postgraduate.studyJava.testCollection;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/** 测试以某一个对象的时间属性进行排序
 * list.sort()将会按照创建时间的先后顺序进行逆序排序，即创建时间最晚的，也就是距离现在时刻最近的排到前面；
 */
public class SortDateZiDuan {
    private int id;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public SortDateZiDuan(int id, Date time) {
        this.id = id;
        this.time = time;
    }

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        SortDateZiDuan t1 = new SortDateZiDuan(1, date);
        System.out.println(t1.time);

        // 为了区分两个时间属性的前后顺序，线程休眠5秒；
        Thread.sleep(5000);

        Date date1 = new Date();
        SortDateZiDuan t2 = new SortDateZiDuan(2, date1);
        System.out.println(t1.time);

        List<SortDateZiDuan> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        // 对时间属性进行排序；
        list.sort((t3, t4) -> t4.getTime().compareTo(t3.getTime()));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(JSON.toJSONString(list.get(i)));
        }
    }
}
