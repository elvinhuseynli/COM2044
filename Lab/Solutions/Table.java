import java.io.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame implements ActionListener{

	JButton insertButton, deleteButton, updateButton, filterButton;
	JTextField filterText;
	JPanel panel;
	JLabel name;
	JScrollPane sp;
	JTable dataTable;
	DefaultTableModel model;
	String column[] = {"Id","Name","Surname","Telephone Number","Subscription Type","Balance","Number of Followers"};
	public static Object data[][], newData[][] = new Object[100][7], filteredData[][]= new Object[100][7];

	public Table(){

		//The table screen
		data = Model.DATA;
		createData();
	 	dataTable = new JTable();
	 	dataTable.setModel(new DefaultTableModel(newData,column));
		sp = new JScrollPane(dataTable);
		sp.setBounds(40,200,1120,500);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1200,900);

		name = new JLabel("Customer Table");
        name.setFont(new Font("Arial", Font.BOLD, 30));
        name.setBounds(470,30,300,35);

		//Insert Button
		insertButton = new JButton("Insert");
		insertButton.setBounds(200,800,150,40);
		insertButton.setFocusable(false);
		insertButton.addActionListener(this);
		insertButton.setBackground(Color.yellow);
		
		//Update Button
		updateButton = new JButton("Update");
		updateButton.setBounds(525,800,150,40);
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		updateButton.setBackground(Color.yellow);
		
		//Delete Button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(850,800,150,40);
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(this);
		deleteButton.setBackground(Color.yellow);

		//InsertButton
		filterButton = new JButton("Filter");
		filterButton.setBounds(700,100,150,40);
		filterButton.setFocusable(false);
		filterButton.addActionListener(this);
		filterButton.setBackground(Color.green);

		//Filter Text
		filterText = new JTextField();
		filterText.setBounds(200,110,490,25);

		this.setSize(1200,900);
		this.setTitle("Customer Service");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setFocusable(true);
    	this.setLayout(null);
    	this.setVisible(true);

    	panel.add(sp);
    	panel.add(filterText);
    	panel.add(insertButton);
    	panel.add(deleteButton);
    	panel.add(updateButton);
    	panel.add(filterButton);
    	panel.add(name);
    	this.add(panel);

	}


	public void createData(){
		for(int i=0; i<data.length; i++){
			for (int j=0; j<data[0].length; j++) {
				newData[i][j] = data[i][j];
			}
		}
	}


	//The function to filter data
	public void filterData(String text){
		int t = 0;
		model = (DefaultTableModel) dataTable.getModel();
		model.setRowCount(0);
		for(int i=0; i<newData.length; i++){
			for(int j=0; j<newData[0].length; j++){
				if (newData[i][j].toString().contains(text)){
					for(int k=0; k<newData[0].length; k++){
						filteredData[t][k] = newData[i][k];

					}
					model.addRow(filteredData[t]);
					t++;
					break;
				}
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getSource() == insertButton){
			this.setVisible(false);
			this.dispose();
			Insertion window = new Insertion();
		}
		if (e.getSource() == updateButton){
			this.setVisible(false);
			this.dispose();
			Update window = new Update();
		}
		// if (e.getSource() == deleteButton){
		// 	this.setVisible(false);
		// 	this.dispose();
		// 	Delete window = new Delete();
		// }
		if (e.getSource() == filterButton){
			String text = filterText.getText();
			filterData(text);
		}
	}


	//The main executing function
	public static void main(String[] args) {
		Table table = new Table();
	}
}