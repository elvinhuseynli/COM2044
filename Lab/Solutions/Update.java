import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Update extends JFrame implements ActionListener{

	JLabel title, id;
	JPanel panel;
	JTextField tid;
	JButton getButton, insertButton, deleteButton, tableButton;
	Object newData[][] = new Object[100][7];

	public Update() {

		newData = Table.newData;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,400);

		title = new JLabel("Update Customer");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250,30,300,35);

		insertButton = new JButton("Insert");
		insertButton.setBounds(325,300,150,40);
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(Color.yellow);

		id = new JLabel("ID:");
        id.setBounds(100,200,50,35);
        id.setVisible(true);
        tid = new JTextField();
        tid.setBounds(150,200,250,35);
        tid.setVisible(true);

		//insert Button
		tableButton = new JButton("Table");
		tableButton.setBounds(100,300,150,40);
		tableButton.setFocusable(false);
		tableButton.addActionListener(this);
		tableButton.setBackground(Color.yellow);
		//Delete Button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(550,300,150,40);
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(this);
		deleteButton.setBackground(Color.yellow);

		getButton = new JButton("Get Customer");
		getButton.setBounds(450,200,300,40);
		getButton.setFocusable(false);
		getButton.addActionListener(this);
		getButton.setBackground(Color.blue);

		this.setSize(800, 400);
		this.setTitle("Customer Service");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setFocusable(true);
    	this.setLayout(null);
    	this.setVisible(true);
    	panel.add(tableButton);
    	panel.add(deleteButton);
    	panel.add(insertButton);
    	panel.add(getButton);
    	panel.add(title);
    	panel.add(id);panel.add(tid);
    	this.add(panel);
	}


	public void showError(String text){
		JOptionPane.showMessageDialog(this, "There is no customer with id"+text,"Error",JOptionPane.ERROR_MESSAGE);
	}


	public void showSuccess(){
		this.setVisible(false);
		this.dispose();
		Update2 upd = new Update2();
	}


	public void checkCustomer(){
		String text = tid.getText();
		for(int i=0; i<newData.length;i++){
			if(newData[i][0].toString().equals(text)){
				showSuccess();
				return;
			}
		}
		showError(text);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getButton){
			checkCustomer();
		}
		if(e.getSource() == tableButton){
			this.setVisible(false);
			this.dispose();
			Table table = new Table();
		}
		if(e.getSource() == insertButton){
			this.setVisible(false);
			this.dispose();
			Insertion ins = new Insertion();
		}
	}
}