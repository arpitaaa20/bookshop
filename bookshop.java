import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bookshop implements ActionListener {

	

	private static final bookshop New = null;

	/**
	 * @param args
	 */
	
	
	
private JPanel jpInfo = new JPanel();
	
	private JLabel lbid,lbName,lbPass,lbDS;
	private JTextField txtid,txtName,txtPrice;
	private TextArea txtArea;
	
	private JButton btnInsert, btnDelete, btnUpdate, btnDisplay, btnExecute, btnClose;
	int exe=0;
	
	static JFrame frame=new JFrame();
	
	bookshop()
	{
		frame.setTitle("Project");
		frame.setSize(480,340);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		jpInfo.setBounds(0,0,500,115);
		jpInfo.setLayout(null);
		
		lbDS = new JLabel("Book Shop !!!");
	    lbDS.setForeground(Color.black);
	    lbDS.setBounds(180,10,150,25);
	    lbDS.setFont(new Font("Arial",1,15));
	    
		
		lbid = new JLabel("Book Id :");
	    lbid.setForeground(Color.black);
	    lbid.setBounds(30,120,100,25);
	    lbid.setFont(null);
	    
	    lbName = new JLabel("Book Name :");
	    lbName.setForeground(Color.black);
	    lbName.setBounds(30,150,100,25);
	    lbName.setFont(null);
	    
	    lbPass = new JLabel("Book Price :");
	    lbPass.setForeground(Color.black);
	    lbPass.setBounds(30,180,100,25);
	    lbPass.setFont(null);
	    
	    txtid = new JTextField();
	    txtid.setHorizontalAlignment(JTextField.RIGHT);
	    txtid.setBounds(110,120,100,25);
	    txtid.setEditable(false);
	    
	    txtName = new JTextField();
	    txtName.setHorizontalAlignment(JTextField.RIGHT);
	    txtName.setBounds(110,150,100,25);
	    txtName.setEditable(false);
	    
	    txtPrice = new JTextField();
	    txtPrice.setHorizontalAlignment(JTextField.RIGHT);
	    txtPrice.setBounds(110,180,100,25);
	    txtPrice.setEditable(false);
	     
	    txtArea = new TextArea();
	    txtArea.setBounds(250,120,180,90);
	    txtArea.setEditable(false);  
	    
	    btnInsert = new JButton("Insert");
	    btnInsert.setBounds(50,50,80,25);
	    btnInsert.addActionListener(this);
	    
	    btnDelete = new JButton("Delete");
	    btnDelete.setBounds(150,50,80,25);
	    btnDelete.addActionListener(this);
	    
	    btnUpdate = new JButton("Update");
	    btnUpdate.setBounds(250,50,80,25);
	    btnUpdate.addActionListener(this);
	    
	    btnDisplay = new JButton("Display");
	    btnDisplay.setBounds(350,50,80,25);
	    btnDisplay.addActionListener(this);
	    
	    btnExecute = new JButton("Execute");
	    btnExecute.setBounds(150,250,80,25);
	    btnExecute.addActionListener(this);
	    
	    btnClose = new JButton("Close");
	    btnClose.setBounds(250,250,80,25);
	    btnClose.addActionListener(this);
	     
	    txtid.addKeyListener(new KeyAdapter()
	    {
	    	public void keyTyped(KeyEvent ke)
	    	{
	    	  char c = ke.getKeyChar();
	    	  if(!((Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE))))
	    	  {
	    		  frame.getToolkit().beep();
	    		  ke.consume();
	    	  }
	    	}
	    });
	    
	    txtName.addKeyListener(new KeyAdapter()
	    {
	    	public void keyTyped(KeyEvent ke)
	    	{
	    	  char c = ke.getKeyChar();
	    	  if(Character.isDigit(c))
	    	  {
	    		  frame.getToolkit().beep();
	    		  ke.consume();
	    	  }
	    	}
	    });  
	    
	    txtPrice.addKeyListener(new KeyAdapter()
	    {
	    	public void keyTyped(KeyEvent ke)
	    	{
	    	  char c = ke.getKeyChar();
	    	  if(!((Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE))))
	    	  {
	    		  frame.getToolkit().beep();
	    		  ke.consume();
	    	  }
	    	}
	    });
	    
		JPanel panel = new JPanel();
	    JLabel label = new JLabel();
	    panel.setBounds(0,5,260,230);
	    panel.add(label);
	    
	    jpInfo.add(lbDS);
	    jpInfo.add(lbid);
	    jpInfo.add(lbName);
	    jpInfo.add(lbPass);
	    jpInfo.add(txtid);
	    jpInfo.add(txtName);
	    jpInfo.add(txtPrice);
	    jpInfo.add(txtArea);
	    jpInfo.add(btnInsert);
	    jpInfo.add(btnDelete);
	    jpInfo.add(btnUpdate);
	    jpInfo.add(btnDisplay);
	    jpInfo.add(btnExecute);
	    jpInfo.add(btnClose); 
	    jpInfo.add(panel);
	    
	    
	    
	    frame.getContentPane().add(jpInfo);
	    frame.setVisible(true);
	  //  frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		Object obj = ae.getSource();
		
		if(obj==btnInsert)
		{
			txtid.setEditable(true);
			txtName.setEditable(true);
			txtPrice.setEditable(true);
		    btnInsert.setForeground(Color.magenta);
		    btnDelete.setForeground(null);
		    btnUpdate.setForeground(null);
		    btnDisplay.setForeground(null);
		    exe = 1;    
		}
		
		if(obj==btnDelete)
		{
			txtid.setEditable(true);
			txtName.setEditable(false);
			txtPrice.setEditable(false);
			btnDelete.setForeground(Color.magenta);
			btnInsert.setForeground(null);
			btnUpdate.setForeground(null);
			btnDisplay.setForeground(null);
			exe = 2;	
		}
		
		if(obj==btnUpdate)
		{
			txtid.setEditable(true);
			txtName.setEditable(true);
			txtPrice.setEditable(true);
			btnUpdate.setForeground(Color.magenta);
			btnInsert.setForeground(null);
			btnDelete.setForeground(null);
			btnDisplay.setForeground(null);
			exe = 3;
					
		}
		
		if(obj==btnDisplay)
		{
			txtid.setEditable(false);
			txtName.setEditable(false);
			txtPrice.setEditable(false);
			btnDisplay.setForeground(Color.magenta);
			btnInsert.setForeground(null);
			btnDelete.setForeground(null);
			btnUpdate.setForeground(null);
			exe = 4;			
		}
		
		if(obj==btnExecute)
		{		
			execute();
	     }
				
	
		if(obj == btnClose)
		{
			frame.setVisible(false);
			frame.dispose();
			System.exit(0);
		}						
	}
	

	private void execute() {
		switch (exe) {
		case 1:
			try {
				
				DAO db=new DAO();
				Connection conn=db.getConnection();
				
				int id = Integer.parseInt(txtid.getText());
				String name = txtName.getText();
				String price = txtPrice.getText();
				
			     String insertQuery = "insert into bookshop values(?,?,?)";
				 PreparedStatement preparedStatement;
				    
				 preparedStatement = conn.prepareStatement(insertQuery);
			     preparedStatement.setString(1,id+"");
		         preparedStatement.setString(2,name);
			     preparedStatement.setString(3,price);
				    
		         preparedStatement.executeUpdate();
			     txtArea.setText("Data Inserted Successfully!!!");
			} 
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			txtClear();
			break;

		case 2:
			try {
				DAO db = new DAO();
				Connection conn = db.getConnection();

				int id = Integer.parseInt(txtid.getText());
				String deleteQuery = "delete from bookshop where id=?";
				PreparedStatement preparedStatement;

				preparedStatement = conn.prepareStatement(deleteQuery);
				preparedStatement.setString(1, id + "");

				int count = preparedStatement.executeUpdate();

				if(count == 0)
				{
					txtArea.setText("\r No record found with Id : " + id);
				}
				else
				{
					txtArea.setText("\r Total " + count + " record/s deleted !!!");
				}
			} 
			catch(Exception e)
			{
				System.out.println(e);
			}
			txtClear();
			break;

		case 3:
			try {
				DAO db = new DAO();
				Connection conn = db.getConnection();

				int id = Integer.parseInt(txtid.getText());
				String name = txtName.getText();
				String price = txtPrice.getText();

				String selectQuery = "update bookshop set name=?,price=? where id=?";
				PreparedStatement pstmt = null;
				pstmt = conn.prepareStatement(selectQuery);

				pstmt.setString(1, name);
				pstmt.setString(2, price);
				pstmt.setString(3, id + "");

				int count = pstmt.executeUpdate();
				if(count == 0)
				{
					txtArea.setText("\r No record/s found with id : " + id);
				}
				else 
				{
					txtArea.setText("\r Record id " + id
							+ " Data Updated Successfully !!!");
					
				}
				

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			txtClear();
			break;
			
		case 4:
			try {
				
				DAO db = new DAO();
				Connection conn = db.getConnection();

				String selectQuery = "select * from bookshop";

				PreparedStatement preparedStatement = conn
						.prepareStatement(selectQuery);

				ResultSet result = preparedStatement.executeQuery();
				String s1 = "";
				while (result.next()) {
					s1 += ("\n \r Id=" + result.getString(1)
							+ "\n \r Name=" + result.getString(2)
							+ "\n \r Price =" + result.getString(3) + "\n");
				}
				txtArea.setText(s1);
			} 
			catch(Exception e)
			{
				System.out.println(e);
			} 
			txtClear();
			break;
		}		
	}

	void txtClear()
	{
		txtid.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtid.requestFocus();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bookshop p=new bookshop();
	}
}