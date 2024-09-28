import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

class Portal extends JFrame implements ActionListener
{

	JButton b4;
	JTextField b1,t1,t2,b2,b3;
	Portal()
	{
		super("Feedback Form");
		setSize(500,700);
		
		JLabel b=new JLabel(new ImageIcon("C:\\Users\\purvja\\Desktop\\bk.png"));
		b.setBounds(0,0,500,600);
		add(b);
		
		JLabel l=new JLabel("Feedback Form");
		l.setFont(new Font("Arial", Font.BOLD, 22));
		l.setBounds(160,100,200,30);

		b1=new JTextField("mail");
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setBounds(150,150,200,50);
		
		t1=new JTextField("Reg. No");
		t1.setFont(new Font("Arial", Font.BOLD, 15));
		t1.setBounds(150,250,200,50);

		b2=new JTextField("Roll No");
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		b2.setBounds(150,350,200,50);
		
		t2=new JTextField("Feedback");
		t2.setFont(new Font("Arial", Font.BOLD, 15));
		t2.setBounds(150,450,200,50);
		t2.addActionListener(this);
		
		b4=new JButton("Submit");
		b4.setFont(new Font("Arial", Font.BOLD, 15));
		b4.setBounds(150,550,200,50);
		b4.addActionListener(this);

		b.add(l);
		b.add(b1);
		b.add(b2);
		b.add(t1);
		b.add(t2);
		b.add(b4);
		
		b.setLayout(null);
		setLocationRelativeTo(null); 
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("create table if not exists feedbacks(email varchar(20),reg_no varchar(20),roll_no varchar(20),description varchar(20));");
			st.executeUpdate("insert into feedbacks values('"+b1.getText().toString()+"','"+t1.getText().toString()+"','"+b2.getText().toString()+"','"+t2.getText().toString()+"');");
			con.close();
		}
		catch(Exception ex)
		{System.out.println(ex);}
	}

}


public class Form
{
	public static void main(String ar[])throws Exception
	{
		Portal p=new Portal();
	}
}