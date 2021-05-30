package university.jFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Ready  extends JFrame implements ActionListener{
	JButton b1=new JButton("ȷ��");
	JTextField t1=new JTextField(8);

	public Ready() {
		super("����");
		JLabel l1=new JLabel("�����ļ����Զ����ݵ�����");
		JLabel l2=new JLabel("�����ļ���");
		Container c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(l1);
		c.add(l2);
		c.add(t1);
		c.add(b1);
		b1.addActionListener(this);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(200, 150);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		// TODO �Զ����ɵĹ��캯�����
	}
	public static String comman="C:\\wamp\\bin\\mysql\\mysql5.5.24\\bin\\mysqldump -u root -p123456 shop";
    public static void back(String mySqlBackupName,String mysqlBackupPath, String command){
        
        String fPath=mysqlBackupPath+"/"+mySqlBackupName+".sql";
        Runtime rt = Runtime.getRuntime();
        try {
            Process child = rt.exec(command);
            InputStream in = child.getInputStream();
            //InputStreamReader input = new InputStreamReader(in);
            InputStreamReader input = new InputStreamReader(in,"utf-8");
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(input);
            while ((inStr = br.readLine()) != null) {     
                sb.append(inStr + "\r\n");     
            }     
            outStr = sb.toString(); 
            FileOutputStream fout = new FileOutputStream(fPath);
            //OutputStreamWriter writer = new OutputStreamWriter(fout);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");    
            writer.write(outStr);
            writer.flush();   
            
            in.close();     
            input.close();     
            br.close();     
            writer.close();     
            fout.close();
            
            //logger.info("MYSQL���ݳɹ�");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			String s=t1.getText();
			back(s,"C:\\Users\\Administrator\\Desktop",comman);
		     
            JOptionPane.showMessageDialog(null,"���ݳɹ���");
            this.setVisible(false);
		}
		// TODO �Զ����ɵķ������
		
	}

}
