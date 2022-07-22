import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Insertion extends JFrame implements ActionListener{

	JButton tableButton, deleteButton, updateButton, insertButton;
	JPanel panel;
	public static Object data[][], newData[][]= new Object[100][7];
	JLabel title, id, name, surname, telno, subscription, balance, followers;
	JTextField tid, tname, tsurname, ttelno, tbalance, tfollowers;
	JComboBox tsubscription;
	private static final long serialVersionUID = 5462223600l;

	public Insertion(){

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,900);

		data = Model.DATA;
		createData();

		title = new JLabel("Insert Customer");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250,30,300,35);

        //Name label and textfield
    	name = new JLabel("Name");
        name.setBounds(100,150,150,20);
        name.setVisible(true);
        tname = new JTextField();
        tname.setBounds(380,150,190,20);
        tname.setVisible(true);

		//username label and textfield
    	surname = new JLabel("Surname");
        surname.setVisible(true);
        surname.setBounds(100,200,150,20);
        tsurname = new JTextField();
        tsurname.setVisible(true);
        tsurname.setBounds(380,200,190,20);

        //Name label and textfield
    	id = new JLabel("ID");
        id.setBounds(100,100,150,20);
        id.setVisible(true);
        tid = new JTextField();
        tid.setBounds(380,100,190,20);
        tid.setVisible(true);

		//Name label and textfield
    	telno = new JLabel("Telephone Number");
        telno.setBounds(100,250,150,20);
        telno.setVisible(true);
        ttelno = new JTextField();
        ttelno.setBounds(380,250,190,20);
        ttelno.setVisible(true);

		//Name label and textfield
    	balance = new JLabel("Balance");
        balance.setBounds(100,350,150,20);
        balance.setVisible(true);
        tbalance = new JTextField();
        tbalance.setBounds(380,350,190,20);
        tbalance.setVisible(true);

        //Name label and textfield
    	followers = new JLabel("Number of Followers");
        followers.setBounds(100,400,150,20);
        followers.setVisible(true);
        tfollowers = new JTextField();
        tfollowers.setBounds(380,400,190,20);
        tfollowers.setVisible(true);

		//Name label and textfield
    	subscription = new JLabel("Subscription Type");
        subscription.setBounds(100,300,150,20);
        subscription.setVisible(true);
        String types[] = {"None", "Premium", "Gold Premium", "VIP"};
        tsubscription = new JComboBox(types);
        tsubscription.setBounds(380,300,190,20);
        tsubscription.setVisible(true);

		//table Button
		insertButton = new JButton("Insert");
		insertButton.setBounds(200,600,400,40);
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(Color.green);

		//insert Button
		tableButton = new JButton("Table");
		tableButton.setBounds(100,800,150,40);
		tableButton.setFocusable(false);
		tableButton.addActionListener(this);
		tableButton.setBackground(Color.yellow);
		
		//Update Button
		updateButton = new JButton("Update");
		updateButton.setBounds(325,800,150,40);
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		updateButton.setBackground(Color.yellow);
		
		//Delete Button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(550,800,150,40);
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(this);
		deleteButton.setBackground(Color.yellow);

		this.setSize(800,900);
		this.setTitle("Customer Service");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setFocusable(true);
    	this.setLayout(null);
    	this.setVisible(true);

		panel.add(tableButton);
    	panel.add(deleteButton);
    	panel.add(insertButton);
    	panel.add(updateButton);
    	panel.add(title);
		panel.add(name);panel.add(tname);
		panel.add(surname);panel.add(tsurname);
		panel.add(id);panel.add(tid);
		panel.add(telno);panel.add(ttelno);
		panel.add(followers);panel.add(tfollowers);
		panel.add(subscription);panel.add(tsubscription);
		panel.add(balance);panel.add(tbalance);
		
    	this.add(panel);
	}


	public void createData(){
		for(int i=0; i<data.length; i++){
			for (int j=0; j<data[0].length; j++) {
				newData[i][j] = data[i][j];
			}
		}
	}


	public void showSuccess(){

		for(int i=0; i<data[0].length; i++){
			newData[data.length][0] = Long.parseLong(tid.getText());
			newData[data.length][1] = tname.getText();
			newData[data.length][2] = tsurname.getText();
			newData[data.length][3] = ttelno.getText();
			newData[data.length][4] = tsubscription.getSelectedItem().toString();
			newData[data.length][5] = Double.parseDouble(tbalance.getText());
			newData[data.length][6] = Integer.parseInt(tfollowers.getText());
		}

		JOptionPane.showMessageDialog(this, "The customer has been succesfully inserted!");
	}


	public void showError(String text){
		JOptionPane.showMessageDialog(this, "There is already a customer with id"+text,"Error",JOptionPane.ERROR_MESSAGE);
	}


	public void insertionCheck(String text){
		for(int i=0; i<newData.length; i++) {
			if(newData[i][0].toString().equals(text)){
				showError(text);
				return;
			}
		}
		showSuccess();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tableButton){
			this.setVisible(false);
			this.dispose();
			Table table = new Table();
			table.newData = newData;
		}

		if(e.getSource() == updateButton){
			this.setVisible(false);
			this.dispose();
			Update update = new Update();
		}

		if (e.getSource() == insertButton){
			insertionCheck(tid.getText());
		}
	}

}
