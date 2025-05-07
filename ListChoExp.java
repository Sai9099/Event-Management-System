import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class OrderForm extends JFrame
                implements ActionListener,
                           ItemListener,
                           ListSelectionListener
                {
                    Vector v1,v2;
                    JRadioButton   rbs1,rbm1,rbs2,rbm2;
                    ButtonGroup    bgr1,bgr2;
                    JButton        badd,brmv,bexit;
                    JList          lst1,lst2;
                    JScrollPane    jsp1,jsp2;
                    JComboBox      ch;
                    JLabel         l1,l2,l3;
                    JPanel         p1,p2,p3,p4,p5,c;

                    public OrderForm()
                    {
                        setTitle("Order Form ");
                        setSize(500,300);
                        setResizable(false);

                        c = (JPanel) getContentPane();

                        rbs1 = new JRadioButton("Single Selection",true);
                        rbs2 = new JRadioButton("Single Selection",true);
                        rbm1 = new JRadioButton("Mutiple Selection");
                        rbm2 = new JRadioButton("Mutiple Selection");

                        rbs1.addItemListener(this);
                        rbs2.addItemListener(this);
                        rbm1.addItemListener(this);
                        rbm2.addItemListener(this);

                        bgr1 = new ButtonGroup();
                        bgr2 = new ButtonGroup();

                        bgr1.add(rbs1);
                        bgr1.add(rbm1);
                        bgr2.add(rbs2);
                        bgr2.add(rbm2);

                        badd = new JButton("Add");
                        brmv = new JButton("Remove");
                        bexit = new JButton("Exit");

                        badd.addActionListener(this);
                        brmv.addActionListener(this);
                        bexit.addActionListener(this);

                        badd.setEnabled(false);
                        brmv.setEnabled(false);

                        v1 = new Vector();
                        v2 = new Vector();

                        v1.add("Rice ");
                        v1.add("Wheat");
                        v1.add("Drinks");
                        v1.add("Sugar");
                        v1.add("salt");
                        v1.add("Apple");;
                        v1.add("Banana");
                        v1.add("Vegetables");
                        v1.add("Soap");
                        v1.add("Mango");

                        lst1 = new JList(v1);
                        lst2 = new JList(v2);

                        lst1.addListSelectionListener(this);
                        lst2.addListSelectionListener(this);

                        lst1.setSelectionMode(0);

                        jsp1 = new JScrollPane(lst1);
                        jsp2 = new JScrollPane(lst2);
                        
                        ch = new JComboBox();

                        l1 = new JLabel("Provided Items");
                        l2 = new JLabel("Selected Items");
                        l3 = new JLabel("Payment mode");

                        p1  = new JPanel(new GridLayout(1,3));
                        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        p3 =  new JPanel(new GridLayout(2,1));
                        p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                        c.add(p1,"Center");
                        c.add(p5,"South");

                        p1.add(p2);
                        p1.add(p3);
                        p1.add(p4);

                        p2.add(l1);
                        p2.add(jsp1);
                        p2.add(rbs1);
                        p2.add(rbm1);

                        p4.add(l2);
                        p4.add(jsp2);
                        p4.add(rbs2);
                        p4.add(rbm2);

                        p3.add(badd);
                        p3.add(brmv);

                        p5.add(l3);
                        p5.add(ch);
                        p5.add(bexit);

                        ch.addItem("Cash");
                        ch.addItem("Account");
                        ch.addItem("Exchange");
                    }
                    public void actionPerformed(ActionEvent ae)
                    {
                        if(ae.getSource()==badd)
                        {
                            int ele[]=lst1.getSelectedIndices();

                            for(int i=0;i<ele.length;i++)
                            v2.add(v1.elementAt(ele[i]));
                            for(int i=0;i<ele.length;i++)
                            v1.removeElementAt(ele[i]);

                            lst1.setListData(v1);
                            lst2.setListData(v2);

                        }
                        else if(ae.getSource()==brmv)
                        {
                            int[] ele = lst2.getSelectedIndices();

                            for(int i=0;i<ele.length;i++)
                            v1.add(v2.elementAt(ele[i]));
                            for(int i=0;i<ele.length;i++)
                            v2.removeElementAt(ele[i]);

                            lst1.setListData(v1);
                            lst2.setListData(v2);

                        }
                        else
                        System.exit(0);

                    }
                    public void itemStateChanged(ItemEvent ie)
                    {
                        if(ie.getSource()==rbs1)
                                lst1.setSelectionMode(0);
                        else if(ie.getSource()==rbs2)
                                lst2.setSelectionMode(0);
                        else if(ie.getSource()==rbm1)
                                lst1.setSelectionMode(1);
                        else    lst2.setSelectionMode(1); 
                    

                    }
                    public void valueChanged(ListSelectionEvent le)
                    {
                        if(le.getSource()==lst1)
                            badd.setEnabled(!lst1.isSelectionEmpty());
                        else
                            brmv.setEnabled(!lst2.isSelectionEmpty());


                    
                    }
                }
class ListChoExp
{
    public static void main(String args[])
    {
        OrderForm f = new OrderForm();
        f.show();

    }
}