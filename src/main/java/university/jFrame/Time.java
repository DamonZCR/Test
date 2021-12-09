package university.jFrame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Time {

	public Time() {
		// TODO 自动生成的构造函数存根
	}
	
	public String TimeTest2(){
		Timer timer=new Timer();
		final SimpleDateFormat a2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  TimerTask task=new TimerTask(){
			public void run() {
				// TODO 自动生成的方法存根
				a2.format(new Date());
			}
			
		  };
		  timer.schedule(task, 1000,1000);
		  return a2.format(new Date());
		  }


}
