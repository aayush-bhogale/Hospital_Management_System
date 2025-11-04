package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update_Patient_Details extends JFrame {
    public Update_Patient_Details() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(500,60,300,300);
        panel.add(imageLabel);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(250,85,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.addItem(resultSet.getString("Name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(250,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.white);
        panel.add(label4);
        JTextField textFieldtime = new JTextField();
        textFieldtime.setBounds(250,174,140,20);
        panel.add(textFieldtime);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,216,100,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.white);
        panel.add(label5);
        JTextField textFieldamt = new JTextField();
        textFieldamt.setBounds(250,216,140,20);
        panel.add(textFieldamt);

        JLabel label6 = new JLabel("Amount Pending :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.white);
        panel.add(label6);
        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(250,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info WHERE Name='"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_No"));
                        textFieldtime.setText(resultSet.getString("Time"));
                        textFieldamt.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet rs1 = c.statement.executeQuery("SELECT * FROM room WHERE room_no='"+textFieldR.getText()+"'");
                    while (rs1.next()) {
                        int price = Integer.parseInt(rs1.getString("Price"));
                        int deposit = Integer.parseInt(textFieldamt.getText());
                        int pending = Math.max(0, price - deposit);
                        textFieldPending.setText(String.valueOf(pending));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldtime.getText();
                    String amt = textFieldamt.getText();

                    c.statement.executeUpdate("UPDATE patient_info SET Room_No='"+room+"', Time='"+time+"', Deposite='"+amt+"' WHERE Name='"+q+"'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(170,378,89,23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(950,500);
        setVisible(true);
        setLayout(null);
        setLocation(400,250);
    }
    public static void main(String args[]) {
        new Update_Patient_Details();
    }
}
