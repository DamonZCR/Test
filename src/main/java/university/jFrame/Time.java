package university.jFrame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Time {

	public Time() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public String TimeTest2(){
		Timer timer=new Timer();
		final SimpleDateFormat a2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  TimerTask task=new TimerTask(){
			public void run() {
				// TODO �Զ����ɵķ������
				a2.format(new Date());
			}
			
		  };
		  timer.schedule(task, 1000,1000);
		  return a2.format(new Date());
		  }


}
