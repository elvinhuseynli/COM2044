import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Update2 extends JFrame implements ActionListener{

	JLabel title,title1, id1, id, name, surname, telno, subscription, balance, followers;
	JTextField tid,tid1, tname, tsurname, ttelno, tbalance, tfollowers;
	JComboBox tsubscription;
	JPanel panel;
	JButton getButton, insertButton, deleteButton, tableButton, updateButton;
	Object newData[][] = new Object[100][7];

	public Update2() {

		newData = Table.newData;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,900);

		title = new JLabel("Update Customer");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250,30,300,35);

		insertButton = new JButton("Insert");
		insertButton.setBounds(325,800,150,40);
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(Color.yellow);

		id = new JLabel("ID:");
        id.setBounds(100,200,50,35);
        id.setVisible(true);
        tid = new JTextField();
        tid.setBounds(150,200,250,35);
        tid.setVisible(true);


		title1 = new JLabel("Customer Information");
        title1.setFont(new Font("Arial", Font.BOLD, 20));
        title1.setBounds(250,280,300,25);

        //Name label and textfield
    	name = new JLabel("Name");
        name.setBounds(100,400,150,20);
        name.setVisible(true);
        tname = new JTextField();
        tname.setBounds(380,400,190,20);
        tname.setVisible(true);

		//username label and textfield
    	surname = new JLabel("Surname");
        surname.setVisible(true);
        surname.setBounds(100,450,150,20);
        tsurname = new JTextField();
        tsurname.setVisible(true);
        tsurname.setBounds(380,450,190,20);

		//Name label and textfield
    	telno = new JLabel("Telephone Number");
        telno.setBounds(100,500,150,20);
        telno.setVisible(true);
        ttelno = new JTextField();
        ttelno.setBounds(380,500,190,20);
        ttelno.setVisible(true);

		//Name label and textfield
    	balance = new JLabel("Balance");
        balance.setBounds(100,600,150,20);
        balance.setVisible(true);
        tbalance = new JTextField();
        tbalance.setBounds(380,600,190,20);
        tbalance.setVisible(true);

        //Name label and textfield
    	followers = new JLabel("Number of Followers");
        followers.setBounds(100,650,150,20);
        followers.setVisible(true);
        tfollowers = new JTextField();
        tfollowers.setBounds(380,650,190,20);
        tfollowers.setVisible(true);

		//Name label and textfield
    	subscription = new JLabel("Subscription Type");
        subscription.setBounds(100,550,150,20);
        subscription.setVisible(true);
        String types[] = {"None", "Premium", "Gold Premium", "VIP"};
        tsubscription = new JComboBox(types);
        tsubscription.setBounds(380,550,190,20);
        tsubscription.setVisible(true);

		//insert Button
		tableButton = new JButton("Table");
		tableButton.setBounds(100,800,150,40);
		tableButton.setFocusable(false);
		tableButton.addActionListener(this);
		tableButton.setBackground(Color.yellow);
		//Delete Button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(550,800,150,40);
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(this);
		deleteButton.setBackground(Color.yellow);

		getButton = new JButton("Get Customer");
		getButton.setBounds(450,200,300,40);
		getButton.setFocusable(false);
		getButton.addActionListener(this);
		getButton.setBackground(Color.blue);

		//table Button
		updateButton = new JButton("Update");
		updateButton.setBounds(200,700,400,40);
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		updateButton.setBackground(Color.blue);

		this.setSize(800, 900);
		this.setTitle("Customer Service");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setFocusable(true);
    	this.setLayout(null);
    	this.setVisible(true);


    	panel.add(name);panel.add(tname);
		panel.add(surname);panel.add(tsurname);
		panel.add(telno);panel.add(ttelno);
		panel.add(followers);panel.add(tfollowers);
		panel.add(subscription);panel.add(tsubscription);
		panel.add(balance);panel.add(tbalance);
		panel.add(title1);
    	panel.add(tableButton);
    	panel.add(updateButton);
    	panel.add(deleteButton);
    	panel.add(insertButton);
    	panel.add(getButton);
    	panel.add(title);
    	panel.add(id);panel.add(tid);
    	this.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e){

	}
}