import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class myFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    
    myFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 130);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat= new SimpleDateFormat(", dd MMMMM yyyy");

        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();
       

        timeLabel.setFont(new Font("Verdana", Font.PLAIN,45));
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN,25));
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN,25));
        
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        this.setVisible(true);

        setTime();
    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
