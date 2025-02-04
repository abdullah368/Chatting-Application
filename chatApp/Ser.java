
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ser extends JFrame implements ActionListener {
     JTextField t1;
     JPanel a1;
     Box vertical = Box.createVerticalBox();

    Ser(){
        setLayout((null));

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 60);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/p.jpeg") );
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel profile  = new JLabel(i3);
        profile.setBounds(25 ,2, 60 ,60);
        p1.add(profile);

        JLabel name = new JLabel("Server");
        name.setBounds(150,15, 100 ,18);
        name.setBackground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        p1.add(name);
        JLabel status = new JLabel("Active Now");
        status.setBounds(150, 35, 110, 20);
        status.setBackground(Color.WHITE);
        p1.add(status);

        a1 = new JPanel( );
        a1.setBounds(5, 75, 440, 530);
        add(a1);

        t1 = new JTextField();
        t1.setBounds(5, 600, 300, 50);
        t1.setFont(new Font("SAN_SERIF", Font.ITALIC, 18));
        add(t1);

        JButton btn = new JButton("Send");
        btn.setBounds(307, 600, 100, 48);
        btn.setBackground( new Color(7 , 94 ,84));
        btn.addActionListener(this);
        add(btn);

        setSize(450, 700); 
        setLocation(150, 50);
        setVisible(true); 


    }
    public void actionPerformed(ActionEvent ae){
        String out = t1.getText();
        JLabel output = new JLabel(out); 
        JPanel p2 = new JPanel();
        p2.add(output);


        a1.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add( right);
        vertical.add(Box.createVerticalStrut(15));

        a1.add(vertical, BorderLayout.PAGE_START);
        repaint();
        invalidate();
        validate();
    }
    public static void main(String[] args) {
        new Ser();
    }
    
}
