package university.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MicroWaveWindow extends JFrame{

    JLabel timeLable;//����ʱ��ʱ���ǩ

    public void setTimeLable(int hour,int minutes,int second) {
        String hourStr = String.format("%2d",hour);
        String minutesStr = String.format("%2d",minutes);
        String secondStr = String.format("%2d", second);

        hourStr = hourStr.replace(' ','0');
        minutesStr = minutesStr.replace(' ','0');
        secondStr = secondStr.replace(' ','0');

        this.timeLable.setText(hourStr + ":" + minutesStr + ":" + secondStr);
    }

    //���������Ƶ�΢��¯
    public MicroWaveWindow(final MicroWave microWave) {
        this.setTitle("΢��¯�������");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel upPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel downPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(upPanel, BorderLayout.NORTH);
        timeLable = new JLabel();
        upPanel.add(timeLable);
        timeLable.setFont(new Font("Dialog", 1, 100));
        timeLable.setText(microWave.getHour() + ":" + microWave.getMinutes() + ":" + microWave.getSecond());

        this.add(midPanel, BorderLayout.CENTER);
        midPanel.setLayout(new BorderLayout());
        JPanel midUpPanel = new JPanel();
        JPanel midDownPanel = new JPanel();
        midPanel.add(midUpPanel,BorderLayout.NORTH);
        midPanel.add(midDownPanel,BorderLayout.SOUTH);

        JLabel fire = new JLabel("����");
        JRadioButton bigFire = new JRadioButton("���");
        JRadioButton midFire = new JRadioButton("�л�");
        JRadioButton smallFire = new JRadioButton("С��");
        midUpPanel.add(fire);
        midUpPanel.add(bigFire);
        midUpPanel.add(midFire);
        midUpPanel.add(smallFire);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(bigFire);
        buttonGroup.add(midFire);
        buttonGroup.add(smallFire);

        JLabel addTime = new JLabel("ʱ��");
        midDownPanel.add(addTime);
        JButton addHour = new JButton("+1Сʱ");
        JButton addMinutes = new JButton("+1����");
        JButton addSecond = new JButton("+1��");
        midDownPanel.add(addHour);
        midDownPanel.add(addMinutes);
        midDownPanel.add(addSecond);

        addHour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                microWave.addHour(1);
            }
        });
        addMinutes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                microWave.addMinutes(1);
            }
        });
        addSecond.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                microWave.addSecond(1);
            }
        });


        this.add(downPanel, BorderLayout.SOUTH);
        JLabel function = new JLabel("����");
        JButton startButton = new JButton("��ʼ");
        JButton pauseButton = new JButton("��ͣ");
        JButton stopButton = new JButton("ֹͣ");
        downPanel.add(function);
        downPanel.add(startButton);
        downPanel.add(pauseButton);
        downPanel.add(stopButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (microWave.getHour() == 0 && microWave.getMinutes() == 0 && microWave.getSecond() == 0) {
                    JOptionPane.showMessageDialog(null,"ʱ��Ϊ0!");
                } else {
                    microWave.setIsRun(true);
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                microWave.setIsRun(false);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                microWave.setIsRun(false);
                microWave.setHour(0);
                microWave.setMinutes(0);
                microWave.setSecond(0);
            }
        });

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
