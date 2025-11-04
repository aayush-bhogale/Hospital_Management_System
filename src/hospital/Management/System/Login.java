package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    // --- DECLARED AS INSTANCE VARIABLES ---
    JTextField textField;
    JPasswordField passwordField;
    JButton loginButton, cancelButton;

    Login() {
        setTitle("Login");

        JLabel nameLable = new JLabel("Username");
        nameLable.setBounds(40, 20, 100, 30);
        nameLable.setFont(new Font("Blue", Font.BOLD, 16));
        add(nameLable);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        passwordLabel.setFont(new Font("Blue", Font.BOLD, 16));
        add(passwordLabel);

        // --- INITIALIZED THE INSTANCE VARIABLES ---
        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Red", Font.PLAIN, 15));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        passwordField.setFont(new Font("Red", Font.PLAIN, 15));
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(40, 140, 120, 30);
        loginButton.setFont(new Font("serif", Font.BOLD, 15));
        loginButton.setBackground(new Color(137, 239, 181));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 140, 120, 30);
        cancelButton.setFont(new Font("serif", Font.BOLD, 15));
        cancelButton.setBackground(new Color(152, 235, 245));
        cancelButton.setForeground(Color.WHITE);
        // --- CORRECTED THE LISTENER TYPE ---
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/loginpage.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(i1));
        label.setBounds(350, 20, 200, 200);
        add(label);

        getContentPane().setBackground(new Color(229, 219, 204));
        setSize(600, 300);
        setLocationRelativeTo(null); // Centers the frame on screen
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                conn c = new conn();
                // --- CORRECT WAY TO GET USER INPUT ---
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());

                // --- SECURE QUERY USING PreparedStatement ---
                String q = "SELECT * FROM login WHERE ID = ? AND PW = ?";

                PreparedStatement pstmt = c.connection.prepareStatement(q);
                pstmt.setString(1, user); // Set the first '?' to the username
                pstmt.setString(2, pass);  // Set the second '?' to the password

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Login successful
                    new Reception();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

                // Close resources
                rs.close();
                pstmt.close();
                c.connection.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0); // Exit the application
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}