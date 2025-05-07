import java.awt.*;
import javax.swing.*;
import java.util.*;
class JTableExp extends JFrame
{
    JTable         jt;
    Vector         head,data;
    JScrollPane    jsp;
    JPanel         con;
    public JTableExp()
    {
        con = (JPanel)getContentPane();
        head = new Vector();
        head.add("SLNO");
        head.add("Name");
        head.add("Age");

        data = new Vector();
        Vector r1 = new Vector();
        r1.add(1);
        r1.add("Ram");
        r1.add(18);
    

        data.add(r1);
       

        jt = new JTable(data,head);
        jsp = new JScrollPane(jt);
        add(jsp);
        
        setVisible(true);
        setSize(400,400);

    }
    public static void main(String args[])
    {
        JTableExp frm = new JTableExp();
    }
}