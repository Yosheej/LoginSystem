import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDlabel = new JLabel("User ID: ");
	JLabel userPasswordlabel = new JLabel("Password: ");
	JLabel messagelabel = new JLabel();
	
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		loginInfo = loginInfoOriginal;
		
		userIDlabel.setBounds(50,100,75,25);
		userPasswordlabel.setBounds(50,150,75,25);
		
		messagelabel.setBounds(125,250,250,35);
		messagelabel.setFont(new Font(null, Font.BOLD, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 50);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 50);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDlabel);
		frame.add(userPasswordlabel);
		frame.add(messagelabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == resetButton) {
			
			userIDField.setText("");
			userPasswordField.setText("");
			
		}
		
		if(e.getSource() == loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(loginInfo.containsKey(userID)) {
				
				if(loginInfo.get(userID).equals(password)) {
					
					messagelabel.setForeground(Color.BLACK);
					messagelabel.setText("Login Successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
					
				}
				
				else {
					messagelabel.setForeground(Color.RED);
					messagelabel.setText("Invalid Password");
				}
	
			}
			
			else {
				messagelabel.setForeground(Color.BLUE);
				messagelabel.setText("User Not Found");
			}
			
		}
	}
}