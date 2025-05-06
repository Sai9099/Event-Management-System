import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
 
class RBGFrame extends JFrame
                implements AdjustmentListener,
                           ActionListener

{
    JPanel          con,col,scroll,label;
    JLabel          lr,lb,lg;
    JTextField      tr,tb,tg;
    JScrollBar      sr,sb,sg;

    public RBGFrame()
    {
        setTitle("RBG Demo ");
        setSize(400,400);

        con = (JPanel)getContentPane();
        col = new JPanel();
        label = new JPanel(new GridLayout(1,6));
        scroll = new JPanel(new GridLayout(4,1));

        sr = new JScrollBar();
        sb = new JScrollBar();
        sg = new JScrollBar();

        tr = new JTextField("0");
        tb = new JTextField("0");
        tg = new JTextField("0");
        
        lr = new JLabel("Red   :",JLabel.RIGHT);
        lb = new JLabel("Blue  :",JLabel.RIGHT);
        lg = new JLabel("Green :",JLabel.RIGHT);

        sr.setOrientation(0);
        sb.setOrientation(0);
        sg.setOrientation(0);

        sr.setMinimum(0);
        sb.setMinimum(0);
        sg.setMinimum(0);

        sr.setMaximum(100);
        sb.setMaximum(100);
        sg.setMaximum(100);

        sr.setValue(10);
        sb.setValue(10);
        sg.setValue(10);

        col.setBackground(new Color(10,10,10));

        lb.setBackground(Color.BLUE);
        lg.setBackground(Color.GREEN);
        lr.setBackground(Color.RED);

        sb.setBackground(Color.BLUE);
        sg.setBackground(Color.GREEN);
        sr.setBackground(Color.RED);

        sb.setForeground(Color.BLUE);
        sg.setForeground(Color.GREEN);
        sr.setForeground(Color.RED);

        tr.addActionListener(this);
        tb.addActionListener(this);
        tg.addActionListener(this);

        sr.addAdjustmentListener(this);
        sb.addAdjustmentListener(this);
        sg.addAdjustmentListener(this);

        con.add(col,"Center");
        con.add(scroll,"South");

        label.add(lr);
        label.add(tr);
        label.add(lg);
        label.add(tg);
        label.add(lb);
        label.add(tb);

        scroll.add(label);
        scroll.add(sr);
        scroll.add(sg);
        scroll.add(sb);
    
    }

    public void adjustmentValueChanged(AdjustmentEvent ae)
    {
        col.setBackground(
                          new Color(
                                    sr.getValue(),
                                    sg.getValue(),
                                    sb.getValue()
                                    )
                        );
                        tr.setText(String.valueOf(sr.getValue()));
                        tb.setText(String.valueOf(sb.getValue()));
                        tg.setText(String.valueOf(sg.getValue()));
    }

    public void actionPerformed(ActionEvent ae)
    {
        JTextField tf = (JTextField)ae.getSource();

        if(Integer.parseInt(tf.getText())<0);
        tf.setText("0");
        if(Integer.parseInt(tf.getText())<100)
        tf.setText("100");

        sr.setValue(Integer.parseInt(tr.getText()));
        sb.setValue(Integer.parseInt(tb.getText()));
        sg.setValue(Integer.parseInt(tg.getText()));

    }
}

class RBGExp
{
    public static void main(String args[])
    {
        RBGFrame f= new RBGFrame();
        f.show();

    }
}